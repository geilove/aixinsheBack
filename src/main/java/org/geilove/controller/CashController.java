package org.geilove.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.geilove.pojo.Cash;
import org.geilove.pojo.Tweet;
import org.geilove.requestParam.CashParam;
import org.geilove.response.CommonRsp;
import org.geilove.service.CashService;
import org.geilove.service.MainService;
import org.geilove.service.RegisterLoginService;
import org.geilove.util.CreateFileUtil;
import org.geilove.util.TimeUtil;

@Controller
@RequestMapping("/cash")
public class CashController {
	@Resource
	private MainService  mainService;
	@Resource
	private RegisterLoginService rlService;
	@Resource
	private CashService cashService;
    /*如果推文是救助信息，这里获取有关救助的说明*/	
	@RequestMapping(value="/getcashrecord",method=RequestMethod.POST)
	public @ResponseBody Cash getCashRecord(@RequestBody CashParam cashparam){
		Cash cash=new Cash();		
		cash=cashService.getCashRecord(new Long(cashparam.getCashid()));  //转换为long类型
		return cash;
	}
	
	@RequestMapping(value="/addhelpman",method=RequestMethod.POST)
	@ResponseBody
	public CommonRsp addHelpMan(HttpServletRequest request)throws IllegalStateException, IOException{	
		CommonRsp commonRsp=new CommonRsp();
		System.out.println("接收到请求");
		String token=request.getParameter("token");			
		String userPassword=token.substring(0,32); //token是password和userID拼接成的。
		String useridStr=token.substring(32);		
		Long userid=Long.valueOf(useridStr).longValue();
		String passwdTrue=rlService.selectMD5Password(Long.valueOf(userid));
		System.out.println(passwdTrue);
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
                
            }//while             
        }// if因为是表单，所以一定会执行if里面，while循环发现无图片会跳出if外
		Tweet tweet=new Tweet();
		tweet.setUseridtweet(userid); //发布推文的userid
		tweet.setSourcemsgid(new Long(1));//1代表非转发
        String content=request.getParameter("content"); //推文内容，有关困难的详细描述
        tweet.setMsgcontent(content); //放入推文内容到tweet中
        String chengnuoContent=request.getParameter("chengnuoContent"); //承诺的语句，这个要放到推文表
        tweet.setPromise(chengnuoContent); //受助人的承诺
        tweet.setTagid((byte)1 );
        tweet.setTopic(new Long(1));
        tweet.setBoxtimes(0);
        tweet.setCommenttimes(0);
        tweet.setOk(0);
        Date date=new Date();
        tweet.setPublishtime(date);
        tweet.setReportedtimes(0);
        tweet.setPublicsee((byte)1); //1代表可见
        tweet.setDeletetag((byte)1); //1代表未删除
        tweet.setVideoaddress(null); //推文只限制3张图
        tweet.setPromise(null); //如果是救助一个人，则必须有文字
        tweet.setTweetbackupseven(null);
        tweet.setTweetbackupfour(1); //备用4等于1代表是一个普通的推文2代表的是救助     
        tweet.setTweetbackupfive(1); //2代表党推文是救助时cash表
        for(int i=0;i<imgPathArray.size();i++){
        	if(tweet.getTweetbackupone()==null){
        		tweet.setTweetbackupone(imgPathArray.get(i));
        	}else if(tweet.getTweetbackuptwo()==null){
        		tweet.setTweetbackuptwo(imgPathArray.get(i));
        	}else{
        		tweet.setTweetbackupthree(imgPathArray.get(i));
        	}
        }  
        try{
        	Integer tag=mainService.addTweet(tweet);
        	if(tag!=1){ 
        		commonRsp.setRetcode(2001);
        		commonRsp.setMsg("救助推文插入数据库失败");
        		return commonRsp;
        	}
        }catch( Exception e){
        	System.out.println(e);
        }
        //把其它的数据插入到cash表中
        Cash cash=new Cash();
        String circleUserName=request.getParameter("AXSnickName"); //爱心社昵称
        cash.setCircleusername(circleUserName);
        String superUserName=request.getParameter("JDnickName"); //监督处昵称
        cash.setSuperusername(superUserName);
        String  dutyUserName=request.getParameter("JTFZnickName"); //具体负责人昵称
        cash.setDutyusername(dutyUserName);
        String  beHelpUserName=request.getParameter("SZRnickName"); //受助人昵称
        cash.setBehelpusername(beHelpUserName);
        String  backupone=request.getParameter("FQRnickName"); //发起人昵称
        cash.setBackupone(backupone);
        cash.setCountstate((byte)2); // 账户开启
        cash.setRealcash(0); //开始的时候实际金额是0
        cash.setGetmoneytag((byte)1); //1 代表还不可以提取钱
        cash.setCashok((byte)1); //1代表不可以提取钱
        cash.setSpendmoney(0); //已经支出的钱
        
        String idZhangming=request.getParameter("idZhangming"); //是否有身份证明
        String jwZhengming=request.getParameter("jwZhengming"); //是否用居委会证明
        String yyZhengming=request.getParameter("yyZhengming"); //是否有医院证明
        String qtZhengming=request.getParameter("qtZhengming"); //是否有其它权威证明
        String promiseType=request.getParameter("chengnuoType"); //承诺的类型
        //String chengnuoContent=request.getParameter("chengnuoContent"); //承诺的语句，这个要放到推文表
        String targetCash=request.getParameter("targetMoney"); //目标金额
        String  opentime=request.getParameter("startDate"); //账户开启时间
        String closetime=request.getParameter("endDate"); //账户关闭的时间
        String backupsix=request.getParameter("duration"); //持续时长，backupsix存放
        String  backupfour=request.getParameter("moneyTitle"); //筹款的标题 
        try{
        	Integer tag=cashService.cashInsert(cash);
        	if(tag!=1){ 
        		commonRsp.setRetcode(2001);
        		commonRsp.setMsg("cash表插入失败");
        		return commonRsp;
        	}
        }catch( Exception e){
        	System.out.println(e);
        }
        
    	commonRsp.setMsg("发布成功");
    	commonRsp.setRetcode(2000);
    	return commonRsp;
	}//multiUpload
}
	
		
