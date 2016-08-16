package org.geilove.dao;

import org.geilove.pojo.AtLinkUser;

public interface AtLinkUserMapper {
    int deleteByPrimaryKey(Long atlinkuserid);

    int insert(AtLinkUser record);

    int insertSelective(AtLinkUser record);

    AtLinkUser selectByPrimaryKey(Long atlinkuserid);

    int updateByPrimaryKeySelective(AtLinkUser record);

    int updateByPrimaryKey(AtLinkUser record);
}