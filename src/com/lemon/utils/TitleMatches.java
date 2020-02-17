package com.lemon.utils;

import java.util.regex.Pattern;

/**
 * 这个类用来判断某一行是否为新章节
 * 判定条件:1.如果是新章节则必定以"第"开头，且至少包含关键字数组key中的一个元素，且"第"到该关键字中的内容匹配正则p
 *          2.如果是额外章节，则其单行长度(去掉空格之后)不得超过3，且至少满足下列条件中的一条
 *              a.其第一个或者第二个字为"序"(e.g.序,序言，序章，魔序)且字符长度不超过2
 *              b.以extra_key_start关键字数组中任意一项开头(e.g.前言，附录1，后记1)
 */
public class TitleMatches {

    //匹配的优先度依次递减
    public static final String[] key = {"部","卷","章","节","集","回","幕","计"};
    public static final Pattern p = Pattern.compile("^[0-9零一二三四五六七八九十百千]+$");
    public static boolean isZhang(String line){
        if(!line.startsWith("第")){
            return false;
        }
        int index = -1;
        for (int i = 0; i < key.length; i++) {
            index = line.indexOf(key[i]);
            if(index != -1){
                break;
            }
        }
        if(index == -1){
            return false;
        }
        String zhang = line.substring(1,index);
        return p.matcher(zhang).matches();
    }

    public static final String[] extra_key = {"序"};
    public static final String[] extra_key_start = {"前言","后记","楔子","附录","外传"};
    public static boolean isExtra(String line){
        if(line.length() > 3){
            return false;
        }
        int index = line.indexOf(extra_key[0]);
        if(index != -1){
            return (index == 0 || index == 1) && line.length() <= 2;
        }else{
            for (int i = 0; i < extra_key_start.length; i++) {
                if(line.startsWith(extra_key_start[i])){
                    return true;
                }
            }
            return false;
        }
    }
}