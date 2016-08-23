package org.geilove.dao;

import org.geilove.pojo.ItemPgComment;

public interface ItemPgCommentMapper {
    int deleteByPrimaryKey(Long itempgcommentid);

    int insert(ItemPgComment record);

    int insertSelective(ItemPgComment record);

    ItemPgComment selectByPrimaryKey(Long itempgcommentid);

    int updateByPrimaryKeySelective(ItemPgComment record);

    int updateByPrimaryKey(ItemPgComment record);
}