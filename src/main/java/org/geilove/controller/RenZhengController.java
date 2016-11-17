package org.geilove.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.geilove.pojo.Picture;
import org.geilove.pojo.Tweet;
import org.geilove.pojo.User;
import org.geilove.response.CommonRsp;
import org.geilove.service.MainService;
import org.geilove.service.RegisterLoginService;
import org.geilove.util.CreateFileUtil;
import org.geilove.util.TimeUtil;
import org.geilove.service.PictureService;
@Controller
@RequestMapping("/renzheng")
public class RenZhengController {	
    
	@Resource
	private MainService  mainService;
	@Resource
	private RegisterLoginService rlService;
	
	@RequestMapping(value="/author",method=RequestMethod.POST)
	@ResponseBody
	public CommonRsp multiUpload(HttpServletRequest request)throws IllegalStateException, IOException{	
		CommonRsp commonRsp=new CommonRsp();
		String token=request.getParameter("token");		
		String userPassword=token.substring(0,32); //token是password和userID拼接成的。
		String useridStr=token.substring(32); //取得userid部分		
		Long userid=Long.valueOf(useridStr).longValue();  //转换成long类型
		//Long userid=Long.parseLong(useridstr);
		String passwdTrue=rlService.selectMD5Password(Long.valueOf(userid));
		//System.out.println(passwdTrue);
		if(!userPassword.equals(passwdTrue)){
			commonRsp.setRetcode(2001);
			commonRsp.setMsg("用户密码不对，非法");
			return commonRsp;
		}
		List<String> imgPathArray=new ArrayList<String>(); 

		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            //System.out.println(multiRequest.getParameterNames().nextElement()); 
            Iterator<String> iter = multiRequest.getFileNames();
            //在本次上传中，这个部分路径是常量
            String constDirectory="/Users/mfhj-dz-001-424/doctorImg/weiboPhoto"; //tomcat配置的常量路径+weiboPhoto
            String timeDirectory=new TimeUtil().getNyDay(); //每天创建一个文件夹,时间路径
            String directory=constDirectory+timeDirectory+'/'+useridStr+'/';                       
            
            while(iter.hasNext()){  
                //记录上传过程起始时的时间，用来计算上传时间  
                //int pre = (int) System.currentTimeMillis();  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //取得当前上传文件的文件名称  
                    String myFileName = file.getOriginalFilename();  
                    //如果名称不为"",说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        //System.out.println(myFileName);  
                        //重命名上传后的文件名  
                        String originfileName = file.getOriginalFilename(); 
                        String millisFileName=new TimeUtil().getMil().toString();
                        String fileName=millisFileName+originfileName; //文件名，包含时间戳与原始文件名，确保不重复                       
                        String path = directory+fileName+".png";
                        //这里面方法更安全，待测试
                        if(CreateFileUtil.createDirectory(directory)==1){//目录已经存在或创建成功                
                        	  File localFile = new File(path);  
                              file.transferTo(localFile); 
                              System.out.println(directory);
                              //这里的path指的是配置里的名字,注意path前面没有/，客户端拼接url地址时应该加上
                              String needPath="path/weiboPhoto"+timeDirectory+fileName+".png"; 
                              imgPathArray.add(needPath);                             
                        }else{
                        	commonRsp.setMsg("创建磁盘目录失败");
                        	commonRsp.setRetcode(2005);
                        	return commonRsp;
                        }                              
                    }//if  
                }//if  
                //记录上传该文件后的时间  
                //int finaltime = (int) System.currentTimeMillis();   
            }//while             
        }// if因为是表单，所以一定会执行if里面，while循环发现无图片会跳出if外
		Picture picture=new Picture();
		//imgPathArray里的url地址放入picture中
		User user=new User();
        String tag=request.getParameter("tag"); //取得标识       
        if(tag.equals("1")){ //爱心社认证
 
        	String realName=request.getParameter("realName"); //真实姓名
        	String phoneNo=request.getParameter("phoneNo"); //手机号
        	String idno=request.getParameter("idno"); //身份证号
        	String school=request.getParameter("school");//社团所属的大学
        	String post=request.getParameter("post");//社团中的职位
        	String status=request.getParameter("status");//简单描述社团现状
        	user.setUserid(userid); //需要根据主键更新
        	user.setRealname(realName);
        	//user.setPhone(phoneNo); //手机号
        	user.setIdentitycard(idno);//身份证号
        	user.setUniversity(school);
        	//user.setPost(post);//社团中的职务
        	user.setSelfintroduce(status);//社团简介
        	/*接下来更新user表*/
        	int returnTga=rlService.updateUserSelective(user);//更新user表
        	
        }else if(tag.equals("2")){ //监督处认证
        	
        }else{ //身份认证
        	
        }
      //把照片放入相片表
    	for(int i=0;i<imgPathArray.size();i++){
    		if(picture.getPhotopathone()==null){
    			picture.setPhotopathone(imgPathArray.get(i));
    		}else if(picture.getPhotopathtwo()==null){
    			picture.setPhotopathtwo(imgPathArray.get(i));
    		}else if(picture.getPhotopaththree()==null){
    			picture.setPhotopaththree(imgPathArray.get(i));
    		}else if(picture.getPhotopathfour()==null){
    			picture.setPhotopathfour(imgPathArray.get(i));
    		}else if(picture.getPhotopathfive()==null){
    			picture.setPhotopathfive(imgPathArray.get(i));
    		}else if(picture.getPhotopathsix()==null){
    			picture.setPhotopathsix(imgPathArray.get(i));
    		}else if(picture.getPhotopathseven()==null){
    			picture.setPhotopathseven(imgPathArray.get(i));
    		}else{
    			picture.setPhotopatheight(imgPathArray.get(i));
    		}       		
    	}
    	String tagg=request.getParameter("tag");
    	picture.setTag(Integer.parseInt(tagg));
    	picture.setUserid(userid);
    	/*接下来新增一条记录到图片表*/
        //插入数据库并判断是否成功
    	commonRsp.setMsg("发布成功");
    	commonRsp.setRetcode(2000);
    	return commonRsp;
	}//multiUpload
}


























