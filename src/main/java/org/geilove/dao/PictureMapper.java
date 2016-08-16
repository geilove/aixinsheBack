package org.geilove.dao;

import org.geilove.pojo.Picture;

public interface PictureMapper {
    int deleteByPrimaryKey(Long pictureid);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Long pictureid);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}