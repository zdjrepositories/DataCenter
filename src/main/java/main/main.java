package main;

import service.impl.RequestServiceImpl;

import java.io.IOException;


/**
 * 程序入口1234
 */
public class main {
        public static void main(String[] args) throws IOException {
//
                //        InputStream is = Resources.getResourceAsStream("mybatis");
//
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//
//        SqlSession session=factory.openSession();
//
//        Summary summary=(Summary) session.selectOne("SummaryMapper.selectSummary","035");
//
//        System.out.println(summary.getDate());
//        session.close();
                RequestServiceImpl requestServiceimpl=new RequestServiceImpl();
                // String str=requestServiceimpl.doGet( Conf.GetConf().getUrl());


                System.out.println();
//        String subject = "测试邮件";
//        String content = "test test test。。。测试内容。。。这是从DataCenter发来的。";
//        String to = "zdjyx126@126.com";
//        Mail.sendMail(to, subject, content); 915485DEC53809B01DA0AE2074E1DB05
        }
}
