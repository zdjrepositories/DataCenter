package servlet;

import queue.DataCenterQueue;
import queue.DataCenterQueueFactory;
import com.alibaba.fastjson.JSONObject;
import util.Conf;
import util.HttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CategoryIdServlet  {

    DataCenterQueue categoryIdQueue= DataCenterQueueFactory.getQueue("CategoryId");

    public static void run() throws IOException { System.out.println("asdasn");
        RangeServlet rangeServlet=new RangeServlet();
        String url=Conf.getConf().getCategoryId();
        String body = "{\"getFilter\": {\"filterBy\": \"Category\"}}";
        String data=HttpClient.doPost(url,null , body);
        System.out.println("asdasn");
        //MD5.getMD5(data);
        JSONObject object = JSONObject.parseObject(data);
        JSONObject respObj = object.getJSONObject("getFilterResponse");

        for (int i = 0; i < respObj.getJSONArray("return").size(); i++) {
            String str=JSONObject.parseObject(respObj.getJSONArray("return").get(i).toString()).getLongValue("valueId")+"";
            System.out.println(JSONObject.parseObject(respObj.getJSONArray("return").get(i).toString()).getLongValue("valueId"));
            //categoryIdQueue.addItem(str);
            rangeServlet.run(str);
        }


    }


}
