package org.geilove.controller;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

	@RequestMapping(value="/multiUpload",method=RequestMethod.POST)
	@ResponseBody
	public Object multiUpload(HttpServletRequest request)throws IllegalStateException, IOException{
		System.out.println(request.getServerName());
		System.out.println(request.getServerPort());
		System.out.println(request.getContextPath());

		
		Map<String,Object> map = new HashMap<String,Object>();
        Enumeration<?> paramNames = request.getParameterNames(); //取得所有TextInput的键       
        while (paramNames.hasMoreElements()) {  
            String paramName = (String) paramNames.nextElement(); 
            //request.getParameterValues(String   name)是获得如checkbox类（名字相同，但值有多个）的数据
            String[] paramValues = request.getParameterValues(paramName);   
            if (paramValues.length == 1) {  
                String paramValue = paramValues[0];  
                if (paramValue.length() != 0) {  
                    map.put(paramName, paramValue);  
                }  
            }  
        }  	  
        Set<Map.Entry<String, Object>> set = map.entrySet();  
        //System.out.println(map.get("key1"));  
        System.out.println("------------------------------");  
        for (Map.Entry<String, Object> entry : set) {  
            System.out.println(entry.getKey() + ":" + entry.getValue());  
        }  
        System.out.println("------------------------------");  
		
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            //System.out.println(multiRequest.getParameterNames().nextElement()); 
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
                        //System.out.println(myFileName);  
                        //重命名上传后的文件名  
                        String fileName = "demoUpload" + file.getOriginalFilename();  
                        //定义上传路径/Users/mfhj-dz-001-424/doctorImg/weiboPhoto/年/月/日/+fileName+.png
                        String path = "/Users/mfhj-dz-001-424/Documents/aaa/" + fileName+".png";  
                        File localFile = new File(path);  
                        //把上传路径的/weiboPhoto/年/月/日/+fileName+.png ，这段存入数据库，前半部分已经配置在tomcat的path.xml里面了
                        file.transferTo(localFile);  
                    }  
                }  
                //记录上传该文件后的时间  
                int finaltime = (int) System.currentTimeMillis();   
            }                
        } 
		return 1;
	}
}


























