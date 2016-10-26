package org.geilove.util;

import javax.annotation.Resource;

import org.geilove.service.RegisterLoginService;

//传入一个token，如果这个token正确，返回userid和md5密码
//先解析出userid和md5密码，
//然后用userid取数据库的md5密码，如果一致，就返回userid、md5密码和tag=1成功否则tag=0
//注意md5密码都是32
 

public class CheckUser {
	 private String token;
	 private @Resource RegisterLoginService rlService;

	public CheckUser(String token){
		this.token=token;
	}
	public TokenData  handleToken(){
		TokenData data=new TokenData();
		String userPassword=token.substring(0,31);
		String useridstr=token.substring(token.length()-32,token.length());
		Long userid=new Long(useridstr);
		//使用userid查询数据库
		String realpw=null;
		 try{
			realpw=rlService.selectMD5Password(userid);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
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
