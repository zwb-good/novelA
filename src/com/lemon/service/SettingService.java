package com.lemon.service;

import java.util.List;

import com.lemon.pojo.Setting;

public interface SettingService {
	
	public List<Setting> getByUserId(Integer userId) throws Exception;
	
	public int update(Setting setting) throws Exception;
}
