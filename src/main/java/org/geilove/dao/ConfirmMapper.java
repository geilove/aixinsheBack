package org.geilove.dao;

import java.util.List;
import java.util.Map;

import org.geilove.pojo.Confirm;

public interface ConfirmMapper {
    int deleteByPrimaryKey(Long confirmid);

    int insert(Confirm record);

    int insertSelective(Confirm record);

    Confirm selectByPrimaryKey(Long confirmid);

    int updateByPrimaryKeySelective(Confirm record);

    int updateByPrimaryKey(Confirm record);
    
    List<Confirm> getConfirmList(Map<String,Object> map); //获取证实人列表
    
    Integer  getCount(Map<String,Object> map); //获取指定推文或者项目的证实人数
    //map.put("id",)
    //map.put("tag",)
}