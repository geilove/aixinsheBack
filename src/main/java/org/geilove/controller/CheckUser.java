package org.geilove.controller;

import javax.annotation.Resource;

import org.geilove.service.RegisterLoginService;
import org.geilove.util.TokenData;
import org.springframework.stereotype.Controller;

//传入一个token，如果这个token正确，返回userid和md5密码
//先解析出userid和md5密码，
//然后用userid取数据库的md5密码，如果一致，就返回userid、md5密码和tag=1成功否则tag=0
//注意md5密码都是32
 

public class CheckUser {
	 private String token;
	 
	 @Resource
	 private RegisterLoginService rlService;

	public CheckUser(String token){
		this.token=token;
	}
	public TokenData  handleToken(){
		TokenData data=new TokenData();
		String userPassword=token.substring(0,32); //token是password和userID拼接成的。
		String useridstr=token.substring(32);		
		//Long userid=Long.valueOf(useridstr).longValue();
		Long userid=Long.parseLong(useridstr);
		String realpw=null;
		if(userid instanceof Long){
			 System.out.println(userid);
			 System.out.println('a');
			 realpw=rlService.selectMD5Password(userid);
		}			
        System.out.println(realpw);		 
		 if(realpw==null){
			 data.setUserid(userid);
			 data.setUserPassword(null);
			 data.setTag(0);
		 }else if(realpw!=null && realpw.equals(userPassword)){
			 data.setUserid(userid);
			 data.setUserPassword(userPassword);
			 data.setTag(1);
		 }
		return data;
	}
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	 
}
