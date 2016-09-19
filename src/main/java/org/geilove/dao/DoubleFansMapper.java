package org.geilove.dao;

import java.util.List;
import java.util.Map;

import org.geilove.pojo.DoubleFans;
import org.geilove.sqlpojo.PartWatchPojo;

public interface DoubleFansMapper {
    int deleteByPrimaryKey(Long doublefansid);

    int insert(DoubleFans record);

    int insertSelective(DoubleFans record);

    DoubleFans selectByPrimaryKey(Long doublefansid);

    int updateByPrimaryKeySelective(DoubleFans record);

    int updateByPrimaryKey(DoubleFans record);
    
    int deleteByDoubleUserIDs(List list);// 自定义取消关注的方法。多条件删除
    
    List<PartWatchPojo> getPartWatchProfile(Map<String,Object> map); //获取DoubleFans表中的一组数据
    
    List<Long> getWatchids(Map<String,Object> map); //根据用户的id获得用户所关注的人的id列表。
    
}













