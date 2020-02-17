package com.lemon.service;


import java.util.List;

import com.lemon.pojo.Reader;
import com.lemon.pojo.Setting;
import com.lemon.pojo.User;
import com.lemon.utils.JsonRs;

public interface UserService {
		

	public JsonRs addUser(User user,Reader reader,Setting setting) throws Exception;
	
	public JsonRs login(User user) throws Exception;
	
}
