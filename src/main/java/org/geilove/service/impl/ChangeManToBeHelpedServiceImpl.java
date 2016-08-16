package org.geilove.service.impl;

import javax.annotation.Resource;

import org.geilove.pojo.Cash;
import org.geilove.pojo.User;
import org.geilove.service.ChangeManToBeHelpedService;
import org.geilove.dao.UserMapper;
import org.geilove.pojo.Cash;
import org.springframework.stereotype.Service;
import org.geilove.dao.CashMapper;
@Service("changeService")
public class ChangeManToBeHelpedServiceImpl implements ChangeManToBeHelpedService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private CashMapper cashMapper;
	
	@Override
	 public Integer changeSomeUserProfile(byte userType){
		User user=new User();
		user.setUsertype(userType);
		Integer tag=userMapper.updateByPrimaryKeySelective(user);
		return tag; // 这个标志更新是否成功
	}
	
	@Override
	  public Integer insertRecordIntoCashTable(Cash cash){
		Integer tagg=cashMapper.insert(cash);
		return tagg;
	}
	
}











