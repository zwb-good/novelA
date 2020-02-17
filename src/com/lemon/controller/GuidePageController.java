package com.lemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lemon.pojo.GuidePage;
import com.lemon.service.GuidePageService;
import com.lemon.utils.JsonRs;

@Controller
@RequestMapping("/GuidePage")
public class GuidePageController {
	@Autowired
	private GuidePageService guidePageService;
	
	@RequestMapping("/get")
	@ResponseBody
	public JsonRs getGuidePage() throws Exception{
		List<GuidePage> list = guidePageService.selectGuidePage();
		int total = list.size();
		if(total >= 0){
			return (new JsonRs("操作成功", true, total, list));
		}else {
			return (new JsonRs("操作失败", false, total, list));
		}
	}
}
