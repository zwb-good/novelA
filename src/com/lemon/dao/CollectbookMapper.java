package com.lemon.dao;

import com.lemon.pojo.Collectbook;
import com.lemon.pojo.CollectbookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectbookMapper {
    long countByExample(CollectbookExample example);

    int deleteByExample(CollectbookExample example);

    int deleteByPrimaryKey(Integer id);
    
    int deleteByIds(Integer[] ids);

    int insert(Collectbook record);

    int insertSelective(Collectbook record);

    List<Collectbook> selectByExample(CollectbookExample example);

    Collectbook selectByPrimaryKey(Integer id);
    
    List<Collectbook> selectByExampleAndBook(CollectbookExample example);

    Collectbook selectByPrimaryKeyAndBook(Integer id);

    int updateByExampleSelective(@Param("record") Collectbook record, @Param("example") CollectbookExample example);

    int updateByExample(@Param("record") Collectbook record, @Param("example") CollectbookExample example);

    int updateByPrimaryKeySelective(Collectbook record);

    int updateByPrimaryKey(Collectbook record);
}