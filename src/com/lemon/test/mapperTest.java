package com.lemon.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lemon.dao.ReaderMapper;
import com.lemon.dao.UserMapper;
import com.lemon.pojo.User;
import com.lemon.pojo.UserExample;
import com.lemon.pojo.UserExample.Criteria;
import com.lemon.utils.JsonRs;


public class mapperTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ReaderMapper readerMapper = (ReaderMapper) applicationContext.getBean("readerMapper");
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("18720807469");
		criteria.andPasswordEqualTo("bin819463693");
		List<User> userList = userMapper.selectByExample(example);
		System.out.println(userList.get(0).getId());
		
/*		carouselMapper carouselMapper = (carouselMapper) applicationContext.getBean("carouselMapper");
		//User user = new User();
		
		//带参数查询
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("张荣娣");
		List<User> list = userMapper.selectByExample(example);
		System.out.println(list.size());
		
		//user.setName("张文彬");
		//user.setPassword(22222);
		//System.out.println("之前"+user.getId());
		//userMapper.insert(user);
		//System.out.println("之后"+user.getId());
		
		List<carousel> list = carouselMapper.selectByExampleAndBook(null);
		System.out.println(list);*/
	}

}
