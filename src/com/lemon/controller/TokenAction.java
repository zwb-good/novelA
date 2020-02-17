package com.lemon.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.lemon.utils.QiniuUtil;


@Controller
@RequestMapping("/admin/TokenAction")
public class TokenAction {
	
	@RequestMapping("/get")
	@ResponseBody
	public Map<String, String> getToken(String key) throws Exception{
		Map<String, String> map = new HashMap<>();
		String token = QiniuUtil.getToken(key); 	// 生成普通上传的Token
		map.put("token", token);
		return map;
	}
	
	@RequestMapping("/getByPhone")
	@ResponseBody
	public void getByPhone(String key,String callback,
			HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		System.out.println("手机端获取token");
		PrintWriter out = response.getWriter(); // 用PrintWriter对象将返回结果写入服务器
		Map<String, String> map = new HashMap<>();
		String token = QiniuUtil.getToken(key); 	// 生成普通上传的Token
		map.put("token", token);
		out.print(new Gson().toJson(map));
		out.flush();
		out.close();
	}
}
