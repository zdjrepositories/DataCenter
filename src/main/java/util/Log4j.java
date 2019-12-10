package util;


import org.apache.ibatis.io.ResolverUtil;
import org.apache.log4j.Logger;

/**
 * 日志生成简化类
 */
public class Log4j {
    private static Logger logger=Logger.getLogger(ResolverUtil.Test.class);
    private Log4j(){
    }

    /**
     * 获取Logger
     * @return
     */
    public static Logger getLog4j(){
        return logger;
    }





}
