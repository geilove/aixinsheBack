package org.geilove.dao;

import org.geilove.pojo.Middle;

public interface MiddleMapper {
    int deleteByPrimaryKey(Long middleid);

    int insert(Middle record);

    int insertSelective(Middle record);

    Middle selectByPrimaryKey(Long middleid);

    int updateByPrimaryKeySelective(Middle record);

    int updateByPrimaryKey(Middle record);
}