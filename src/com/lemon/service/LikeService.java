package com.lemon.service;

import java.util.List;

import com.lemon.pojo.Like;
import com.lemon.utils.JsonMsg;

public interface LikeService {
	
	public List<Like> getByUserId(Integer userId) throws Exception;
	
	public JsonMsg update(Like like) throws Exception;
}
