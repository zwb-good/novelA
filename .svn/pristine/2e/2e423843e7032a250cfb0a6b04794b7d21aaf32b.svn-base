package com.lemon.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.lemon.pojo.Collectbook;
import com.lemon.pojo.Like;
import com.lemon.service.LikeService;
import com.lemon.utils.JsonMsg;
import com.lemon.utils.JsonRs;

@Controller
@RequestMapping("/LikeAction")
public class LikeController {
	@Autowired
	private LikeService likeService;
	
	@RequestMapping("/get")
	@ResponseBody
	public void getByUserId(@RequestParam(value = "callback") String callback,Integer userId,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/json;charset=utf-8");
		try {
			List<Like> list = likeService.getByUserId(userId);
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(new JsonRs("查询成功", true, list.size(), list)) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public void update(@RequestParam(value = "callback") String callback,Like like,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/json;charset=utf-8");
		try {
			JsonMsg jsonMsg;
			jsonMsg = likeService.update(like);
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(jsonMsg) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
