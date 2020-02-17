package com.lemon.service;

import java.util.List;

import com.lemon.pojo.Book;

public interface BookService {

	public List<Book> getBook() throws Exception;
	
	public int deleteBookByIds(Integer[] ids) throws Exception;
	
	public List<Book> getByCondition(String condition) throws Exception;
	
	public int insert(Book book) throws Exception;
	
	public int updateByPrimaryKeySelective(Book book) throws Exception;
	
	public List<Book> selectById(Integer id) throws Exception;
	
	public List<Book> getByConditionPhone(String condition,Integer type) throws Exception;
}
