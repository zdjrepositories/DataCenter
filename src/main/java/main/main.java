package main;

import service.impl.RequestServiceImpl;
import servlet.DateCenterServlet;

import java.io.IOException;


/**
 * 程序入口1234
 */
public class main {
        public static void main(String[] args) throws IOException {
                DateCenterServlet dateCenterServlet=new DateCenterServlet();
                dateCenterServlet.sendMail("测试邮件");
        }
}
