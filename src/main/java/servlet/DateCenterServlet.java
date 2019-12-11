package servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Summary;
import service.impl.RequestServiceImpl;
import util.Conf;
import util.HttpClient;
import util.MD5;
import util.Mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据中心主控制类
 */
public interface DateCenterServlet {
    /**
     *
     */
    public void run();
    /**
     * 获取配置
     * @return
     */
    public String getConf();

    /**
     * get获取数据
     * @param url
     * @param map
     * @return
     */
    public String getData(String url,Map<String,String> map );

    /**
     * post获取数据
     * @param url
     * @param map
     * @param data
     * @return
     */
    public String postData(String url,Map<String,String> map ,String data );
    /**
     * 判断MD5是否重复
     */
    public boolean isRepetition(String id,Map<String,String> map ,String data);

    /**
     * 保存数据
     * @param list
     * @return
     */
    public boolean savaData( List<Object> list);

    /**
     * 保存数据
     * @param object
     * @return
     */


}
