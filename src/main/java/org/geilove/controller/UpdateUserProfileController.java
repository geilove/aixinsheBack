package org.geilove.controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.geilove.pojo.User;
import org.geilove.requestParam.FindpwParam;
import org.geilove.vo.UserLoginVo;
import org.geilove.service.RegisterLoginService;
import org.geilove.util.MD5;
import org.geilove.util.Md5Util;
import org.geilove.vo.UserRegisterVo;
import org.geilove.response.UserProfileRsp;
import org.geilove.response.CommonRsp;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class UpdateUserProfileController {
	@Resource
	private RegisterLoginService rlService;
	
	@RequestMapping("/completeProfile")
	public @ResponseBody CommonRsp completeProfile(HttpServletRequest request){
		CommonRsp commonRsp=new CommonRsp();
		String token=request.getParameter("token");			
		String userPassword=token.substring(0,32); //token是password和userID拼接成的。
		String useridStr=token.substring(32);		
		Long userid=Long.valueOf(useridStr).longValue();		
		String passwdTrue=rlService.selectMD5Password(Long.valueOf(userid));
		if(!userPassword.equals(passwdTrue)){
			commonRsp.setRetcode(2001);
			commonRsp.setMsg("用户密码不对，非法");
			return commonRsp;
		}
		User user=new User();
		String  sex=request.getParameter("sex");
		String userTag=request.getParameter("label");
		String  selfIntroduce=request.getParameter("content");	
		user.setUserid(userid);
		user.setSex(sex);
		user.setUsertag(userTag);
		user.setSelfintroduce(selfIntroduce);
		try{
			int returnTag=rlService.updateUserSelective(user);
			System.out.println(returnTag);
			if(returnTag!=1){
				commonRsp.setMsg("完善资料失败");
				commonRsp.setRetcode(2000);
				return commonRsp;
			}
		}catch(Exception e){
			
		}
		commonRsp.setMsg("更新资料成功");
		commonRsp.setRetcode(2000);
		return commonRsp;
	}
}
