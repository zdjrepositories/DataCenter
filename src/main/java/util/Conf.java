package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 配置文件读取
 */
public class Conf {
    private int cycle;
    private String starttime;
    private String categoryId;
    private String range;
    private String node;
    private String subNode;
    private String products;

    private volatile static Conf conf=null;

    /**
     * 单例方式创建类
     */
    private Conf(){
        Properties properties=new Properties();
        InputStream inputStream=Object.class.getResourceAsStream("/conf.properties");
        InputStreamReader inputStreamReader=null;

        try { inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
            properties.load(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.cycle=Integer.parseInt(properties.getProperty("cycle")); ;
        this.starttime=properties.getProperty("starttime");
        this.categoryId=properties.getProperty("categoryId");
        this.range=properties.getProperty("range");
        this.node=properties.getProperty("node");
        this.subNode=properties.getProperty("subNode");
        this.products=properties.getProperty("products");
    }
    /**
     * 获取类实例
     * @return
     */
    public static Conf getConf() {
        if(conf==null ||conf.equals("")){
            synchronized (Conf.class){
                if(conf ==null||conf.equals("")){
                    conf= new Conf();
                }
            }
        }
        return conf;
    }

    @Override
    public String toString() {
        return "Conf{" +
                "cycle=" + cycle +
                ", starttime='" + starttime + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", range='" + range + '\'' +
                ", node='" + node + '\'' +
                ", subNode='" + subNode + '\'' +
                ", products='" + products + '\'' +
                '}';
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getSubNode() {
        return subNode;
    }

    public void setSubNode(String subNode) {
        this.subNode = subNode;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }



}
