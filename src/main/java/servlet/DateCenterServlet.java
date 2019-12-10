package servlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import service.impl.RequestServiceImpl;
import util.Mail;

import java.io.IOException;
import java.io.InputStream;

/**
 * 数据中心主控制类
 */
public class DateCenterServlet {
    public void run() throws IOException {
//                InputStream is = Resources.getResourceAsStream("mybatis");
//
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//
//        SqlSession session=factory.openSession();
//
//        Summary summary=(Summary) session.selectOne("SummaryMapper.selectSummary","035");
//
//        System.out.println(summary.getDate());
//        session.close();
//        RequestServiceImpl requestServiceimpl=new RequestServiceImpl();
//         String str=requestServiceimpl.doGet( Conf.GetConf().getUrl());
//


    }


    public void getData(){

    }

    /**
     * 发送邮件
     * @param content
     */
    public void sendMail(String content){
        Mail mail=new Mail();
        mail.sendMail(content);
    }
}
