package com.lemon.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.lemon.pojo.TitleInfo;

public class NovelParser{

    private String path;
    private String name;
    private List<TitleInfo> titleList;

    public static final int MAX_PARSE_NUMBER = 200;

    public NovelParser(String path){
        this.path = path;
        titleList = new ArrayList<>();
        int index = path.lastIndexOf("\\");
        /*name = index == -1 ? path : path.substring(index + 1,path.lastIndexOf("."));*/
        name = "前言";
    }

    //execute only once
    public List<TitleInfo> Catalog(){
    	int HttpResult; // 服务器返回的状态
        long time = System.currentTimeMillis();
        int count = 0;
        String charset = "utf8";
        BufferedReader reader = null;
        InputStreamReader inputStreamReader = null;
        FileInputStream inputStream = null;
        try {
        	
        	URL url =new URL(path); // 创建URL
            URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
            urlconn.connect();
            HttpURLConnection httpconn =(HttpURLConnection)urlconn;
            HttpResult = httpconn.getResponseCode();
            if(HttpResult != HttpURLConnection.HTTP_OK) {
                System.out.print("无法连接到");
            } else {
                int filesize = urlconn.getContentLength(); // 取数据长度
                inputStreamReader = new InputStreamReader(urlconn.getInputStream(),charset);
                reader = new BufferedReader(inputStreamReader);
        	
            /*inputStream = new FileInputStream(path);
            inputStreamReader = new InputStreamReader(inputStream,charset);
            reader = new BufferedReader(inputStreamReader);*/

            String line;
            //之所以设置这个变量是因为有的TXT文档会在一章的开头将标题重复一遍，造成一章内容被解析成两章
            //所以设置一个最小行数，两个章节之间的行数差距最小为5
            int number = 5;

            //因为一般的TXT文档开头都会有一些介绍性信息，这些不能被归到第一章中，所以单独新建一个章节保存起来
            TitleInfo titleInfo = new TitleInfo();
            titleInfo.setTitle(name);
            titleInfo.setIndex(0);
            titleInfo.setStartLength(0);
            titleList.add(titleInfo);
            System.out.println("书籍开始章节 : " + titleInfo.toString());

            StringBuilder builder = new StringBuilder();
            int parseLength = 0;

            while ((line = reader.readLine()) != null){
                line = line.trim();
                if(line.equals("")){
                    parseLength += 2;//这里的+2是因为要加上换行的长度
                    continue;
                }
                if(line.trim().length() < 4){
                    if(number >= 5 && TitleMatches.isExtra(line)) {//如果是额外章节
                        count++;
                        parseLength += builder.toString().getBytes(charset).length;
                        builder.delete(0,builder.length());
                        titleInfo = new TitleInfo(count, line, parseLength,0);
                        titleList.add(titleInfo);
                        titleList.get(titleList.size()-2).setEndLength(parseLength);
                        number = 0;
                        System.out.println("检测到额外章节" + titleInfo.toString());
                    }
                }else{
                    if(number >= 5 && TitleMatches.isZhang(line)){//如果是正文章节
                        count++;
                        parseLength += builder.toString().getBytes(charset).length;
                        builder.delete(0,builder.length());
                        titleInfo = new TitleInfo(count,line, parseLength,0);
                        titleList.add(titleInfo);
                        titleList.get(titleList.size()-2).setEndLength(parseLength);
                        //System.out.println(parseLength);
                        //System.out.println("aaa:"+titleList.get(titleList.size()-1).toString());
                        //System.out.println("bbbb:"+titleList.get(titleList.size()-2).toString());
                        number = 0;
                        //System.out.println("检测到新章节" + titleInfo.toString());
                    }
                }

                builder.append(line);
                parseLength += 2;
                number++;
                if(number >= MAX_PARSE_NUMBER){
                    //为了避免某个文档一直没有匹配到新章节而不停的向StringBuilder中添加内容,导致Android内存溢出，这里对StringBuilder的大小进行了一定的限制
                    //即解析的行数达到一定的数目之后，即使没有匹配到新章节也将StringBuilder清空，同时更新parseLength。
                    //注意：这个数目的设定会影响到解析的时间，请谨慎设置!!!!
                    parseLength += builder.toString().getBytes(charset).length;
                    builder.delete(0,builder.length());
                    number = 5;
                }
            }
            titleList.get(titleList.size()-1).setEndLength(filesize);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("执行完毕，耗时 : " + (System.currentTimeMillis() - time) + ",检测到" + titleList.size() + "章");
            return titleList;
        }
    }
    
    /*public static void main(String[] args){
        NovelParser parser = new NovelParser("http://pry165fg6.bkt.clouddn.com/那些回不去的年少时光/txt");
        System.out.println(parser.Catalog().toString());
    }*/
}