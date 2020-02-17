package com.lemon.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.lemon.pojo.Content;
import com.lemon.pojo.TitleInfo;
import com.lemon.utils.JsonRs;
import com.lemon.utils.NovelParser;
import com.lemon.utils.ReadTxt;

@Controller
@RequestMapping("/BookAction")
public class ReadBookController {

	@RequestMapping("/getCatalog")
	@ResponseBody
	public void read(String url,String callback,
			HttpServletResponse response) throws Exception{
		response.setContentType("application/json;charset=utf-8");
		try {
			List<TitleInfo> list = new NovelParser(url).Catalog();
			//return (callback + "(" + new Gson().toJson(jsonMsg) + ")");
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(new JsonRs("查询成功", true, list.size(), list)) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getContent")
	@ResponseBody
	public void read(String url,Integer startLength,Integer endLength,String callback,
			HttpServletResponse response) throws Exception{
		response.setContentType("application/json;charset=utf-8");
		try {
			Map<String, String> map=new HashMap<String,String>();
			map.put("content", new ReadTxt().read(url, startLength, endLength));
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			list.add(map);
			//return (callback + "(" + new Gson().toJson(jsonMsg) + ")");
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(new JsonRs("查询成功", true, list.size(), list)) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
