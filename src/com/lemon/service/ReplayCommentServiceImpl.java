package com.lemon.service;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.dao.CommentMapper;
import com.lemon.dao.ReaderMapper;
import com.lemon.dao.ReplaycommentMapper;
import com.lemon.pojo.Comment;
import com.lemon.pojo.CommentExample;
import com.lemon.pojo.Reader;
import com.lemon.pojo.Replaycomment;
import com.lemon.pojo.ReplaycommentExample;
import com.lemon.pojo.ReplaycommentExample.Criteria;

@Service
public class ReplayCommentServiceImpl implements ReplayCommentService {
	@Autowired
	private ReplaycommentMapper replaycommentMapper;
	@Autowired
	private ReaderMapper readerMapper;
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public List<Replaycomment> getByPhone(Integer commentId) throws Exception {
		String sql = "(replaycomment.commentId = '" + commentId +"')";
		
		ReplaycommentExample example = new ReplaycommentExample();
		Criteria criteria = example.createCriteria();
		
		Class<?> criteriaCls = ReplaycommentExample.Criteria.class;
		Class<?> generatedCriteriaCls = criteriaCls.getSuperclass();
		Method addCriterion = generatedCriteriaCls.getDeclaredMethod("addCriterion", String.class);
		addCriterion.setAccessible(true);
		addCriterion.invoke(criteria, sql);
		return replaycommentMapper.selectByExampleAndComment(example);
	}
	
	@Override
	public int insert(Replaycomment replaycomment) throws Exception {
		int total = replaycommentMapper.insertSelective(replaycomment);
		if(total == 1){
			Comment comment = commentMapper.selectByPrimaryKey(replaycomment.getCommentId());
			readerMapper.updateUpOne(comment.getUserId());
			commentMapper.updateUpComments(replaycomment.getCommentId());
			if(replaycomment.getToUserId() != null){
				readerMapper.updateUpOne(replaycomment.getToUserId());
			}
			return total;
		}else {
			return total;
		}
	}
	
	@Override
	public List<Replaycomment> getAndReplay(Integer toUserId) throws Exception {
		String sql = "(replay.toUserId = '" + toUserId +"')";
		
		ReplaycommentExample example = new ReplaycommentExample();
		Criteria criteria = example.createCriteria();
		
		Class<?> criteriaCls = ReplaycommentExample.Criteria.class;
		Class<?> generatedCriteriaCls = criteriaCls.getSuperclass();
		Method addCriterion = generatedCriteriaCls.getDeclaredMethod("addCriterion", String.class);
		addCriterion.setAccessible(true);
		addCriterion.invoke(criteria, sql);
		return replaycommentMapper.selectByExampleAndReplay(example);
	}
	
	@Override
	public List<Replaycomment> getAndReader(Integer id) throws Exception {
		String sql = "(replay.id = '" + id +"')";
		
		ReplaycommentExample example = new ReplaycommentExample();
		Criteria criteria = example.createCriteria();
		
		Class<?> criteriaCls = ReplaycommentExample.Criteria.class;
		Class<?> generatedCriteriaCls = criteriaCls.getSuperclass();
		Method addCriterion = generatedCriteriaCls.getDeclaredMethod("addCriterion", String.class);
		addCriterion.setAccessible(true);
		addCriterion.invoke(criteria, sql);
		return replaycommentMapper.selectByExampleAndReader(example);
	}
}
