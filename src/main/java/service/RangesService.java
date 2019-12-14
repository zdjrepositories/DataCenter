package service;

import com.alibaba.fastjson.JSONArray;
import pojo.Category;
import pojo.Ranges;
import queue.DataCenterQueue;
import queue.DataCenterQueueFactory;
import com.alibaba.fastjson.JSONObject;
import util.*;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Queue;

public class RangesService implements DataCenterService {
    //存储Category id
    private static Queue<String> rangeQueue = new LinkedList<String>();
    //存储Category id数量
    private static Long rangeNum = 0L;
    //数据存储
    private String data=null;
    private Ranges ranges;

    public  Queue<String> getRangeQueue() {
        return rangeQueue;
    }

    public Long getRangeNum() {
        return rangeNum;
    }

    public Queue run(Queue categoryQueue) {
        if (categoryQueue != null || categoryQueue.size() > 0)
            for (int i = 0; i < categoryQueue.size(); i++) {
                String categoryid=categoryQueue.poll().toString();
                run(categoryid);
            }
        return rangeQueue;
    }




    public void run(String categoryid)  {
        getData(categoryid);
        if (isRepeat(categoryid)) {
            Summary();
        }
        ranges=new Ranges();
        ranges.setCategory_id(Long.parseLong(categoryid));
        analyze();
        upData();


    }
    /**
     * 获取数据
     */
    @Override
    public void getData() {

    }

    @Override
    public void getData(String id) {
        String url = Conf.getConf().getRange();
        String body = "{\"getRangesOfCat\": {\"categoryId\": \"" + id + "\"}}";
        try {
            data = HttpClient.doPost(url, null, body);
        } catch (UnsupportedEncodingException e) {
            Log4j.getLog4j().error("发生异常：" + e.toString());
            e.printStackTrace();
        }
    }


    /**
     * 判断是否重复
     */
    @Override
    public boolean isRepeat(String id) {
        if (data != null && "".equals(data)) {
            SQLSession sqlSession = new SQLSession();
            try {
                String summary = sqlSession.getSqlsession().selectOne("SummaryMapper.selectSummary", id);
                if (MD5.getMD5(data).equals(summary)) {
                    return true;
                }
            } catch (IOException e) {
                Log4j.getLog4j().error("发生异常：" + e.toString());
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 未重复保存摘要
     */
    @Override
    public void Summary() {

    }
    /**
     * 解析数据
     */
    @Override
    public void analyze() {
        if (data != null && !"".equals(data)) {
            JSONObject respObj = JSONObject.parseObject(data).getJSONObject("getRangesOfCatResponse").getJSONObject("return");
            if (respObj != null && !"".equals(respObj.toString())) {
                if(respObj.toString().indexOf("[{")!=-1) {
                    JSONArray respObjs=respObj.getJSONArray("ranges");
                    if (!"".equals(respObjs) && respObjs.size() > 0) {
                        System.out.println(respObj.getJSONArray("ranges").size());
                        for (int i = 0; i < respObjs.size(); i++) {
                            respObj=respObjs.getJSONObject(i);
                            System.out.println("当前Range：" +respObj.getLongValue("rangeId"));
                            ranges.setId(respObj.getLongValue("rangeId"));
                            ranges.setPicture_desc(respObj.getString("pictureDescription"));
                            ranges.setShort_des(respObj.getString("shortDescription"));
                            ranges.setOrigin_name(respObj.getString("rangeOriginalName"));
                            ranges.setRange_name(respObj.getString("rangeName"));
                            ranges.setPicture_id(respObj.getLongValue("pictureId"));
                            rangeQueue.add(respObj.getString("rangeId"));
                            rangeNum++;
                            //System.out.println(range.toString());
                            SQLSession sqlSession = new SQLSession();
                            try {
                                sqlSession.getSqlsession().insert("RangesMapper.insertRanges", ranges);
                                sqlSession.getSqlsession().commit();
                                System.out.println("Range成功添加：" + ranges.getId());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }else {
                    respObj=respObj.getJSONObject("ranges");
                    System.out.println("当前Ranges：" + respObj.getLongValue("rangeId"));
                    ranges.setId(respObj.getLongValue("rangeId"));
                    ranges.setPicture_desc(respObj.getString("pictureDescription"));
                    ranges.setShort_des(respObj.getString("shortDescription"));
                    ranges.setOrigin_name(respObj.getString("rangeOriginalName"));
                    ranges.setRange_name(respObj.getString("rangeName"));
                    ranges.setPicture_id(respObj.getLongValue("pictureId"));
                    rangeQueue.add(respObj.getString("rangesId"));
                    rangeNum++;
                    //System.out.println(range.toString());
                    SQLSession sqlSession = new SQLSession();
                    try {
                        sqlSession.getSqlsession().insert("RangesMapper.insertRanges", ranges);
                       sqlSession.getSqlsession().commit();
                        System.out.println("Range成功添加：" + ranges.getId());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
/**
 * public void upData() {
 */
    /**
     * 更新数据
     */
    @Override
    public void upData() {
        if(data!=null && !"".equals(data)){
            JSONObject object = JSONObject.parseObject(data);
            JSONObject respObj = object.getJSONObject("getRangesOfCatResponse").getJSONObject("return");
            //System.out.println(respObj.toString());
            Category category = new Category();
            System.out.println("当前Category：" + respObj.getLongValue("id"));
            category.setId(respObj.getLongValue("id"));
            category.setCategory_name(respObj.getString("categoryName"));
            category.setOrigin_name(respObj.getString("categoryOriginalName"));
            category.setPicture_id(respObj.getString("pictureId"));
            category.setPicture_desc(respObj.getString("pictureDescription"));
            category.setBu_id((Integer) respObj.get("bu_id"));
           // System.out.println(category.toString());
           // if(category.getId()!=null && category.getId().equals("")) {
                SQLSession sqlSession = new SQLSession();
                try {
                    sqlSession.getSqlsession().insert("CategoryMapper.insertCategory", category);
                    sqlSession.getSqlsession().commit();
                    System.out.println("Category成功添加：" + category.getId() );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            //}
        }
    }
}
