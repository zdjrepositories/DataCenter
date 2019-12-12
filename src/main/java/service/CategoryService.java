package service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import pojo.CategoryId;
import util.Conf;
import util.HttpClient;
import util.Log4j;
import util.SQLSession;

import util.MD5;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Category id获取处理类
 */
public class CategoryService implements DataCenterService {
    //存储Category id
    private Queue<String> categoryQueue = new LinkedList<String>();
    //存储Category id数量
    private Long categoryNum = 0L;
    //数据存储
    private String data;

    private CategoryId categoryId;
    /**
     * Category id获取处理方法
     */
    public Queue run() {
        getData();
       // if (isRepeat("001")) {
          //  Summary();
        //}
        analyze();
        upData();
        System.out.println("categoryId:"+categoryNum);
        return categoryQueue;
    }
    /**
     * 获取数据
     */
    @Override
    public void getData() {
        //从配置文件获取Category id url
        String url = Conf.getConf().getCategoryId();
        String body = "{\"getFilter\": {\"filterBy\": \"Category\"}}";
        try {
            data = HttpClient.doPost(url, null, body);
        } catch (UnsupportedEncodingException e) {
            Log4j.getLog4j().error("发生异常：" + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void getData(String id) {

    }

    /**
     * 判断是否重复
     */
    @Override
    public boolean isRepeat(String id) {
        if (data != null && "".equals(data) ) {
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
        if (data != null && (!data.equals(""))) {
            JSONObject object = JSONObject.parseObject(data);
            JSONArray respObjs = object.getJSONObject("getFilterResponse").getJSONArray("return");
            for (int i = 0; i < respObjs.size(); i++) {
                object=respObjs.getJSONObject(i);
                categoryId=new CategoryId();
                categoryId.setCategory_id(object.getLongValue("valueId"));
                categoryId.setCount(object.getInteger("count"));
                categoryId.setCategory_name(object.getString("valueName"));
                categoryId.setOriginal_name(object.getString("valueOriginalName"));
                SQLSession sqlSession = new SQLSession();
                try {
                    sqlSession.getSqlsession().insert("CategoryIdMapper.insertCategoryId",  categoryId);
                    sqlSession.getSqlsession().commit();
                    System.out.println("CategoryId成功添加：" +  categoryId.getCategory_id());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                categoryQueue.add(object.getLongValue("valueId")+"");
                categoryNum++;
            }
        }
    }

    /**
     * 更新数据
     */
    @Override
    public void upData() {

    }
}
