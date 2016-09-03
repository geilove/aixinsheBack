package org.geilove.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.geilove.service.PictureService;
import org.geilove.sqlpojo.PicturePojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.geilove.requestParam.PicListParam;
import org.geilove.response.PicListRsp;
@Controller
@RequestMapping(value="/picture")
public class PictureController {
     @Resource
     PictureService  pictureService;
     
     @RequestMapping(value="/getpicture",method=RequestMethod.POST)
     @ResponseBody
     public  PicListRsp getMapPicture(@RequestBody PicListParam pparam){ 
    	 PicListRsp rsp = new PicListRsp();
    	 Map<String,Object> map=new HashMap<String,Object>();
    	 Integer tag=pparam.getTag();
    	 Integer page =pparam.getPage();
    	 Integer pageSize=pparam.getPageSize();
    	 map.put("tag", tag);
    	 map.put("page", page);
    	 map.put("pageSize", pageSize);  
    	 
    	 List<PicturePojo> lp=pictureService.getSomePictures(map);
    	 if(lp.size()>0){
    		 rsp.setLp(lp);
    		 rsp.setMsg("成功");
    		 rsp.setRetcode(2000);
    	 }else{
    		 rsp.setLp(null);
    		 rsp.setMsg("失败了");
    		 rsp.setRetcode(2001);
    	 }
    	 return rsp;
     } 
     
}










