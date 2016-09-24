package org.geilove.dao;

import org.geilove.pojo.Confirm;

public interface ConfirmMapper {
    int deleteByPrimaryKey(Long confirmid);

    int insert(Confirm record);

    int insertSelective(Confirm record);

    Confirm selectByPrimaryKey(Long confirmid);

    int updateByPrimaryKeySelective(Confirm record);

    int updateByPrimaryKey(Confirm record);
}