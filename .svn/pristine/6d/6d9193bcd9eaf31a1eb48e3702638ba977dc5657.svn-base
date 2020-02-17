package com.lemon.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ReadTxt {
	
	/*public static void main(String[] args) { 
        System.out.println(read(16102969,16111045));
    } */
    public static String read(String path,Integer from ,Integer to){
        String result="";
        int HttpResult; // 服务器返回的状态
        byte[] result2=new byte[to-from+1];
        try{
        	URL url =new URL(path); // 创建URL
            URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
            urlconn.connect();
            HttpURLConnection httpconn =(HttpURLConnection)urlconn;
            HttpResult = httpconn.getResponseCode();
            if(HttpResult != HttpURLConnection.HTTP_OK) {
                System.out.print("无法连接到");
            } else {
                int filesize = urlconn.getContentLength(); // 取数据长度
                BufferedInputStream bis = new BufferedInputStream(urlconn.getInputStream());
            /*FileInputStream fis=new FileInputStream("d:\\斗破苍穹.txt");
            BufferedInputStream bis=new BufferedInputStream(fis);*/
             bis.skip(from-1);
            bis.read(result2, 0, to-from+1);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return new String(result2);
    }
	
	
	
	/*public void readTxt(String filePath) {

		File file = new File(filePath);
		StringBuilder result = new StringBuilder();
		int HttpResult; // 服务器返回的状态
		try {
			URL url =new URL(filePath); // 创建URL
            URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
            urlconn.connect();
            HttpURLConnection httpconn =(HttpURLConnection)urlconn;
            HttpResult = httpconn.getResponseCode();
            if(HttpResult != HttpURLConnection.HTTP_OK) {
                System.out.print("无法连接到");
            } else {
                int filesize = urlconn.getContentLength(); // 取数据长度
                urlconn.getInputStream().skip(44);
                byte[] bs = new byte[5635];
                System.out.println(urlconn.getInputStream().read(bs));
            }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		new ReadTxt().readTxt("http://pry165fg6.bkt.clouddn.com/test.txt");
	}*/
}
