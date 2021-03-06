package com.lemon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.dao.ReaderMapper;
import com.lemon.dao.SettingMapper;
import com.lemon.dao.UserMapper;
import com.lemon.pojo.Reader;
import com.lemon.pojo.ReaderExample;
import com.lemon.pojo.Setting;
import com.lemon.pojo.User;
import com.lemon.pojo.UserExample;
import com.lemon.pojo.UserExample.Criteria;
import com.lemon.utils.JsonMsg;
import com.lemon.utils.JsonRs;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ReaderMapper readerMapper;
	@Autowired
	private SettingMapper settingMapper;
		
	@Override
	public JsonRs addUser(User user,Reader reader,Setting setting)throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(user.getName());
		List<Reader> list = new ArrayList<>();
		if(userMapper.selectByExample(example).size() != 0){
			return new JsonRs("用户名已注册", false,0,list);
		}else {
			userMapper.insert(user);
			reader.setUserId(user.getId());
			setting.setUserId(user.getId());
			settingMapper.insertSelective(setting);
			boolean success = readerMapper.insertSelective(reader) == 1?true:false;
			if(success){
				list.add(reader);
				return new JsonRs("注册成功", true,1,list);
			}else {
				return new JsonRs("注册失败", false,0,list);
			}
		}
	}
	
	@Override
	public JsonRs login(User user) throws Exception {
		UserExample uExample = new UserExample();
		Criteria u = uExample.createCriteria();
		u.andNameEqualTo(user.getName());
		u.andPasswordEqualTo(user.getPassword());
		List<User> userList = userMapper.selectByExample(uExample);
		if(userList.isEmpty()){
			return new JsonRs("用户名或密码错误", false, 0, userList);
		}else {
			ReaderExample rExample = new ReaderExample();
			com.lemon.pojo.ReaderExample.Criteria rCriteria = rExample.createCriteria();
			rCriteria.andUserIdEqualTo(userList.get(0).getId());
			List<Reader> readerList = readerMapper.selectByExample(rExample);
			return new JsonRs("登陆成功", true, readerList.size(), readerList);
		}
	}
}
