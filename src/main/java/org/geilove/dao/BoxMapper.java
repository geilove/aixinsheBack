package org.geilove.dao;

import org.geilove.pojo.Box;

public interface BoxMapper {
    int deleteByPrimaryKey(Long boxid);

    int insert(Box record);

    int insertSelective(Box record);

    Box selectByPrimaryKey(Long boxid);

    int updateByPrimaryKeySelective(Box record);

    int updateByPrimaryKey(Box record);
}