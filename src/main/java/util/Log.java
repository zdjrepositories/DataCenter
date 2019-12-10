package util;


import org.apache.ibatis.io.ResolverUtil;
import org.apache.log4j.Logger;

/**
 * 日志生成类
 */
public class Log {
    private static Log log=null;
    private static Logger logger=null;
    private Log(){
        Logger logger = Logger.getLogger(ResolverUtil.Test.class);
    }

    /**
     * 添加日志
     * @param content
     */
    public static void addLog(String content){
        if(log==null){
            synchronized (Log.class){
                if(log==null){
                    log=new Log();
                }
            }
        }
        if(logger!=null){
            logger.debug("content");
        }
    }





}
