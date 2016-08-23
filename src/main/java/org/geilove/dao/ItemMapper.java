package org.geilove.dao;

import org.geilove.pojo.Item;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}