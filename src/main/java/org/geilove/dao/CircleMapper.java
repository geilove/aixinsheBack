package org.geilove.dao;

import org.geilove.pojo.Circle;

public interface CircleMapper {
    int deleteByPrimaryKey(Long circleid);

    int insert(Circle record);

    int insertSelective(Circle record);

    Circle selectByPrimaryKey(Long circleid);

    int updateByPrimaryKeySelective(Circle record);

    int updateByPrimaryKey(Circle record);
}