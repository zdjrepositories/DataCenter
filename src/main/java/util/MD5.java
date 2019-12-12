package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String MD5;
    public  static String getMD5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");//获取MD5实例
            md.update((plainText+plainText.length()).getBytes());//传入原文的byte类型值
                byte[] digest = md.digest();//获取md5摘要后的byte类型值
                int i;
                StringBuilder sb = new StringBuilder();
                for (int offset = 0; offset < digest.length; offset++) {
                    i = digest[offset];
                    if (i < 0)
                        i += 256;
                    if (i < 16)
                        sb.append(0);
                    sb.append(Integer.toHexString(i).toUpperCase());//通过Integer.toHexString方法把值变为16进制
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
}
