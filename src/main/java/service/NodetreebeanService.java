package service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import pojo.Category;
import pojo.Node;
import pojo.Nodetreebean;
import util.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Queue;

public class NodetreebeanService implements DataCenterService {
    //存储Category id
    private Queue<String> nodetreebeanQueue = new LinkedList<String>();
    //存储Category id
    private Queue<String> nodeQueue = new LinkedList<String>();
    //存储Category id数量
    private Long nodetreebeanNum = 0L;
    //数据存储
    private String data=null;
    private Nodetreebean nodetreebean;
    private Node node;
    private Long nodeNum = 0L;

    public Queue run(Queue rangesQueue) {
        if (rangesQueue != null || rangesQueue.size() > 0)
            for (int i = 0; i < rangesQueue.size(); i++) {
                String rangesid=rangesQueue.poll().toString();
                run(rangesid);
            }
        return nodeQueue;
    }




    public void run(String rangesid)  {
        System.out.println("rangesid："+rangesid);
        getData(rangesid);
        if (isRepeat(rangesid)) {
            Summary();
        }
        upData();
        analyze();



    }
    /**
     * 获取数据
     */
    @Override
    public void getData() {

    }

    @Override
    public void getData(String id) {
        String url = Conf.getConf().getNodetreebean()+id;
        data = HttpClient.doGet(url);
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
     * 解析数据Nodetree
     */
    public void analyzeNodetree(String str) {
        if (str!= null && (!str.equals(""))) {
            JSONObject object = JSONObject.parseObject(str);
            nodetreebean.setOid(object.getLongValue( "@oid"));
            nodetreebean.setName(object.getString("@name"));
            nodetreebean.setCommercial_References("@commercialReferences");
            nodetreebean.setHas_Configurable(object.getBooleanValue("@hasConfigurable"));
            nodetreebean.setHas_Document(object.getBooleanValue("@hasDocument"));
            nodetreebean.setHas_Product(object.getBooleanValue("@hasProduct"));
            nodetreebean.setHas_RichText(object.getBooleanValue("@hasRichText"));
            nodetreebean.setVisible(object.getBooleanValue("@visible"));
            SQLSession sqlSession = new SQLSession();
            try {
                sqlSession.getSqlsession().insert("NodetreebeanMapper.insertNodetreebean",  nodetreebean);
                sqlSession.getSqlsession().commit();
                System.out.println("Nodetreebean成功添加：" +  nodetreebean.getOid());
            } catch (IOException e) {
                e.printStackTrace();
            }
            nodetreebeanQueue.add(object.getLongValue("valueId")+"");
            nodetreebeanNum++;
        }
    }
    /**
     * 解析数据Node
     */
    public void analyzeNode(String str) {
        if (str!= null && (!str.equals(""))) {
            JSONObject object = JSONObject.parseObject(str);
            node.setOid(object.getLongValue( "@oid"));
            node.setName(object.getString("@name"));
            node.setCommercial_References(object.getString("@commercialReferences"));
            node.setSub_Nodes(object.getString("subNodes"));
            node.setDescription(object.getString("description"));
            node.setHas_Configurable(object.getBooleanValue("@hasConfigurable"));
            node.setHas_Document(object.getBooleanValue("@hasDocument"));
            node.setHas_Product(object.getBooleanValue("@hasProduct"));
            node.setHas_RichText(object.getBooleanValue("@hasRichText"));
            node.setVisible(object.getBooleanValue("@visible"));
            System.out.println("Node：" +node.toString());
            SQLSession sqlSession = new SQLSession();
            try {
                sqlSession.getSqlsession().insert("NodeMapper.insertNode",  node);
                sqlSession.getSqlsession().commit();
                System.out.println("Node成功添加：" +  node.getOid());
            } catch (IOException e) {
                e.printStackTrace();
            }
            nodeQueue.add(respObj.getLongValue( "@oid")+"");
            nodeNum++;
        }
    }
    /**
     * 解析数据
     */
    @Override
   public void analyze() {
        Node node =new Node();
        node.setParent_oid(nodetreebean.getOid());
        if (data != null && (!data.equals(""))) {
            Nodetreebean nodetreebean=new Nodetreebean();
            JSONObject respObj = JSONObject.parseObject(data).getJSONObject("getNodeTreeFromRangeIdResponse").getJSONObject("NodeTreeBean").getJSONObject("subNodes");

            if (respObj != null && !"".equals(respObj.toString())) {
                if(respObj.toString().indexOf("[{")!=-1) {
                    JSONArray respObjs=respObj.getJSONArray("node");
                    if (!"".equals(respObjs) && respObjs.size() > 0) {
                        System.out.println(respObj.getJSONArray("node").size());
                        for (int i = 0; i < respObjs.size(); i++) {
                            respObj=respObjs.getJSONObject(i);
                            System.out.println("当前Node：" +respObj.getLongValue( "@oid"));
                            node.setOid(respObj.getLongValue( "@oid"));
                            node.setName(respObj.getString("@name"));
                            node.setCommercial_References(respObj.getString("@commercialReferences"));
                            node.setSub_Nodes(respObj.getString("subNodes"));
                            node.setDescription(respObj.getString("description"));
                            node.setHas_Configurable(respObj.getBooleanValue("@hasConfigurable"));
                            node.setHas_Document(respObj.getBooleanValue("@hasDocument"));
                            node.setHas_Product(respObj.getBooleanValue("@hasProduct"));
                            node.setHas_RichText(respObj.getBooleanValue("@hasRichText"));
                            node.setVisible(respObj.getBooleanValue("@visible"));
                            System.out.println("Node：" +node.toString());
                            SQLSession sqlSession = new SQLSession();
                            try {
                                sqlSession.getSqlsession().insert("NodeMapper.insertNode",  node);
                                sqlSession.getSqlsession().commit();
                                System.out.println("Node成功添加：" +  node.getOid());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            nodeQueue.add(respObj.getLongValue( "@oid")+"");
                            nodeNum++;
                        }
                    }
                }else {
                    respObj=respObj.getJSONObject("node");
                    System.out.println("当前Node：" + respObj.getLongValue("@oid"));
                    node.setOid(respObj.getLongValue( "@oid"));
                    node.setName(respObj.getString("@name"));
                    node.setCommercial_References(respObj.getString("@commercialReferences"));
                    node.setSub_Nodes(respObj.getString("subNodes"));
                    node.setDescription(respObj.getString("description"));
                    node.setHas_Configurable(respObj.getBooleanValue("@hasConfigurable"));
                    node.setHas_Document(respObj.getBooleanValue("@hasDocument"));
                    node.setHas_Product(respObj.getBooleanValue("@hasProduct"));
                    node.setHas_RichText(respObj.getBooleanValue("@hasRichText"));
                    node.setVisible(respObj.getBooleanValue("@visible"));
                    SQLSession sqlSession = new SQLSession();
                    try {
                        sqlSession.getSqlsession().insert("NodeMapper.insertNode",  node);
                        sqlSession.getSqlsession().commit();
                        System.out.println("Node成功添加：" +  node.getOid());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    nodeQueue.add(respObj.getLongValue("@oid")+"");
                    nodeNum++;
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
        if (data != null && (!data.equals(""))) {
            nodetreebean=new Nodetreebean();
            JSONObject object = JSONObject.parseObject(data);
            object = object.getJSONObject("getNodeTreeFromRangeIdResponse").getJSONObject("NodeTreeBean");
            if(isArray(object.toString())){
                if(isNode(object.toString())){

                }else{

                }
            }else{

            }









            data= object.toString();
            nodetreebean.setOid(object.getLongValue( "@oid"));
            nodetreebean.setName(object.getString("@name"));
            nodetreebean.setCommercial_References("@commercialReferences");
            nodetreebean.setHas_Configurable(object.getBooleanValue("@hasConfigurable"));
            nodetreebean.setHas_Document(object.getBooleanValue("@hasDocument"));
            nodetreebean.setHas_Product(object.getBooleanValue("@hasProduct"));
            nodetreebean.setHas_RichText(object.getBooleanValue("@hasRichText"));
            nodetreebean.setVisible(object.getBooleanValue("@visible"));
            SQLSession sqlSession = new SQLSession();
            try {
                    sqlSession.getSqlsession().insert("NodetreebeanMapper.insertNodetreebean",  nodetreebean);
                    sqlSession.getSqlsession().commit();
                    System.out.println("Nodetreebean成功添加：" +  nodetreebean.getOid());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            nodetreebeanQueue.add(object.getLongValue("valueId")+"");
            nodetreebeanNum++;
            }
        }

    /**
     * 判断是否为数组
     * @param str
     * @return
     */
    public boolean isArray(String str) {
            if (str != null && !"".equals(str)) {
                if (str.indexOf("[{") > 3) {
                    return true;
                }
            }
            return false;
        }
    /**
     *判读是否为叶子节点
     */
    public boolean isNode(String str) {
        if (str != null && !"".equals(str)) {
            if (!(str.charAt(str.indexOf("\"subNodes\": ")+12)+"").equals("{")) {
                return true;
            }
        }
        return false;
    }
}

