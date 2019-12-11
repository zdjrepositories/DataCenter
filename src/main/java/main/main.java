package main;

import service.impl.RequestServiceImpl;
import servlet.CategoryIdServlet;
import servlet.DateCenterServlet;
import util.Log4j;
import util.Token;

import java.io.IOException;


/**
 * 程序入口1234
 */
public class main {
        public static void main(String[] args) throws IOException {
            CategoryIdServlet dateCenterServlet=new CategoryIdServlet();
               dateCenterServlet.run();

        }

//                for (int i = 0; i <10 ; i++) {
//                      //  dateCenterServlet.sendMail("测试邮件,第"+i+"封");
//                }
//
//        }
}
