package com.lemon.utils;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
@Component
public class MyObjectMapper extends ObjectMapper {  
	  
    private static final long serialVersionUID = 4402127997078513582L;  
  
    public MyObjectMapper() {
    	  this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //设置null值不参与序列化(字段不被显示)    
       // this.setSerializationInclusion(Include.NON_NULL);  
        
        // 禁用空对象转换json校验  
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);  
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  
        //驼峰命名法转换为小写加下划线  
       // this.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);  
        //解决是json转换date少8小时的问题
        this.setTimeZone(java.util.TimeZone.getTimeZone("GMT+08"));
    }  
}  
