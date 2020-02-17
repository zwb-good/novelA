package com.lemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.dao.LabelMapper;
import com.lemon.pojo.Label;

@Service
public class LabelServiceImpl implements LabelService {
	@Autowired
	private LabelMapper labelMapper;
	
	@Override
	public List<Label> get() throws Exception {
		return labelMapper.selectByExample(null);
	}
	
	@Override
	public int insert(Label label) throws Exception {
		return labelMapper.insertSelective(label);
	}
	
	@Override
	public int delete(Integer[] ids) throws Exception {
		return labelMapper.deleteByIds(ids);
	}
	
	@Override
	public int update(Label label) throws Exception {
		return labelMapper.updateByPrimaryKeySelective(label);
	}
}
