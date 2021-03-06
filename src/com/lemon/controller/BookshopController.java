package com.lemon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.lemon.service.BookShopService;
import com.lemon.utils.ChangeIds;
import com.lemon.utils.JsonMsg;
import com.lemon.utils.JsonRs;

@Controller
@RequestMapping("/admin/BookshopAction")
public class BookshopController {

	@Autowired
	private BookShopService bookShopService;
	
	@RequestMapping("/getBook.do")
	@ResponseBody
	public JsonRs getBook() throws Exception{
		List<Bookshop> list = bookShopService.getBookshop();
		return new JsonRs("查询成功", true, list.size(), list);
	}
	
	@RequestMapping("/get.do")
	@ResponseBody
	public void getBookByPhone(@RequestParam(value = "callback") String callback,
			@RequestParam(value = "num", defaultValue="1") Integer num,
			HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		try {
			PageHelper.startPage(num, 8);
			List<Bookshop> list = bookShopService.getBookshop();
			PageInfo page = new PageInfo(list);
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(new JsonRs("查询成功", true, (int)page.getTotal(), page.getList())) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getByPosition.do")
	@ResponseBody
	public void getBookByPhone(@RequestParam(value = "callback") String callback,
			@RequestParam(value = "num", defaultValue="1") Integer num,
			@RequestParam(value = "position") Integer position,
			HttpServletResponse response) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		try {
			PageHelper.startPage(num, 8);
			List<Bookshop> list = bookShopService.getByPosition(position);
			PageInfo page = new PageInfo(list);
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(new JsonRs("查询成功", true, (int)page.getTotal(), page.getList())) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public JsonMsg delete(String ids) throws Exception{
		ChangeIds changeIds = new ChangeIds();
		int total = bookShopService.deleteBookshopByIds(changeIds.toInteger(ids));
		if(total > 0){
			return new JsonMsg("删除成功", true);
		}else {
			return new JsonMsg("操作失败", false);
		}
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public JsonMsg insert(Bookshop bookshop) throws Exception{
		int total = bookShopService.insert(bookshop);
		if(total > 0){
			return new JsonMsg("添加成功", true);
		}else {
			return new JsonMsg("添加失败", false);
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JsonMsg update(Bookshop bookshop) throws Exception{
		int total = bookShopService.updateByPrimaryKeySelective(bookshop);
		if(total > 0){
			return new JsonMsg("更新成功", true);
		}else {
			return new JsonMsg("更新失败", false);
		}
	}
}
