package org.geilove.dao;

import java.util.List;
import  java.util.Map;
import org.geilove.pojo.User;
import org.geilove.sqlpojo.PeopleNeedLovePojo;
import org.geilove.sqlpojo.LoveClubListPojo;
import org.geilove.sqlpojo.DonaterPojo;
import org.geilove.sqlpojo.OtherPartHelpPojo;

public interface UserMapper {
    int deleteByPrimaryKey(Long userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userid);
    
    User selectByUserEmail(String useremail);//自定义，根据用户的邮箱进行验证

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectMenList(Map<String,Object> map); //查询监督处爱心社等列表
    
    List<User>  getPayOrWatchPeople(Map<String,Object> map);  //查询关注我 我关注的人列表
    
    List<User> selectDonaterPeople(Map<String,Object> map); // 查询我帮助或者帮助我的人列表
   
    List<OtherPartHelpPojo> selectUserPartProfile(List<Long> lst); //给定一组id，获取用户的头像昵称简介
    
    //List<OtherPartHelpPojo> selectUserPhotos(List<Long> list); //自定义获取用户头像的方法
}