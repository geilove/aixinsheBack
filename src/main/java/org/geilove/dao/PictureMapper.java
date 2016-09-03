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

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
    
    List<PicturePojo> selectByMap(Map<String,Object> map); //自定义，获取一组图片和对应的url，轮播图等使用
}