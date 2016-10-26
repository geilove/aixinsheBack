package org.geilove.service;

import org.geilove.pojo.User;

public interface RegisterLoginService {
	
	public User userLogin(String userEmail);
	
	public int userRegister(User record);
	
	public String selectMD5Password(Long userid);
	
	public String findPasswd(String userEmail);
}
