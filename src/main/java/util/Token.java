package util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 获取token
 */
public class Token {
    static String url="https://api.se.com/token";
    static Map<String, Object> paramMap=new HashMap<String, Object>();
    static String token;
    static Long interval=0L;

    public static void setToken() {
        if( System.currentTimeMillis()/(1000*60*30)!=interval || interval==0){
            interval=System.currentTimeMillis()/(1000*60*30);
            paramMap.put("grant_type","client_credentials");
            CloseableHttpClient httpClient = null;
            CloseableHttpResponse httpResponse = null;
            String result = "";
            // 创建httpClient实例
            httpClient = HttpClients.createDefault();
            // 创建httpPost远程连接实例
            HttpPost httpPost = new HttpPost(url);
            // 配置请求参数实例
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
                    .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
                    .setSocketTimeout(60000)// 设置读取数据连接超时时间
                    .build();
            // 为httpPost实例设置配置
            httpPost.setHeader("Authorization", "Basic NUdQQXEydndrdTk5Qk5leGpqWm9HMWN6SmlRdGEyRU06c1NYUmxKSEdPc29ob0tWRw==");

            httpPost.setConfig(requestConfig);
            // 设置请求头
            //httpPost
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            // 封装post请求参数
            if (null != paramMap && paramMap.size() > 0) {
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                // 通过map集成entrySet方法获取entity
                Set<Map.Entry<String, Object>> entrySet = paramMap.entrySet();
                // 循环遍历，获取迭代器
                Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
                while (((Iterator) iterator).hasNext()) {
                    Map.Entry<String, Object> mapEntry = iterator.next();
                    nvps.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue().toString()));
                }

                // 为httpPost设置封装好的请求参数
                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            try {
                // httpClient对象执行post请求,并返回响应参数对象
                httpResponse = httpClient.execute(httpPost);
                // 从响应对象中获取响应内容
                HttpEntity entity = httpResponse.getEntity();
                result = EntityUtils.toString(entity);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 关闭资源
                if (null != httpResponse) {
                    try {
                        httpResponse.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (null != httpClient) {
                    try {
                        httpClient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            int index=result.indexOf("\"access_token\" : \"")+18;
            String str=result.substring(index,index+28);


            token=str;

        }
    }
    public static String getToken() {
        Token.setToken();
        //System.out.println("token获取成功："+token);
        return token ;
    }
}
