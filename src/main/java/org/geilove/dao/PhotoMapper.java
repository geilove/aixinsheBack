package org.geilove.dao;

import org.geilove.pojo.Photo;

public interface PhotoMapper {
    int deleteByPrimaryKey(Long photoid);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Long photoid);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}