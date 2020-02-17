package com.lemon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.lemon.pojo.Bookshop;
import com.lemon.pojo.Collectbook;
import com.lemon.pojo.Replaycomment;
import com.lemon.service.ReplayCommentService;
import com.lemon.utils.JsonMsg;
import com.lemon.utils.JsonRs;

@Controller
@RequestMapping("/ReplayCommentAction")
public class ReplayCommentController {
	@Autowired
	private ReplayCommentService replayCommentService;
	
	@RequestMapping("/getByCommentId")
	@ResponseBody
	public void getByCommentId(String callback,Integer commentId,
			HttpServletResponse response) throws Exception{
		response.setContentType("application/json;charset=utf-8");
		try {
			List<Replaycomment> list = replayCommentService.getByPhone(commentId);
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(new JsonRs("查询成功", true, list.size(), list)) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(@RequestParam(value = "callback") String callback,Replaycomment replaycomment,
			HttpServletResponse response) throws IOException{
		response.setContentType("application/json;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			replaycomment.setTime(new Date());
			replaycomment.setState(0);
			int total = replayCommentService.insert(replaycomment);
			if(total == 1){
				out.print(callback + "(" + new Gson().toJson(new JsonMsg("添加成功", true)) + ")");
			}else {
				out.print(callback + "(" + new Gson().toJson(new JsonMsg("添加失败", false)) + ")");
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getAndReplay")
	@ResponseBody
	public void getAndReplay(String callback,Integer toUserId,
			HttpServletResponse response) throws Exception{
		response.setContentType("application/json;charset=utf-8");
		try {
			List<Replaycomment> list = replayCommentService.getAndReplay(toUserId);
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(new JsonRs("查询成功", true, list.size(), list)) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getByReplayId")
	@ResponseBody
	public void getByReplayId(String callback,Integer id,
			HttpServletResponse response) throws Exception{
		response.setContentType("application/json;charset=utf-8");
		try {
			List<Replaycomment> list = replayCommentService.getAndReader(id);
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(new JsonRs("查询成功", true, list.size(), list)) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
