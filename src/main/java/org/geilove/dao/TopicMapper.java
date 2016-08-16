package org.geilove.dao;

import org.geilove.pojo.Topic;

public interface TopicMapper {
    int deleteByPrimaryKey(Long topicid);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Long topicid);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);
}