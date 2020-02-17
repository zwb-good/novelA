package com.lemon.service;

import java.util.List;

import com.lemon.pojo.Carousel;

public interface CarouselService {
	
	public List<Carousel> select() throws Exception;
	
	public int insert(Carousel carousel) throws Exception;
	
	public int delete(Integer[] ids) throws Exception;
	
	public int update(Carousel carousel) throws Exception;
}
