package com.lemon.service;

import java.util.List;

import com.lemon.pojo.Label;

public interface LabelService {
	
	public List<Label> get() throws Exception;
	
	public int insert(Label label) throws Exception;
	
	public int delete(Integer[] ids) throws Exception;
	
	public int update(Label label) throws Exception;
}
