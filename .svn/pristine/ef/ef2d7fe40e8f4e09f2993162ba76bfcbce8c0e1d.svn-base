package com.lemon.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.lemon.pojo.Noveltype;
import com.lemon.service.NoveltypeService;
import com.lemon.utils.ChangeIds;
import com.lemon.utils.JsonMsg;
import com.lemon.utils.JsonRs;

@Controller
@RequestMapping("/admin/NoveltypeAction")
public class NoveltypeController {
	
	@Autowired
	private NoveltypeService noveltypeService;
	
	@RequestMapping("/get")
	@ResponseBody
	public JsonRs get() throws Exception {
		List<Noveltype> list = noveltypeService.get();
		return new JsonRs("查询成功", true, list.size(), list);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public JsonMsg insert(Noveltype noveltype) throws Exception {
		int total = noveltypeService.insert(noveltype);
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
		int total = noveltypeService.delete(changeIds.toInteger(ids));
		if(total > 0){
			return new JsonMsg("删除成功", true);
		}else {
			return new JsonMsg("操作失败", false);
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JsonMsg update(Noveltype noveltype) throws Exception {
		int total = noveltypeService.update(noveltype);
		if(total > 0){
			return new JsonMsg("删除成功", true);
		}else {
			return new JsonMsg("操作失败", false);
		}
	}
	
	@RequestMapping("/getByPhone")
	@ResponseBody
	public void getByPhone(String callback,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/json;charset=utf-8");
		try {
			List<Noveltype> list = noveltypeService.get();
			PrintWriter out = response.getWriter();
			out.print(callback + "(" + new Gson().toJson(new JsonRs("查询成功", true, list.size(), list)) + ")");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
