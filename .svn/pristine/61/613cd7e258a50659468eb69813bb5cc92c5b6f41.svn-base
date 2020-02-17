package com.lemon.service;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.dao.CommentMapper;
import com.lemon.dao.ReplaycommentMapper;
import com.lemon.pojo.Comment;
import com.lemon.pojo.CommentExample;
import com.lemon.pojo.CommentExample.Criteria;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private ReplaycommentMapper replaycommentMapper;
	
	@Override
	public int insert(Comment comment) throws Exception {
		return commentMapper.insertSelective(comment);
	}
	
	@Override
	public List<Comment> select(Integer bookId) throws Exception {
		String sql = "(comment.bookId = '" + bookId +"')";
		
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		
		Class<?> criteriaCls = CommentExample.Criteria.class;
		Class<?> generatedCriteriaCls = criteriaCls.getSuperclass();
		Method addCriterion = generatedCriteriaCls.getDeclaredMethod("addCriterion", String.class);
		addCriterion.setAccessible(true);
		addCriterion.invoke(criteria, sql);
		return commentMapper.selectByExampleAndReader(example);
	}
	
	@Override
	public List<Comment> selectByCommentId(Integer commentId) throws Exception {
		String sql = "(comment.id = '" + commentId +"')";
		
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		
		Class<?> criteriaCls = CommentExample.Criteria.class;
		Class<?> generatedCriteriaCls = criteriaCls.getSuperclass();
		Method addCriterion = generatedCriteriaCls.getDeclaredMethod("addCriterion", String.class);
		addCriterion.setAccessible(true);
		addCriterion.invoke(criteria, sql);
		return commentMapper.selectByExampleAndReader(example);
	}
	
	@Override
	public List<Comment> selectByUserId(Integer userId) throws Exception {
		String sql = "(comment.userId = '" + userId +"')";
		
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		
		Class<?> criteriaCls = CommentExample.Criteria.class;
		Class<?> generatedCriteriaCls = criteriaCls.getSuperclass();
		Method addCriterion = generatedCriteriaCls.getDeclaredMethod("addCriterion", String.class);
		addCriterion.setAccessible(true);
		addCriterion.invoke(criteria, sql);
		return commentMapper.selectByExampleAndBook(example);
	}
	
	@Override
	public List<Comment> selectAndReplayAndReader(Integer userId) throws Exception {
		String sql = "(comment.userId = '" + userId +"' and replaycomment.state = 0)";
		
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		
		Class<?> criteriaCls = CommentExample.Criteria.class;
		Class<?> generatedCriteriaCls = criteriaCls.getSuperclass();
		Method addCriterion = generatedCriteriaCls.getDeclaredMethod("addCriterion", String.class);
		addCriterion.setAccessible(true);
		addCriterion.invoke(criteria, sql);
		List<Comment> list = commentMapper.selectByExampleAndReplayAndReader(example);
		int ids[] = new int[20];
		int count = 0;
		for(int i=0; i<list.size(); i++){
			for(int j=0; j<list.get(i).getReplaycomment().size(); j++){
				ids[count++] = list.get(i).getReplaycomment().get(j).getId();
			}
		}
		replaycommentMapper.updateByIds(ids);
		return list;
	}
	
	@Override
	public List<Comment> selectAndReplayAndReaderByBookId(Integer bookId) throws Exception {
		String sql = "(comment.bookId = '" + bookId +"')";
		
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		
		Class<?> criteriaCls = CommentExample.Criteria.class;
		Class<?> generatedCriteriaCls = criteriaCls.getSuperclass();
		Method addCriterion = generatedCriteriaCls.getDeclaredMethod("addCriterion", String.class);
		addCriterion.setAccessible(true);
		addCriterion.invoke(criteria, sql);
		return commentMapper.selectByExampleAndReplayAndReaderByBookId(example);
	}

	@Override
	public int delete(Integer id) throws Exception{
		return commentMapper.deleteByPrimaryKey(id);
	}
}
