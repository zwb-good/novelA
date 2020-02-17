package com.lemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lemon.pojo.Label;
import com.lemon.service.LabelService;
import com.lemon.utils.ChangeIds;
import com.lemon.utils.JsonMsg;
import com.lemon.utils.JsonRs;

@Controller
@RequestMapping("/admin/LabelAction")
public class LabelController {
	@Autowired
	private LabelService labelService;
	
	@RequestMapping("/get")
	@ResponseBody
	public JsonRs get() throws Exception {
		List<Label> list = labelService.get();
		return new JsonRs("查询成功", true, list.size(), list);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public JsonMsg insert(Label label) throws Exception {
		int total = labelService.insert(label);
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
		int total = labelService.delete(changeIds.toInteger(ids));
		if(total > 0){
			return new JsonMsg("删除成功", true);
		}else {
			return new JsonMsg("操作失败", false);
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JsonMsg update(Label label) throws Exception {
		int total = labelService.update(label);
		if(total > 0){
			return new JsonMsg("删除成功", true);
		}else {
			return new JsonMsg("操作失败", false);
		}
	}
}
