package servlet;

import pojo.Category;
import queue.DataCenterQueue;
import queue.DataCenterQueueFactory;
import com.alibaba.fastjson.JSONObject;
import util.Conf;
import util.HttpClient;
import util.SQLSession;
import util.Token;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class RangeServlet {

    DataCenterQueue rangeQueue = DataCenterQueueFactory.getQueue("Range");

    public void run(String rangeId) throws IOException {
        String url = Conf.getConf().getRange();
        String body = "{\"getRangesOfCat\": {\"categoryId\": \"" + rangeId + "\"}}";
     //  System.out.println(body.toString());
        String data = HttpClient.doPost(url, null, body);
        //MD5.getMD5(data);


        JSONObject object = JSONObject.parseObject(data);
       // System.out.println(object.toString());

        JSONObject respObj = object.getJSONObject("getRangesOfCatResponse").getJSONObject("return");
        //System.out.println(respObj.toString());
        Category category=new Category();
        category.setId( respObj.getLongValue("id"));
        category.setCategory_name(respObj.getString("categoryName"));
        category.setOrigin_name(respObj.getString("categoryOriginalName"));
        category.setPicture_id(respObj.getString("pictureId"));
        category.setPicture_desc(respObj.getString("pictureDescription"));
        category.setBu_id((Integer) respObj.get("bu_id"));

        System.out.println(category.toString());
        // if(category.getId()!=null && category.getId().equals("")) {
             SQLSession sqlSession = new SQLSession();
             sqlSession.getSqlsession().insert("CategoryMapper.insertCategory", category);
             sqlSession.getSqlsession().commit();
             System.out.println("成功添加：" + category.getId() + "--" + category.getCategory_name());
        // }
        //Category category=JSONObject.toJavaObject(object, Category.class);
        //JSONObject.parseObject(respObj.toString()).
//            //System.out.println(respObj.getJSONArray("return").toString());
//            for (int i = 0; i < respObj.getJSONArray("return").size(); i++) {
//                String str=JSONObject.parseObject(respObj.getJSONArray("return").get(i).toString()).getLongValue("valueId")+"";
//                System.out.println(JSONObject.parseObject(respObj.getJSONArray("return").get(i).toString()).getLongValue("valueId"));
//                categoryIdQueue.addItem(str);
//            }
       // System.out.println(object.toString());

    }


}
