package org.geilove.dao;

import java.util.List;
import java.util.Map;

import org.geilove.pojo.Picture;
import org.geilove.sqlpojo.PicturePojo;

public interface PictureMapper {
    int deleteByPrimaryKey(Long pictureid);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Long pictureid);
    
    List<PicturePojo> selectByMap(Map<String,Object> map);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}