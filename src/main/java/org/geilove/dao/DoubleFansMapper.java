package org.geilove.dao;

import java.util.List;

import org.geilove.pojo.DoubleFans;

public interface DoubleFansMapper {
    int deleteByPrimaryKey(Long doublefansid);

    int insert(DoubleFans record);

    int insertSelective(DoubleFans record);

    DoubleFans selectByPrimaryKey(Long doublefansid);

    int updateByPrimaryKeySelective(DoubleFans record);

    int updateByPrimaryKey(DoubleFans record);
    
    int deleteByDoubleUserIDs(List list);// 自定义取消关注的方法。多条件删除
    
}













