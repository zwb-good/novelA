package com.lemon.service;

import java.util.List;

import com.lemon.pojo.Reader;

public interface ReaderService {
	
	public boolean addReader(Reader reader) throws Exception;
	
	public int update(Reader reader) throws Exception;
	
	public List<Reader> select() throws Exception;
	
	public List<Reader> search(Integer UserId) throws Exception;
	
	public int cleanNews(Integer userId) throws Exception;
	
}
