package com.lemon.service;

import java.util.List;

import com.lemon.pojo.Comment;

public interface CommentService {
	
	public int insert(Comment comment) throws Exception;
	
	public List<Comment> select(Integer bookId) throws Exception;
	
	public List<Comment> selectByCommentId(Integer commentId) throws Exception;
	
	public List<Comment> selectByUserId(Integer userId) throws Exception;
	
	public List<Comment> selectAndReplayAndReader(Integer userId) throws Exception;
	
	public int delete(Integer id) throws Exception;
	
	public List<Comment> selectAndReplayAndReaderByBookId(Integer bookId) throws Exception;

	/*public int insert(Comment comment) throws Exception;
	
	public int insert(Comment comment) throws Exception;
	
	public int insert(Comment comment) throws Exception;
	
	public int insert(Comment comment) throws Exception;*/
}
