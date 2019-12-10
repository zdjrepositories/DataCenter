package servlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Summary;
import service.impl.RequestServiceImpl;
import util.Conf;
import util.MD5;
import util.Mail;

import java.io.IOException;
import java.io.InputStream;

/**
 * 数据中心主控制类
 */
public class DateCenterServlet {
    public void run() throws IOException {
                InputStream is = Resources.getResourceAsStream("mybatis");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session=factory.openSession();

        Summary summary=(Summary) session.selectOne("SummaryMapper.selectSummary","001");

        System.out.println(summary.getDate());
        session.close();
        RequestServiceImpl requestServiceimpl=new RequestServiceImpl();
         String str=requestServiceimpl.doGet( Conf.GetConf().getUrl());



    }

    /**
     * 获取数据
     */
    public void getData(){

    }
    /**
     * 判断MD5是否重复
     */
    public boolean isRepetition(String id,String data){
//        String md5=MD5.getMD5(String data);
//        Summary summary=new Summary();
//        summary.getSummary(id);
        return true;//md5.equals("");

    }
    /**
     * json转为对象
     */
    /**
     *存储数据，并统计
     */

    /**
     * 发送邮件
     * @param content
     */
    public void sendMail(String content){
        Mail mail=new Mail();
        mail.sendMail(content);
    }
}
