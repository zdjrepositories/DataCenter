package util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * 邮件发送工具类
 *
 */
public class Mail{
    private static String _USER_NAME_ = "361406445@qq.com";//邮箱用户名
    private static String _PASSWORD_ = "aeymnoioitjubgfj";//授权码
    private static String _SMTP_ADDRESS_ = "smtp.qq.com";//
    private final static int _SMTP_PORT_SSL_ = 25;
    private static String from = "361406445@qq.com";


    /**
     * 发送邮件方法
     * @param toAddress
     * @param subject
     * @param content
     */
    public static void sendMail(String toAddress, String subject, String content){
        Email email = new SimpleEmail();
        email.setHostName(_SMTP_ADDRESS_);
        email.setSmtpPort(_SMTP_PORT_SSL_);
        email.setAuthenticator(new DefaultAuthenticator(_USER_NAME_, _PASSWORD_));
        //email.setSSLOnConnect(true);
        email.setSSLOnConnect(true);
        try {
            email.setFrom(from);
            email.setSubject(subject);
            email.setMsg(content);
            email.addTo(toAddress);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }


}