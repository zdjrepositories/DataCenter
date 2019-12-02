package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class DataCenterConf {
    private String url;
    private int cycle;
    private String databaseUrl;
    private String databaseUsername;
    private String databasePassword;
    private volatile static DataCenterConf conf;

    private DataCenterConf(){
        Properties properties=new Properties();
        InputStream inputStream=Object.class.getResourceAsStream("/datacenter.properties");
        InputStreamReader inputStreamReader=null;

        try { inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
            properties.load(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.url=properties.getProperty("url");
        this.cycle=Integer.parseInt(properties.getProperty("cycle")); ;
        this.databaseUrl=properties.getProperty("databaseUrl");
        this.databaseUsername=properties.getProperty("databaseUsername");
        this.databasePassword=properties.getProperty("databasePassword");
    }

    public static DataCenterConf GetConf(){
        if(conf==null){
            synchronized (DataCenterConf.class){
                if(conf==null){
                    conf=new DataCenterConf();
                }
            }
        }
        return conf;
    }


    @Override
    public String toString() {
        return "GetConf{" +
                "url='" + url + '\'' +
                ", cycle=" + cycle +
                ", databaseUrl='" + databaseUrl + '\'' +
                ", databaseUsername='" + databaseUsername + '\'' +
                ", databasePassword='" + databasePassword + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }
}
