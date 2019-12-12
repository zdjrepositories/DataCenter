package main;

import service.CategoryService;
import service.RangesService;

import java.io.IOException;
import java.util.Queue;


/**
 * 程序入口1234
 */
public class main {


    public static void main(String[] args) throws IOException {
       CategoryService categoryService = new CategoryService();
       Queue qategoryQueue = categoryService.run();
       RangesService rangeService = new RangesService();
       for (int i = 0; i < qategoryQueue.size(); i++) {
            rangeService.run((String) qategoryQueue.poll());
       }

//       String str="{\"pictureId\":\"205785\",\"ranges\":{\"pictureDescription\":\"IH, IHP, ITA  时间管理及照明控制元件\",\"rangeId\":\"62198\",\"pictureId\":\"545849\",\"rangeName\":\"IH, IHP, ITA  时间管理及照明控制元件\",\"id\":\"126703756\",\"shortDescription\":\"时间管理及照明控制元件\",\"rangeOriginalName\":\"Acti9 IH, IHP, ITA\"},\"categoryOriginalName\":\"Lighting & Time Management\",\"id\":\"86179\"}\n";
//        JSONObject object = JSONObject.parseObject(str);
//        //JSONObject respObj = object.getJSONObject("getRangesOfCatResponse").getJSONObject("return");
//
//        JSONObject objectw=object.getJSONObject("ranges");
//
//        System.out.println("测试："+objectw.getLongValue("rangeId"));
    }
}
