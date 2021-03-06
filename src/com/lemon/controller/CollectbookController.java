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

import com.google.gson.Gson;
import com.lemon.pojo.Collectbook;
import com.lemon.service.CollectbookService;
import com.lemon.utils.ChangeIds;
import com.lemon.utils.JsonMsg;
import com.lemon.utils.JsonRs;

@Controller
@RequestMapping("/CollectbookAction")
public class CollectbookController {
	@Autowired
	private CollectbookService collectbookService;
	
	@RequestMapping("/get")
	@ResponseBody
	public void getCollectbook(@RequestParam(value = "callback") String callback,Integer userId,
			HttpServletResponse response) throws IOException{
		response.setContentType("application/json;charset=utf-8");
		try {
			List<Collectbook> list = collectbookService.getCollectbook(userId);
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
	public void getCollectbook(@RequestParam(value = "callback") String callback,Collectbook collectbook,
			HttpServletResponse response) throws IOException{
		response.setContentType("application/json;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			collectbook.setTime(new Date());
			int total = collectbookService.insert(collectbook);
			if(total == 1){
				out.print(callback + "(" + new Gson().toJson(new JsonMsg("添加成功", true)) + ")");
			}else {
				out.print(callback + "(" + new Gson().toJson(new JsonMsg("请不要重复添加", false)) + ")");
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void deletes(String ids,String callback,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/json;charset=utf-8");
		try {
			ChangeIds changeIds = new ChangeIds();
			int total = collectbookService.delete(changeIds.toInteger(ids));
			PrintWriter out = response.getWriter();
			if(total > 0){
				out.print(callback + "(" + new Gson().toJson(new JsonMsg("删除成功", true)) + ")");
			}else {
				out.print(callback + "(" + new Gson().toJson(new JsonMsg("删除失败", false)) + ")");
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
