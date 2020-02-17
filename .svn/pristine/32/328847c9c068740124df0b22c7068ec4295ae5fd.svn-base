package com.lemon.dao;

import com.lemon.pojo.GuidePage;
import com.lemon.pojo.GuidePageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuidePageMapper {
    long countByExample(GuidePageExample example);

    int deleteByExample(GuidePageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GuidePage record);

    int insertSelective(GuidePage record);

    List<GuidePage> selectByExample(GuidePageExample example);

    GuidePage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GuidePage record, @Param("example") GuidePageExample example);

    int updateByExample(@Param("record") GuidePage record, @Param("example") GuidePageExample example);

    int updateByPrimaryKeySelective(GuidePage record);

    int updateByPrimaryKey(GuidePage record);
}