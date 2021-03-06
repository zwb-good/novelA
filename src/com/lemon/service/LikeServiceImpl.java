package com.lemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.dao.CommentMapper;
import com.lemon.dao.LikeMapper;
import com.lemon.pojo.Like;
import com.lemon.pojo.LikeExample;
import com.lemon.pojo.LikeExample.Criteria;
import com.lemon.utils.JsonMsg;

@Service
public class LikeServiceImpl implements LikeService{
	@Autowired
	private LikeMapper likeMapper;
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public List<Like> getByUserId(Integer userId) throws Exception {
		LikeExample example = new LikeExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return likeMapper.selectByExample(example);
	}
	
	@Override
	public JsonMsg update(Like like) throws Exception {
		LikeExample example = new LikeExample();
		Criteria criteria = example.createCriteria();
		criteria.andCommentIdEqualTo(like.getCommentId());
		criteria.andUserIdEqualTo(like.getUserId());
		likeMapper.selectByExample(example);
		if(likeMapper.selectByExample(example).isEmpty()){
			commentMapper.updateUpOne(like.getCommentId());
			likeMapper.insertSelective(like);
			return new JsonMsg("添加成功", true);
		}else {
			if (like.getIsLike() == 0) {
				commentMapper.updateDownOne(like.getCommentId());
			}else {
				commentMapper.updateUpOne(like.getCommentId());
			}
			likeMapper.updateByExampleSelective(like, example);
			return new JsonMsg("修改成功", true);
		}
	}
}
