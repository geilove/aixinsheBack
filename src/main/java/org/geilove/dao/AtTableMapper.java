package org.geilove.dao;

import org.geilove.pojo.AtTable;

public interface AtTableMapper {
    int deleteByPrimaryKey(Long atid);

    int insert(AtTable record);

    int insertSelective(AtTable record);

    AtTable selectByPrimaryKey(Long atid);

    int updateByPrimaryKeySelective(AtTable record);

    int updateByPrimaryKey(AtTable record);
}