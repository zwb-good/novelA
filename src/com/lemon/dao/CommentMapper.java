package com.lemon.dao;

import com.lemon.pojo.Comment;
import com.lemon.pojo.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer id);
    
    List<Comment> selectByExampleAndReader(CommentExample example);

    Comment selectByPrimaryKeyAndReader(Integer id);
    
    List<Comment> selectByExampleAndBook(CommentExample example);

    Comment selectByPrimaryKeyAndBook(Integer id);
    
    List<Comment> selectByExampleAndReplayAndReader(CommentExample example);
    
    Comment selectByPrimaryKeyAndReplayAndReader(Integer id);
    
    List<Comment> selectByExampleAndReplayAndReaderByBookId(CommentExample example);
    
    Comment selectByPrimaryKeyAndReplayAndReaderByBookId(Integer id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
    
    int updateUpOne(Integer id);
    
    int updateDownOne(Integer id);
    
    int updateUpComments(Integer id);
}