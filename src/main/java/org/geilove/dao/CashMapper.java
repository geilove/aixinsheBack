package org.geilove.dao;

import org.geilove.pojo.Cash;

public interface CashMapper {
    int deleteByPrimaryKey(Long cashid);

    int insert(Cash record);

    int insertSelective(Cash record);

    Cash selectByPrimaryKey(Long cashid);

    int updateByPrimaryKeySelective(Cash record);

    int updateByPrimaryKey(Cash record);
}