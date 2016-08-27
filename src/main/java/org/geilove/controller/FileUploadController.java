package org.geilove.controller;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.geilove.vo.BaseVo;
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
import org.geilove.vo.UploadDemoVo;

@Controller
@RequestMapping("/demo/upload")
public class FileUploadController {
	
	//单文件 和 多字段上传演示
	@RequestMapping(value="/firstUpload",method=RequestMethod.POST)
	@ResponseBody
//	public Object firstUpload(HttpServletRequest request, UploadDemoVo demo,@RequestParam String inputStr){
	public Object firstUpload(HttpServletRequest request, @RequestParam(value="files" ) CommonsMultipartFile files) throws  IllegalStateException, IOException {
		System.out.println(files.getOriginalFilename());
		
		//System.out.println(inputStr);
		//System.out.println(request.getParameter("imgFile").toString()); 这个报错，说明除了文件，其它的可以通过request获得
		//System.out.println(request.getParameter("abc"));
		
        boolean flag = false;
        //errorMessage：上传失败，则是错误信息；上传成功，则提示成功以及显示文件上传后的地址
              
        return 2;
    }
	
	@RequestMapping(value="/multiUpload",method=RequestMethod.POST)
	@ResponseBody
	public Object multiUpload(HttpServletRequest request)throws IllegalStateException, IOException{
//        System.out.println(request.getParameter("files").getBytes());//这个是能接收到的
//        System.out.println(request.getParameter("key"));//这个是能接收到的
//        System.out.println(request.getRequestURI());
//        System.out.println(request.getRequestURL());
//        System.out.println(request.getQueryString());
//        System.out.println(request.getMethod());
//        System.out.println(request.getRemoteAddr());
//        System.out.println(request.getRemoteHost());
//        System.out.println(request.getRemotePort());
//        System.out.println(request.getLocalAddr());
//        Enumeration e = request.getHeaderNames();
//        while(e.hasMoreElements()){
//	        String name = (String) e.nextElement();
//	        String value = request.getHeader(name);
//	        System.out.println(name+":"+value);
//        }
         MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
         CommonsMultipartFile orginalFile = (CommonsMultipartFile) multipartRequest.getFile("fileone");
         CommonsMultipartFile file2 = (CommonsMultipartFile) multipartRequest.getFile("filetwo");
         String filename = orginalFile.getOriginalFilename();
         String file2name = file2.getOriginalFilename();
         System.out.println(filename);
         System.out.println(file2name);
         DataOutputStream out = new DataOutputStream(new FileOutputStream("/Users/mfhj-dz-001-424/Documents/aaa/hh" + filename+".jpg"));
         InputStream is = null;// 附件输入流
         try {
	          is = orginalFile.getInputStream();
	          byte[] b=new byte[is.available()];
	          is.read(b);
	          out.write(b);
	         } 
         catch (IOException exception) {
	        	  exception.printStackTrace();
	         }
         finally {
	        	 if (is != null) {
	        		 is.close();
	         }
         }
		
		
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //记录上传过程起始时的时间，用来计算上传时间  
                int pre = (int) System.currentTimeMillis();  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //取得当前上传文件的文件名称  
                    String myFileName = file.getOriginalFilename();  
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        System.out.println(myFileName);  
                        //重命名上传后的文件名  
                        String fileName = "demoUpload" + file.getOriginalFilename();  
                        //定义上传路径  
                        String path = "/Users/mfhj-dz-001-424/Documents/aaa/" + fileName+".png";  
                        File localFile = new File(path);  
                        file.transferTo(localFile);  
                    }  
                }  
                //记录上传该文件后的时间  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre);  
            }  
              
        } 		
		return 1;
	}
	@RequestMapping(value="/multiUploadTest",method=RequestMethod.POST)
	@ResponseBody
	public Object multiTest(HttpServletRequest request, @RequestParam(value="files" ) CommonsMultipartFile[] files){
		System.out.println(files[0].getOriginalFilename());
//		List<CommonsMultipartFile> lf=new ArrayList<CommonsMultipartFile>();
//		lf=files;
//		for(int i = 0;i<lf.size();i++){  
//            System.out.println("fileName---------->" + lf.get(i).getOriginalFilename());
//		}
//				
		return 1;
	}
	
	@RequestMapping(value="/singleFile",method=RequestMethod.POST)
	@ResponseBody
	public Object singleFile(HttpServletRequest request, @RequestParam(value="files",required = false) CommonsMultipartFile files){
		System.out.println(files.getOriginalFilename()); 
//		List<CommonsMultipartFile> lf=new ArrayList<CommonsMultipartFile>();
//		lf=files;
//		for(int i = 0;i<lf.size();i++){  
//            System.out.println("fileName---------->" + lf.get(i).getOriginalFilename());
//		}
//				
		return 1;
	}
}


























