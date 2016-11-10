package org.geilove.controller;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.geilove.response.CommonRsp;
import org.geilove.service.MainService;
import org.geilove.service.RegisterLoginService;
@Controller
@RequestMapping("/photo")
public class PhotoUploadController {//上传用户头像
    
	@Resource
	private MainService  mainService;
	@Resource
	private RegisterLoginService rlService;
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public CommonRsp multiUpload(HttpServletRequest request)throws IllegalStateException, IOException{
		System.out.print("aaa");
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
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
         CommonsMultipartFile orginalFile = (CommonsMultipartFile) multipartRequest.getFile("photo");
         String filename = orginalFile.getOriginalFilename();
         System.out.println(filename);         
         DataOutputStream out = new DataOutputStream(new FileOutputStream("/Users/mfhj-dz-001-424/Documents/aaa" + filename+".jpg"));
         InputStream is = null;// 附件输入流
         try {
	          is = orginalFile.getInputStream();
	          byte[] b=new byte[is.available()];
	          is.read(b);
	          out.write(b);
	         } 
         catch (IOException exception) {
	        	  exception.printStackTrace();
	        	commonRsp.setMsg("上传头像失败");
	          	commonRsp.setRetcode(2001);
	          	return commonRsp;
	         }
         finally {
	        	 if (is != null) {
	        		 is.close();
	         }
         }
        //插入数据库并判断是否成功
    	commonRsp.setMsg("发布成功");
    	commonRsp.setRetcode(2000);
    	return commonRsp;
	}
}



























