
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
@RequestMapping("/user")
public class RegisterLoginController {
	
	@Resource
	private RegisterLoginService registerLoginService; 
	
	
	//登录
	@RequestMapping(value="/login",method=RequestMethod.POST)	
	public @ResponseBody UserProfileRsp loginUser(@RequestBody UserLoginVo userLoginVo,HttpSession httpSession){
		httpSession.setAttribute("session", "hellosession");  
		//这里应该先验证用户邮箱和密码是不是符合要求，避免浪费资源查询数据库
		UserProfileRsp  userProfileRsp=new UserProfileRsp();		
		User user=registerLoginService.userLogin(userLoginVo.getUserEmail());
		if(user==null){
			userProfileRsp.setData(null);
			userProfileRsp.setMsg("不存在此用户");
			userProfileRsp.setRetcode(2001); //不存在此用户
		}
		else {
			//这里应该对密码进行md5加密，然后验证
			String pw=Md5Util.getMd5(userLoginVo.getUserPassword());
			//System.out.println(pw);
			//System.out.println(user.getUserpassword());
			if(pw.equals(user.getUserpassword())){
				//这里应该加入token
				//CheckUser checkUser =new CheckUser(userLoginVo.getUserPassword());
				//TokenData tokenData=new TokenData();
				//stokenData=checkUser.handleToken();
				//执行插入
				String token=pw+user.getUserid();
				user.setBackupfour(token);
				userProfileRsp.setData(user);
				userProfileRsp.setMsg("登录成功");
				userProfileRsp.setRetcode(2000); 
			}else{
				userProfileRsp.setData(null);
				userProfileRsp.setMsg("您输入的密码不对");
				userProfileRsp.setRetcode(2002); //用户密码错误
			}			
		}		
		return userProfileRsp;
	}
	
	//注册
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody CommonRsp registerUser(@RequestBody  UserRegisterVo userRegisterVo){
		//这里假设昵称唯一可用，邮箱可用，两次输入的密码一样
		//如果可以注册，应对密码md5加密
		CommonRsp commonRsp=new CommonRsp();
		User userRegister=new User();
		String userEmail=userRegisterVo.getUserEmail();
		String userPassword =userRegisterVo.getUserPassword();
		String userNickName=userRegisterVo.getUserNickName();
		if(userEmail.length()<10 || userEmail.length()>30 ||userPassword.length()<6 ||userPassword.length()>18 ||userNickName.length()<3 ||userNickName.length()>30){
			commonRsp.setMsg("长度不合法");
			commonRsp.setRetcode(2001);
			return commonRsp;
		}	
		String regEmail = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		String regPass="^[0-9a-zA-Z]{5,17}$"; //邮箱密码的正则表达式		
		Pattern pattern=Pattern.compile(regEmail);
		Matcher matcher=pattern.matcher(userEmail);
		boolean emailb=matcher.matches();
		if(emailb==false){
			commonRsp.setMsg("邮箱不符合格式");
			commonRsp.setRetcode(2001);
			return commonRsp;
		}
		
		Pattern patternPW=Pattern.compile(regPass);
		Matcher matcherPW=patternPW.matcher(userPassword);
		boolean pwb=matcherPW.matches();
		if(pwb==false){
			commonRsp.setMsg("密码不符合格式");
			commonRsp.setRetcode(2001);
			return commonRsp;
		}
		//这里对userPassword 加密存入数据库
		String pwMD5=Md5Util.getMd5(userRegisterVo.getUserPassword());
		//System.out.println(pwMD5);
		userRegister.setUsernickname(userRegisterVo.getUserNickName());
		userRegister.setUseremail(userRegisterVo.getUserEmail());
		userRegister.setUserpassword(pwMD5);
		
		userRegister.setPhotoupload((byte) 1);
		userRegister.setNotsay((byte)1);
		userRegister.setCertificatetype((byte)1);
		userRegister.setUsertype((byte)1);
		userRegister.setNotsay((byte)1);
		//这里需要先查询是否有该邮箱和昵称
		int tag=registerLoginService.userRegister(userRegister);		
		if(tag==1){
			commonRsp.setMsg("注册成功");
			commonRsp.setRetcode(2000);
		}else{
			commonRsp.setMsg("注册失败");
			commonRsp.setRetcode(2001);
		}		
		return commonRsp; //这么返回是为了，注册成功立马跳转到主页，和登录时一样。		
	}
   //这个是找回密码。
	@RequestMapping(value="/findpassword",method=RequestMethod.POST)
	public @ResponseBody CommonRsp findPassword(@RequestBody  FindpwParam param) throws MessagingException{
		CommonRsp rsp=new CommonRsp();
		String userEmail=param.getUserEmail();
		if(userEmail.length()<10 || userEmail.length()>30 ){
			rsp.setMsg("邮箱长度不合法");
			rsp.setRetcode(2001);
			return rsp;
		}	
		String regEmail = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";	
		Pattern pattern=Pattern.compile(regEmail);
		Matcher matcher=pattern.matcher(userEmail);
		boolean emailb=matcher.matches();
		if(emailb==false){
			rsp.setMsg("邮箱不符合格式");
			rsp.setRetcode(2001);
			return rsp;
		}
		String userPassword=null;	
		userPassword=registerLoginService.findPasswd(userEmail);
		if(userPassword==null){
			rsp.setMsg("不存在此用户");
			rsp.setRetcode(2001);
			return rsp;
		}
		// 配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.126.com");
        // 发件人的账号
        props.put("mail.user", "noexception@126.com");
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "818ooXXaa$$");
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress( props.getProperty("mail.user"));
        message.setFrom(form);
        // 设置收件人
        InternetAddress to = new InternetAddress(userEmail);
        message.setRecipient(RecipientType.TO, to);
//        // 设置抄送
//        InternetAddress cc = new InternetAddress("luo_aaaaa@yeah.net");
//        message.setRecipient(RecipientType.CC, cc);
//        // 设置密送，其他的收件人不能看到密送的邮件地址
//        InternetAddress bcc = new InternetAddress("aaaaa@163.com");
//        message.setRecipient(RecipientType.CC, bcc);
        // 设置邮件标题
        message.setSubject("手套爱心社密码找回邮件");
        // 应该做一个网页，让用户重置密码
        message.setContent("<a href='#'>点击超链接重置密码</a>", "text/html;charset=UTF-8");
        // 发送邮件
        Transport.send(message);
        rsp.setMsg("发送成功");
        rsp.setRetcode(2000);
		return rsp;
	}
	//修改密码
	@RequestMapping(value="/resetpass",method=RequestMethod.POST)
	public @ResponseBody CommonRsp resetPassword(HttpServletRequest request) {
		CommonRsp commonRsp=new CommonRsp();
		String token=request.getParameter("token");			
		String userPassword=token.substring(0,32); //token是password和userID拼接成的。
		System.out.println(userPassword);
		String useridStr=token.substring(32);		
		Long userid=Long.valueOf(useridStr).longValue();
		//Long userid=Long.parseLong(useridstr);
		String passwdTrue=registerLoginService.selectMD5Password(Long.valueOf(userid));
		System.out.println(passwdTrue);
		
		if(!userPassword.equals(passwdTrue)){
			commonRsp.setRetcode(2001);
			commonRsp.setMsg("用户身份验证失败");
			return commonRsp;
		}
		String  originPass=request.getParameter("originPass"); 
		String  newPass=request.getParameter("newPass");
		String againPass=request.getParameter("againPass");
		String md5pass=MD5.string2MD5(originPass); //对原始密码加密
		if(!md5pass.equals(passwdTrue)){
			commonRsp.setRetcode(2001);
			commonRsp.setMsg("用户密码不对，非法");
			return commonRsp;
		}
		if(!againPass.equals(newPass)){
			commonRsp.setRetcode(2001);
			commonRsp.setMsg("两次输入新密码不一致");
			return commonRsp;
		}
		if(newPass.length()<6 ||newPass.length()>18 ||againPass.length()<6 ||againPass.length()>18){
			commonRsp.setRetcode(2001);
			commonRsp.setMsg("新密码长度不合法");
			return commonRsp;
		}
		String regPass="^[0-9a-zA-Z]{5,17}$"; //邮箱密码的正则表达式	
		Pattern patternPW=Pattern.compile(regPass);
		Matcher matcherNewPW=patternPW.matcher(newPass);
		Matcher matcherAgainPW=patternPW.matcher(newPass);
		boolean pwb=matcherNewPW.matches();
		boolean againpwb=matcherAgainPW.matches();
		if(pwb==false ||againpwb==false){
			commonRsp.setMsg("密码不符合格式");
			commonRsp.setRetcode(2001);
			return commonRsp;
		}
		//接下来调用更新user表的方法，对密码进行更新
		User user=new User();
		user.setUserid(userid);
		user.setUserpassword(MD5.string2MD5(newPass));
		try{
			int tag=registerLoginService.updateUserSelective(user);
			if(tag!=1){
				commonRsp.setMsg("密码更新失败");
				commonRsp.setRetcode(2001);
				return commonRsp;
			}
		}catch(Exception e){
			
		}
		commonRsp.setMsg("密码更新成功");
		commonRsp.setRetcode(2000);
		return commonRsp;
	}	
}





















