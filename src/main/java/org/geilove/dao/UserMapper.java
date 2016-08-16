package org.geilove.dao;

import java.util.List;

import org.geilove.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userid);
    
    User selectByUserEmail(String useremail);//自定义，根据用户的邮箱进行验证

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<String> selectUserPhotos(List<Long> list); //自定义获取用户头像的方法
}