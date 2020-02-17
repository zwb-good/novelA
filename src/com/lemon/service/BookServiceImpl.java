package com.lemon.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.dao.BookMapper;
import com.lemon.pojo.Book;
import com.lemon.pojo.BookExample;
import com.lemon.pojo.BookExample.Criteria;
import com.lemon.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<Book> getBook() throws Exception {
		BookExample example = new BookExample();
		example.setOrderByClause("novelTypeId asc");
		List<Book> bookList = bookMapper.selectByExampleAndType(example);
		return bookList;
	}
	
	@Override
	public int deleteBookByIds(Integer[] ids) throws Exception{
		int total = bookMapper.deleteByIds(ids);
		return total;
	}
	
	@Override
	public List<Book> getByCondition(String condition) throws Exception {
		String sql = "(book.name like '%" + condition +"%' or book.author like '%" + condition + "%')";
		
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		
		Class<?> criteriaCls = BookExample.Criteria.class;
		Class<?> generatedCriteriaCls = criteriaCls.getSuperclass();
		Method addCriterion = generatedCriteriaCls.getDeclaredMethod("addCriterion", String.class);
		addCriterion.setAccessible(true);
		addCriterion.invoke(criteria, sql);
		return bookMapper.selectByExampleAndType(example);
	}
	
	@Override
	public int insert(Book book) throws Exception {
		return bookMapper.insertSelective(book);
	}
	
	@Override
	public int updateByPrimaryKeySelective(Book book) throws Exception {
		return bookMapper.updateByPrimaryKeySelective(book);
	}
	
	@Override
	public List<Book> selectById(Integer id) throws Exception {
		String sql = "(book.id = " + id +")";
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		
		Class<?> criteriaCls = BookExample.Criteria.class;
		Class<?> generatedCriteriaCls = criteriaCls.getSuperclass();
		Method addCriterion = generatedCriteriaCls.getDeclaredMethod("addCriterion", String.class);
		addCriterion.setAccessible(true);
		addCriterion.invoke(criteria, sql);
		return bookMapper.selectByExampleAndType(example);
	}
	
	@Override
	public List<Book> getByConditionPhone(String condition,Integer type) throws Exception {
		String sql = "";
		if(type == 0){
			sql = "(book.noveltypeId = " + condition +")";
		}
		if(type == 1){
			sql = "book.name like '%"+condition+"%' or book.author like '%"+condition+"%' or book.abstractText like '%"+condition+"%'";
		}
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		
		Class<?> criteriaCls = BookExample.Criteria.class;
		Class<?> generatedCriteriaCls = criteriaCls.getSuperclass();
		Method addCriterion = generatedCriteriaCls.getDeclaredMethod("addCriterion", String.class);
		addCriterion.setAccessible(true);
		addCriterion.invoke(criteria, sql);
		return bookMapper.selectByExampleAndType(example);
	}

}
