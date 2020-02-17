package com.lemon.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.lemon.pojo.Label;
import com.lemon.pojo.Noveltype;
import com.lemon.pojo.Setting;
import com.lemon.service.SettingService;
import com.lemon.utils.JsonMsg;
import com.lemon.utils.JsonRs;

@Controller
@RequestMapping("/SettingAction")
public class SettingController {
	@Autowired
	private SettingService settingService;
	
	@RequestMapping("/getByUserId")
	@ResponseBody
	public void getByUserId(Integer userId,String callback,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/json;charset=utf-8");
		try {
			List<Setting> list = settingService.getByUserId(userId);
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
	public void update(Setting setting,String callback,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/json;charset=utf-8");
		System.out.println("what"+setting.getBgcColor());
		try {
			int total = settingService.update(setting);
			PrintWriter out = response.getWriter();
			if(total > 0){
				out.print(callback + "(" + new Gson().toJson(new JsonMsg("操作成功", true)) + ")");
			}else {
				out.print(callback + "(" + new Gson().toJson(new JsonMsg("操作失败", false)) + ")");
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
