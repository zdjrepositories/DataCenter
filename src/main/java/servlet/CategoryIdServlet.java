package servlet;

import com.alibaba.fastjson.JSONObject;
import service.impl.SummaryServiceImpl;
import servlet.DateCenterServlet;
import util.Conf;
import util.HttpClient;
import util.MD5;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.Format;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryIdServlet  {



    public void run() throws UnsupportedEncodingException {
        String url=Conf.GetConf().getCategoryId();
        String body = "{\"getFilter\": {\"filterBy\": \"Category\"}}";
        String data=HttpClient.doPost(url,null , body);
        System.out.println(data);
        //MD5.getMD5(data);
        JSONObject object = JSONObject.parseObject(data);
        JSONObject respObj = object.getJSONObject("getFilterResponse");
        for (int i = 0; i < respObj.getJSONObject("return").getJSONArray("ranges").size(); i++) {
            System.out.println(JSONObject.parseObject(respObj.getJSONObject("return").getJSONArray("ranges").get(i).toString()).getLongValue("pictureId"));
        }
    }


}
