package com.lemon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.lemon.pojo.Reader;
import com.lemon.pojo.Setting;
import com.lemon.pojo.User;
import com.lemon.service.UserService;
import com.lemon.utils.JsonMsg;
import com.lemon.utils.JsonRs;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/regist")
	@ResponseBody
	public void addUser(User user,Reader reader,Setting setting,
			@RequestParam(value = "callback") String callback,
			HttpServletResponse response   ) throws IOException{
		response.setContentType("application/json;charset=utf-8");
		setting.setBgcColor("#f0d6a2");
		setting.setFontFamily("楷体");
		setting.setFontSize(20);
		String name = UUID.randomUUID().toString().substring(0, 5);
		reader.setName("书友"+name);
		reader.setHeadUrl("http://pth6t1mk7.bkt.clouddn.com/1561173558274.jpeg");
		reader.setNews(0);
		JsonRs jsonRs;
		try {
			jsonRs = userService.addUser(user,reader,setting);
			//return (callback + "(" + new Gson().toJson(jsonMsg) + ")");
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(jsonRs) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public void login(User user,@RequestParam(value = "callback") String callback,
			HttpServletResponse response   ) throws IOException{
		response.setContentType("application/json;charset=utf-8");
		JsonRs jsonRs;
		try {
			jsonRs = userService.login(user);
			//return (callback + "(" + new Gson().toJson(jsonMsg) + ")");
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(jsonRs) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
