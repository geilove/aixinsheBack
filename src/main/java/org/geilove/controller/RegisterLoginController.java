
package org.geilove.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.geilove.pojo.User;
import org.geilove.vo.UserLoginVo;
import org.geilove.service.RegisterLoginService;
import org.geilove.vo.UserRegisterVo;
import org.geilove.response.UserProfileRsp;
@Controller
@RequestMapping("/user")
public class RegisterLoginController {
	
	@Resource
	private RegisterLoginService registerLoginService; 
	
	@RequestMapping(value="/login",method=RequestMethod.POST)	
	public @ResponseBody UserProfileRsp loginUser(@RequestBody UserLoginVo userLoginVo){
		//这里应该先验证用户邮箱和密码是不是符合要求，避免浪费资源查询数据库
		UserProfileRsp  userProfileRsp=new UserProfileRsp();
		User user=registerLoginService.userLogin(userLoginVo.getUserEmail());
		if(user==null){
			userProfileRsp.setData(user);
			userProfileRsp.setMsg("不存在此用户");
			userProfileRsp.setRetcode(2001); //不存在此用户
		}
		else if (! userLoginVo.getUserPassword().equals(user.getUserpassword())){
			userProfileRsp.setData(null);
			userProfileRsp.setMsg("您输入的密码不对");
			userProfileRsp.setRetcode(2002); //用户密码错误
		}else if(userLoginVo.getUserPassword().equals(user.getUserpassword())){
			userProfileRsp.setData(user);
			userProfileRsp.setMsg("请求成功");
			userProfileRsp.setRetcode(2000); //返回成功
		}
		else{
			userProfileRsp.setData(null);
			userProfileRsp.setMsg("服务器错误");
			userProfileRsp.setRetcode(2003); //未知错误
		}
		
		return userProfileRsp;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody User registerUser(@RequestBody  UserRegisterVo userRegisterVo){
		//这里假设昵称唯一可用，邮箱可用，两次输入的密码一样
		
		User userRegister=new User();		
		userRegister.setUsernickname(userRegisterVo.getUserNickName());
		userRegister.setUseremail(userRegisterVo.getUserEmail());
		userRegister.setUserpassword(userRegisterVo.getUserPassword());
		userRegister.setPhotoupload((byte) 1);
		userRegister.setNotsay((byte)1);
		userRegister.setCertificatetype((byte)1);
		userRegister.setUsertype((byte)1);
		userRegister.setNotsay((byte)1);
		//执行插入
		int tag=registerLoginService.userRegister(userRegister);
		if(tag==1){
			userRegister.setBackupsix(1);
		}else{
			userRegister.setBackupsix(0);
		}
		
		return userRegister; //这么返回是为了，注册成功立马跳转到主页，和登录时一样。
		
	}
	
	
		
}








