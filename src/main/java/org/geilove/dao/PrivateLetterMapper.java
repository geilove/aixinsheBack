package org.geilove.dao;

import org.geilove.pojo.PrivateLetter;

public interface PrivateLetterMapper {
    int deleteByPrimaryKey(Long privateletterid);

    int insert(PrivateLetter record);

    int insertSelective(PrivateLetter record);

    PrivateLetter selectByPrimaryKey(Long privateletterid);

    int updateByPrimaryKeySelective(PrivateLetter record);

    int updateByPrimaryKey(PrivateLetter record);
}