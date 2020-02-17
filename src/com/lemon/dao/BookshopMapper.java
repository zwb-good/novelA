package com.lemon.dao;

import com.lemon.pojo.Bookshop;
import com.lemon.pojo.BookshopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookshopMapper {
    long countByExample(BookshopExample example);

    int deleteByExample(BookshopExample example);

    int deleteByPrimaryKey(Integer id);
    
    int deleteByIds(Integer[] ids);

    int insert(Bookshop record);

    int insertSelective(Bookshop record);

    List<Bookshop> selectByExample(BookshopExample example);

    Bookshop selectByPrimaryKey(Integer id);
    
    List<Bookshop> selectByExampleAndBook(BookshopExample example);

    Bookshop selectByPrimaryKeyAndBook(Integer id);

    int updateByExampleSelective(@Param("record") Bookshop record, @Param("example") BookshopExample example);

    int updateByExample(@Param("record") Bookshop record, @Param("example") BookshopExample example);

    int updateByPrimaryKeySelective(Bookshop record);

    int updateByPrimaryKey(Bookshop record);
}