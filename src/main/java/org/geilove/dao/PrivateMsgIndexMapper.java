package org.geilove.dao;

import org.geilove.pojo.PrivateMsgIndex;

public interface PrivateMsgIndexMapper {
    int deleteByPrimaryKey(Long privatemsgid);

    int insert(PrivateMsgIndex record);

    int insertSelective(PrivateMsgIndex record);

    PrivateMsgIndex selectByPrimaryKey(Long privatemsgid);

    int updateByPrimaryKeySelective(PrivateMsgIndex record);

    int updateByPrimaryKey(PrivateMsgIndex record);
}