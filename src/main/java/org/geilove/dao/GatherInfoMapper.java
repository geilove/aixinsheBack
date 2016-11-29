package org.geilove.dao;

import org.geilove.pojo.GatherInfo;

public interface GatherInfoMapper {
    int deleteByPrimaryKey(Integer gatherinfoid);

    int insert(GatherInfo record);

    int insertSelective(GatherInfo record);

    GatherInfo selectByPrimaryKey(Integer gatherinfoid);

    int updateByPrimaryKeySelective(GatherInfo record);

    int updateByPrimaryKey(GatherInfo record);
}