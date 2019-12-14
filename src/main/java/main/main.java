package main;

import service.CategoryService;
import service.NodetreebeanService;
import service.RangesService;
import util.SQLSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 程序入口1234
 */
public class main {


    public static void main(String[] args) throws IOException {
        //获取CategoryID
       CategoryService categoryService = new CategoryService();
       Queue rangesQueue = categoryService.run();
       //获取Ranges
       RangesService rangeService = new RangesService();
       for (int i = 0; i < rangesQueue.size(); i++) {
            rangeService.run((String) rangesQueue.poll());
       }
        SQLSession sqlSession = new SQLSession();
        List rangesQueues=sqlSession.getSqlsession().selectList("NodeMapper.selectNode");

       //获取Nodetree，得到Node

        NodetreebeanService nodetreebeanService=new NodetreebeanService();


//        for (int i = 0; i < rangesQueue.size(); i++) {
//            System.out.println(rangesQueue.get(i));
//          //  nodetreebeanService.run((String) rangesQueue.get(i));
//       }
//
        nodetreebeanService.run("2013");
        nodetreebeanService.run("60123");
        nodetreebeanService.run("60126");
        nodetreebeanService.run("61011");
        nodetreebeanService.run("61604");
        nodetreebeanService.run("61742");
        nodetreebeanService.run("61790");
        nodetreebeanService.run("61853");
        nodetreebeanService.run("62292");
        nodetreebeanService.run("62295");
        nodetreebeanService.run("62319");

        nodetreebeanService.run("817");

//        System.out.println("测试："+objectw.getLongValue("rangeId"));
    }
}
