package org.geilove.dao;

import java.util.List;
import java.util.Map;

import org.geilove.pojo.MoneySource;
import org.geilove.sqlpojo.PartHelpPojo;
import org.geilove.sqlpojo.OtherPartHelpPojo;

public interface MoneySourceMapper {
    int deleteByPrimaryKey(Long moneysourceid);

    int insert(MoneySource record);

    int insertSelective(MoneySource record);

    MoneySource selectByPrimaryKey(Long moneysourceid);
    
    List<PartHelpPojo> selectHelpMen(Map<String,Object> map); //自定义，获得帮助人-被帮助人关系表
    
    int updateByPrimaryKeySelective(MoneySource record);

    int updateByPrimaryKey(MoneySource record);
}