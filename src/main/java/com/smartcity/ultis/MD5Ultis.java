package com.smartcity.ultis;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ZJDX on 2016/10/8.
 */
public class MD5Ultis {
    /**
     * 对字符串md5加密
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
            String re = null;
            byte encrypt[];
            try {
                byte[] tem = str.getBytes();
                MessageDigest md5 = MessageDigest.getInstance("md5");
                md5.reset();
                md5.update(tem);
                encrypt = md5.digest();
                StringBuilder sb = new StringBuilder();
                for (byte t : encrypt) {
                    String s = Integer.toHexString(t & 0xFF);
                    if (s.length() == 1) {
                        s = "0" + s;
                    }
                    sb.append(s);
                }
                re = sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        System.out.println("MD5:"+re);
            return re;
        }
}
