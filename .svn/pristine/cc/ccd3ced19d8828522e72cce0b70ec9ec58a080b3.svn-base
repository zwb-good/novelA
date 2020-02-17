package com.lemon.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.lemon.pojo.Carousel;
import com.lemon.service.CarouselService;
import com.lemon.utils.ChangeIds;
import com.lemon.utils.JsonMsg;
import com.lemon.utils.JsonRs;

@Controller
@RequestMapping("/admin/CarouselAction")
public class CarouselController {
	@Autowired
	private CarouselService carouselService;
	
	@RequestMapping("/get")
	@ResponseBody
	public JsonRs get() throws Exception {
		List<Carousel> list = carouselService.select();
		return new JsonRs("查询成功", true, list.size(), list);
	}
	
	@RequestMapping("/getByPhone")
	@ResponseBody
	public void getBookByPhone(@RequestParam(value = "callback") String callback,
			HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		try {
			List<Carousel> list = carouselService.select();
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
	public JsonMsg insert(Carousel carousel) throws Exception {
		int total = carouselService.insert(carousel);
		if(total > 0){
			return new JsonMsg("删除成功", true);
		}else {
			return new JsonMsg("操作失败", false);
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public JsonMsg delete(String ids) throws Exception {
		ChangeIds changeIds = new ChangeIds();
		int total = carouselService.delete(changeIds.toInteger(ids));
		if(total > 0){
			return new JsonMsg("删除成功", true);
		}else {
			return new JsonMsg("操作失败", false);
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JsonMsg update(Carousel carousel) throws Exception {
		int total = carouselService.update(carousel);
		if(total > 0){
			return new JsonMsg("删除成功", true);
		}else {
			return new JsonMsg("操作失败", false);
		}
	}
}
