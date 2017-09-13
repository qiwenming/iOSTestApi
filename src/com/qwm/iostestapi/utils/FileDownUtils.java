package com.qwm.iostestapi.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: wiming
 * @date: 2017-09-13 13:22:02  星期三
 * @decription:
 * 文件下载
 */
public class FileDownUtils {
    public static boolean saveUrlAs(String netAddr, String fileName) {
        //此方法只能用户HTTP协议
        try {
            URL url = new URL(netAddr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            DataInputStream in = new DataInputStream(connection.getInputStream());
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
            byte[] buffer = new byte[4096];
            int count = 0;
            while ((count = in.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
            out.close();
            in.close();
            System.out.println("===========================");
            System.out.println("线程："+Thread.currentThread());
            System.out.println(netAddr +"\n下载完成了，存储在\n"+fileName);
            System.out.println("===========================");
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
