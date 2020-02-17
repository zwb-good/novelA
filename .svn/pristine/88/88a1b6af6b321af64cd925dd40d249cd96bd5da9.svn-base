package com.lemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.dao.GuidePageMapper;
import com.lemon.pojo.GuidePage;

@Service
public class GuidePageServiceImpl implements GuidePageService {
	@Autowired
	private GuidePageMapper guidePageMapper;
	@Override
	public List<GuidePage> selectGuidePage() throws Exception{
		List<GuidePage> list = guidePageMapper.selectByExample(null);
		return list;
	}
}
