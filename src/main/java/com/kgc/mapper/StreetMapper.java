package com.kgc.mapper;

import com.kgc.po.Street;
import com.kgc.po.StreetExample;
import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    int delStreetByDistritc(Integer did);
}