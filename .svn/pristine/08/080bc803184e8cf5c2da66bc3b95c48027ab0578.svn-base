package com.lemon.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConvert  implements Converter<String, Date>{
   private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
   private SimpleDateFormat sdf_time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public Date convert(String value) {
		 if(value==null||(value.length()!=10&&value.length()!=19)){
			 return null;
		 }
		 value=value.replace('.','-');
			value=value.replace('/','-');
		System.err.println(value);
		try {
			if(value.length()==10){
			synchronized(sdf){
			return sdf.parse(value);
			}
			}else{
				synchronized(sdf_time){
					return sdf_time.parse(value);
					}	
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
