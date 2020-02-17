package com.lemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.dao.NoveltypeMapper;
import com.lemon.pojo.Label;
import com.lemon.pojo.Noveltype;

@Service
public class NoveltypeServiceImpl implements NoveltypeService {

	@Autowired
	private NoveltypeMapper noveltypeMapper;
	
	@Override
	public List<Noveltype> get() throws Exception {
		return noveltypeMapper.selectByExample(null);
	}
	
	@Override
	public int insert(Noveltype noveltype) throws Exception {
		return noveltypeMapper.insertSelective(noveltype);
	}
	
	@Override
	public int delete(Integer[] ids) throws Exception {
		return noveltypeMapper.deleteByIds(ids);
	}
	
	@Override
	public int update(Noveltype noveltype) throws Exception {
		return noveltypeMapper.updateByPrimaryKeySelective(noveltype);
	}
}
