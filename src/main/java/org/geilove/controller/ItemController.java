package org.geilove.controller;

//这个是项目表，提供项目相关的发布，删除等接口，
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
import org.geilove.requestParam.ItemPartParam;
import org.geilove.pojo.Item;
import org.geilove.requestParam.ItemListParam;
import org.geilove.response.ItemListRsp;
import org.geilove.response.ItemPartRsp;
import org.geilove.service.ItemService;
import org.geilove.sqlpojo.OtherPartHelpPojo;
import org.geilove.service.HelpService;
import org.geilove.vo.ItemFull;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Resource
	ItemService itemService;
	@Resource
	HelpService helpService;
	
	//用来获取项目表部分信息
	@RequestMapping(value="/itempart",method=RequestMethod.POST)
	public @ResponseBody ItemPartRsp getOhterItemList(@RequestBody ItemPartParam ls ){
		ItemPartRsp ip=new ItemPartRsp();
		List<Long> useridlist=new ArrayList<Long>();
		useridlist.add(ls.getCircleIDStart());
		useridlist.add(ls.getCircleIDSupervise());
		useridlist.add(ls.getUserIDPrincipal());
		List<OtherPartHelpPojo>lpo=helpService.getOtherPartHelpList(useridlist);
		if(lpo.size()>0){
			ip.setLp(lpo);
			ip.setMsg("获取数据成功");
			ip.setRetcode(2000);
		}else{
			ip.setLp(lpo);
			ip.setRetcode(2001);
			ip.setMsg("出错了");
		}
		
		return ip;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public @ResponseBody ItemListRsp getItemList(@RequestBody ItemListParam param ){
		
		//String proof=param.getProof();
		Long userID=param.getUserID();
		Integer page=param.getPage();
		Integer pageSize=param.getPageSize();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userID", userID);
		map.put("page", page);
		map.put("pageSize", pageSize);
		//SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		//Timestamp timeupdate=new Timestamp(param.getLastUpdate()); 
		System.out.println(param.getLastUpdate());	
	    //SimpleDateFormat formats =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		//Timestamp itemtime=new Timestamp(param.getLastItemstart());
		//System.out.println(param.getLastItemstart());		
	    map.put("lastUpdate", param.getLastUpdate());	   
	    map.put("lastItemstart", param.getLastItemstart());
	    map.put("flag", param.getFlag());
	  
		ItemListRsp rsp=new ItemListRsp();           
		List<Item> lsitem=itemService.getItemList(map); //总条数 	
		if(lsitem.size()==0){ 
			rsp.setMsg("数据为空");
			rsp.setRetcode(2001);
		}else if(lsitem.size()>0){
			//rsp.setLp(lsitem);
			List<ItemFull> listItemFull=new ArrayList<ItemFull>();
			
			//OtherPartHelpPojo pj=new OtherPartHelpPojo();			
			for(int i=0;i<lsitem.size();i++){
				List<OtherPartHelpPojo>lpo =new ArrayList<OtherPartHelpPojo>();
				Item item=new Item();
				List<Long> ll=new ArrayList<Long>();
				ItemFull itemFull =new ItemFull();
				item=lsitem.get(i);
				
				ll.add(item.getCircleidstart());
				ll.add(item.getCircleidsupervise());
				ll.add(item.getUseridprincipal());
				lpo=helpService.getOtherPartHelpList(ll); //列表的每一项包含了昵称，头像，简介，头像是否上传信息
				//现在开始合并列表 lpo 和 lsitem
				itemFull.setItem(item);
				if(lpo.size()>0){
				    for(int j=0;j<lpo.size();j++){
				    	if(lpo.get(j).getUserid()==item.getCircleidstart()){
				    		itemFull.setCircleidstartNickName(lpo.get(j).getUsernickname());
				    		itemFull.setCircleidstartPhoto(lpo.get(j).getUserphoto());				    		
				    	}else if(lpo.get(j).getUserid()==item.getUseridprincipal()){
				    		itemFull.setUseridprincipalNickName(lpo.get(j).getUsernickname());			    		
				    	}else{
				    		itemFull.setCircleidsuperviseNickName(lpo.get(j).getUsernickname());			    		
				    	}				    	
				    }//for
				    listItemFull.add(itemFull);
				    
				}//if 
				
			}//for
			
			rsp.setLp(listItemFull);
			rsp.setMsg("成功了");
			rsp.setRetcode(2000);
			return rsp;
		}else{
			rsp.setLp(null);
			rsp.setMsg("未知错误");
			rsp.setRetcode(2002);
		}		
		return rsp;		
	}
}
