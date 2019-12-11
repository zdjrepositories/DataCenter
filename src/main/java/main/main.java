package main;

import service.impl.RequestServiceImpl;
import servlet.CategoryIdServlet;
import servlet.DateCenterServlet;
import servlet.RangeServlet;
import util.Conf;
import util.Log4j;
import util.Token;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 程序入口1234
 */
public class main {
        public static void main(String[] args) throws IOException {
           CategoryIdServlet dateCenterServlet=new CategoryIdServlet();
           CategoryIdServlet.run();

            //System.out.println(System.currentTimeMillis()/(1000*60*30));// new Date()为获取当前系统时间



        }

//                for (int i = 0; i <10 ; i++) {
//                      //  dateCenterServlet.sendMail("测试邮件,第"+i+"封");
//                }
//
//        }
}
