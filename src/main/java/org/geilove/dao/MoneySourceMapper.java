package org.geilove.dao;

import org.geilove.pojo.MoneySource;

public interface MoneySourceMapper {
    int deleteByPrimaryKey(Long moneysourceid);

    int insert(MoneySource record);

    int insertSelective(MoneySource record);

    MoneySource selectByPrimaryKey(Long moneysourceid);

    int updateByPrimaryKeySelective(MoneySource record);

    int updateByPrimaryKey(MoneySource record);
}