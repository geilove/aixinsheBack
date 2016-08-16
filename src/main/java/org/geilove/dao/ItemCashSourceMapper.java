package org.geilove.dao;

import org.geilove.pojo.ItemCashSource;

public interface ItemCashSourceMapper {
    int deleteByPrimaryKey(Long itemcashsourceid);

    int insert(ItemCashSource record);

    int insertSelective(ItemCashSource record);

    ItemCashSource selectByPrimaryKey(Long itemcashsourceid);

    int updateByPrimaryKeySelective(ItemCashSource record);

    int updateByPrimaryKey(ItemCashSource record);
}