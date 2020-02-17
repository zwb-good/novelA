package com.lemon.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lemon.pojo.Bookshop;
import com.lemon.pojo.BookshopExample;

public interface BookShopService {
	
	public List<Bookshop> getBookshop() throws Exception;
	
	public int deleteBookshopByIds(Integer[] ids) throws Exception;
	
	public int insert(Bookshop bookshop) throws Exception;
	
	public int updateByPrimaryKeySelective(Bookshop bookshop) throws Exception;
	
	public List<Bookshop> getByPosition(Integer position) throws Exception;

}
