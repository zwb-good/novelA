package com.lemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.dao.SettingMapper;
import com.lemon.pojo.Setting;
import com.lemon.pojo.SettingExample;
import com.lemon.pojo.SettingExample.Criteria;

@Service
public class SettingServiceImpl implements SettingService {
	@Autowired
	private SettingMapper settingMapper;
	
	@Override
	public List<Setting> getByUserId(Integer userId) throws Exception {
		SettingExample example = new SettingExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return settingMapper.selectByExample(example);
	}
	
	@Override
	public int update(Setting setting) throws Exception {
		SettingExample example = new SettingExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(setting.getUserId());
		return settingMapper.updateByExampleSelective(setting, example);
	}

}
