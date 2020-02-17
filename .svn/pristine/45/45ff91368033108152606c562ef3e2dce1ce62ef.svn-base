package com.lemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.dao.CarouselMapper;
import com.lemon.pojo.Carousel;
import com.lemon.pojo.CarouselExample;
import com.lemon.pojo.Label;

@Service
public class CarouselServiceImpl implements CarouselService {
	@Autowired
	private CarouselMapper carouselMapper;
	
	@Override
	public List<Carousel> select() throws Exception {
		CarouselExample example = new CarouselExample();
		example.setOrderByClause("position asc");
		return carouselMapper.selectByExampleAndBook(example);
	}
	
	@Override
	public int insert(Carousel carousel) throws Exception {
		return carouselMapper.insertSelective(carousel);
	}
	
	@Override
	public int delete(Integer[] ids) throws Exception {
		return carouselMapper.deleteByIds(ids);
	}
	
	@Override
	public int update(Carousel carousel) throws Exception {
		return carouselMapper.updateByPrimaryKeySelective(carousel);
	}
}
