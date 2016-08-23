package org.geilove.dao;

import org.geilove.pojo.ItemUser;

public interface ItemUserMapper {
    int deleteByPrimaryKey(Long itemuserid);

    int insert(ItemUser record);

    int insertSelective(ItemUser record);

    ItemUser selectByPrimaryKey(Long itemuserid);

    int updateByPrimaryKeySelective(ItemUser record);

    int updateByPrimaryKey(ItemUser record);
}