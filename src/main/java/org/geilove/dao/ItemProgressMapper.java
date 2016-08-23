package org.geilove.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.geilove.pojo.ItemProgress;
import org.geilove.pojo.ItemProgressExample;

public interface ItemProgressMapper {
    int countByExample(ItemProgressExample example);

    int deleteByExample(ItemProgressExample example);

    int deleteByPrimaryKey(Long itemprogressid);

    int insert(ItemProgress record);

    int insertSelective(ItemProgress record);

    List<ItemProgress> selectByExample(ItemProgressExample example);

    ItemProgress selectByPrimaryKey(Long itemprogressid);

    int updateByExampleSelective(@Param("record") ItemProgress record, @Param("example") ItemProgressExample example);

    int updateByExample(@Param("record") ItemProgress record, @Param("example") ItemProgressExample example);

    int updateByPrimaryKeySelective(ItemProgress record);

    int updateByPrimaryKey(ItemProgress record);
}