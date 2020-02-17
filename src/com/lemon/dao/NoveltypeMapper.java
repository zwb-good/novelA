package com.lemon.dao;

import com.lemon.pojo.Noveltype;
import com.lemon.pojo.NoveltypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoveltypeMapper {
    long countByExample(NoveltypeExample example);

    int deleteByExample(NoveltypeExample example);

    int deleteByPrimaryKey(Integer id);
    
    int deleteByIds(Integer[] ids);

    int insert(Noveltype record);

    int insertSelective(Noveltype record);

    List<Noveltype> selectByExample(NoveltypeExample example);

    Noveltype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Noveltype record, @Param("example") NoveltypeExample example);

    int updateByExample(@Param("record") Noveltype record, @Param("example") NoveltypeExample example);

    int updateByPrimaryKeySelective(Noveltype record);

    int updateByPrimaryKey(Noveltype record);
}