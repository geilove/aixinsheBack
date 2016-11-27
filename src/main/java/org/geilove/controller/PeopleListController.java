package org.geilove.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.geilove.service.PeopleListService;
import org.geilove.service.MainService;
import org.geilove.pojo.User;
import org.geilove.requestParam.CommentListParam;
import org.geilove.requestParam.CommonPeopleListParam;
import org.geilove.requestParam.DonaterListParam;
import org.geilove.sqlpojo.PeopleNeedLovePojo;
import org.geilove.response.NeedLovePeopleListRsp;
import org.geilove.response.PeopleListRsp;
import org.geilove.sqlpojo.LoveClubListPojo;
import org.geilove.sqlpojo.PartHelpPojo;
import org.geilove.response.LoveClubPeopleListRsp;
import org.geilove.sqlpojo.DonaterPojo;
import org.geilove.response.CommonRsp;
import org.geilove.response.DonaterListRsp;
import org.geilove.service.HelpService;
/*
 *这里提供诸如爱心社列表 青年志愿者协会  监督处列表 社会公益机构列表 公益排行榜列表  粉丝列表  我关注列表  我帮助  帮助我列表
 */

@Controller
@RequestMapping("/peoplelist")
public class PeopleListController {
	@Resource
	private PeopleListService peopleListService;
	@Resource
	private MainService mainService;
	@Resource
	private HelpService helpService;
	//1普通，2社团，3监督，4志愿者，5社会公益机构 
	@RequestMapping(value="/lsmen")
	public @ResponseBody PeopleListRsp getMenList(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		String token=commonPeopleListParam.getToken();
		Integer loadMoreTag=commonPeopleListParam.getLoadMoreTag();//1代表刷新，2代表loadMore
		Integer tag=commonPeopleListParam.getTag(); //1普通，2社团，3监督，4志愿者， 
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();
		String lastTime=commonPeopleListParam.getLastTime(); //		
		PeopleListRsp rsp=new PeopleListRsp();		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("loadMoreTag", loadMoreTag);
		map.put("tag", tag);
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("lastTime", lastTime); //这里的lastTime指的就是用户的注册时间
		List<User> lp=new ArrayList<User>(); 
		try{
			lp=peopleListService.getMenList(map);
			if(lp==null ||  lp.isEmpty()){
				rsp.setData(lp);
				rsp.setMsg("没有更多数据了");
				rsp.setRetcode(2001);
			}
		}catch(Exception e){
			rsp.setData(null);
			rsp.setMsg("没有更多数据了");
			rsp.setRetcode(2001);
			return rsp;
		}
		//循环lp，将用户密码统一设置为null
		rsp.setData(lp);
		if(lp==null || lp.isEmpty()){
			rsp.setMsg("没有更多数据了");
			rsp.setRetcode(2001);
		}else{
			rsp.setMsg("获取Men列表成功");
			rsp.setRetcode(2000);
		}
		
		return rsp;  //这个需要更改返回值
	}
	/*
	 * 公益排行版列表，直接根据user表查找就可以
	 * */
	@RequestMapping(value="/donater")
	public @ResponseBody PeopleListRsp getDonaterMen(@RequestBody DonaterListParam commonPeopleListParam ){
		PeopleListRsp rsp=new PeopleListRsp();
		Integer tag=commonPeopleListParam.getTag(); //1 捐钱了 2没捐钱。与user表的tobeuseone对应
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();				
		Integer money=commonPeopleListParam.getMoney(); //对应User表的userDonate，要按照这个降序排序
		Integer loadMoreTag=commonPeopleListParam.getLoadMoreTag(); //1刷新 2加载更多
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tag", tag); //1代表未捐钱  2代表捐钱了
		map.put("loadMoreTag", loadMoreTag);
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("money", money);  //对应userDonate
		
		List<User> lp=new ArrayList<User>();
		try{
			lp=peopleListService.gongyiPeopleList(map);
		}catch(Exception e){
			rsp.setData(null);
			rsp.setMsg("没有更多内容了");
			rsp.setRetcode(2001);
			return rsp;
		}
		if(lp==null || lp.size()==0 ||lp.isEmpty() ){
			rsp.setData(null);
			rsp.setMsg("没有更多内容了");
			rsp.setRetcode(2001);
		}else{
			rsp.setData(lp);
			rsp.setMsg("获取公益排行榜成功");
			rsp.setRetcode(2000);
		}
		return rsp;
	}
	//我关注的人列表 
	@RequestMapping(value="/watchs")
	public @ResponseBody PeopleListRsp getWatchMen(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		PeopleListRsp rsp=new PeopleListRsp();	
		String token=commonPeopleListParam.getToken();			
		String useridStr=token.substring(32);		
		Long userid=Long.valueOf(useridStr).longValue();		
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();		
		Integer loadMoreTag=commonPeopleListParam.getLoadMoreTag(); //1刷新 2loadMore
		String lastTime=commonPeopleListParam.getLastTime();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("loadMoreTag", loadMoreTag);
		map.put("userID", userid); //xml中是userid必须对应
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("lastTime", lastTime); // 这里的lastTime指的就是关注的时间
		List<User> lp=new ArrayList<User>();
		//先到关注表查询关注关心，获取到一组id，用这组id获取关注人列表已有现成代码	
		List<Long> ll=new ArrayList<Long>();
		try{
			//我所关注人的ids,根据关注的时间，是在这里进行了refresh和loadMore的控制,筛选出一组合适的ids
			ll=mainService.getWatcherIdsListMen(map); 
			
			if(ll==null ||ll.size()==0 ||ll.isEmpty()){
				rsp.setData(null);
				rsp.setMsg("没有更多数据了");
				rsp.setRetcode(2001);
				return rsp;
			}
		}catch(Exception e){
			rsp.setData(null);
			rsp.setMsg("没有更多数据了");
			rsp.setRetcode(2001);
			return rsp;
		}	
		
		try{
			lp=peopleListService.getPayOrWatchMen(ll);
			
			if(lp.isEmpty() ||lp==null ||ll.size()==0 ){
				rsp.setData(lp);
				rsp.setMsg("还没有关注别人");
				rsp.setRetcode(2001);
				return rsp; 
			}
		}catch(Exception e){
			System.out.println(e);			
			rsp.setData(lp);
			rsp.setMsg("没有更多数据了");
			rsp.setRetcode(2001);
			return rsp; 
		}
		//循环lp，将用户密码统一设置为null
		rsp.setData(lp);
		rsp.setMsg("获取关注人列表成功");
		rsp.setRetcode(2000);
		return rsp;  //这个需要更改返回值
	}
	//我的粉丝列表
	@RequestMapping(value="/fans")
	public @ResponseBody PeopleListRsp getFansMen(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		PeopleListRsp rsp=new PeopleListRsp();	
		String token=commonPeopleListParam.getToken();			
		String useridStr=token.substring(32);		
		Long userid=Long.valueOf(useridStr).longValue();		
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();		
		Integer loadMoreTag=commonPeopleListParam.getLoadMoreTag(); //1刷新 2loadMore
		String lastTime=commonPeopleListParam.getLastTime();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("loadMoreTag", loadMoreTag);
		map.put("userid", userid); //xml中是userid必须对应
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("lastTime", lastTime);
		List<User> lp=new ArrayList<User>();
		//先到关注表查询关注关心，获取到一组id，用这组id获取关注人列表已有现成代码	
		List<Long> ll=new ArrayList<Long>();
		try{
			ll=mainService.getMyFansids(map); //我所关注人的ids
			if(ll==null ||ll.isEmpty()){
				rsp.setData(null);
				rsp.setMsg("没有更多数据了");
				rsp.setRetcode(2001);
				return rsp;
			}
		}catch(Exception e){
			rsp.setData(null);
			rsp.setMsg("没有更多数据了");
			rsp.setRetcode(2001);
			return rsp;
		}
        try{
    		lp=peopleListService.getPayOrWatchMen(ll); //getPayOrWatchMen这个方法获取了用户的所有信息
    		if(lp==null || lp.isEmpty()){
				rsp.setData(lp);
				rsp.setMsg("没有更多数据了");
				rsp.setRetcode(2001);
				return rsp; 
			}
        }catch(Exception e){
        	rsp.setData(lp);
			rsp.setMsg("没有更多数据了");
			rsp.setRetcode(2001);
			return rsp; 
        } 
		//循环lp，将用户密码统一设置为null
		rsp.setData(lp);
		//是用了关注的时间来获取一组ids，但是前端更新lastTime是用了最后一个用户的注册时间，为省事，这里把lp中，最末的用户注册时间，更改为lastTime
		
		
		//user.setRegisterdate(lastTime);
		//2015-09-01 12:10:01
		String str="2015-09-01 12:10:01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			
			long millionSeconds = sdf.parse(str).getTime();//毫秒
			Integer length=lp.size()-1;			
			lp.get(length).setRegisterdate(new java.util.Date(millionSeconds));
//			System.out.println(new java.util.Date(millionSeconds));
			System.out.println(new java.util.Date());
		}catch(Exception e){
			
		}
		
		rsp.setMsg("获取我的粉丝列表成功");
		rsp.setRetcode(2000);
		return rsp;  //这个需要更改返回值
	}
	//帮助我的人列表
	@RequestMapping(value="/helpme")
	public @ResponseBody PeopleListRsp getHelpMeMen(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		Integer tag=commonPeopleListParam.getTag();
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();
		PeopleListRsp rsp=new PeopleListRsp();		
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("tag", tag); 
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<User> lp=new ArrayList<User>();
				
		//先到捐钱人列表进行查询，得到一组id列表，然后用这组列表到User表查询moneysource表
		List<PartHelpPojo> lpp=new ArrayList<PartHelpPojo>();
		try{
			lpp=helpService.getGodHelpMe(map);
		}catch(Exception e){
			rsp.setData(null);
			rsp.setMsg("获取爱心社列表失败");
			rsp.setRetcode(2001);
			return rsp;
		}
		if(lpp==null || lpp.size()==0 || lpp.isEmpty()){
			rsp.setData(null);
			rsp.setMsg("获取爱心社列表失败");
			rsp.setRetcode(2001);
			return rsp;
		}
		
		List<Long> ll=new ArrayList<Long>();
		
		for(int i=0;i<lpp.size();i++){
			ll.add(lpp.get(i).getUseridgoodguy());
		}
		//用这组id查询帮助我的人
		try{
			lp=peopleListService.donaterPeopleList(ll);
		}catch(Exception e){
			rsp.setData(null);
			rsp.setMsg("获取爱心社列表失败");
			rsp.setRetcode(2001);
			return rsp;
		}
		if(lp==null || lp.isEmpty()){
			rsp.setData(null);
			rsp.setMsg("获取爱心社列表失败");
			rsp.setRetcode(2001);
			return rsp;
		}
		//将lpp中的其它有用信息放入到lp中
		rsp.setData(lp);
		rsp.setMsg("获取帮助我的人列表成功");
		rsp.setRetcode(2000);
		return rsp;  //这个需要更改返回值
	}
	//我帮助的人列表
	@RequestMapping(value="/ihelp")
	public @ResponseBody PeopleListRsp getIhelpMen(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		Integer tag=commonPeopleListParam.getTag();
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();
		PeopleListRsp rsp=new PeopleListRsp();		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tag", tag); 
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<User> lp=new ArrayList<User>();
				
		//先到捐钱人列表进行查询，得到一组id列表，然后用这组列表到User表查询moneysource表
		List<PartHelpPojo> lpp=new ArrayList<PartHelpPojo>();
		try{
			lpp=helpService.getGuyIHelp(map); //loadMore在这里使用
		}catch(Exception e){
			rsp.setData(null);
			rsp.setMsg("没有数据哦");
			rsp.setRetcode(2001);
			return rsp;
		}
		if(lpp==null || lpp.isEmpty()){
			rsp.setData(null);
			rsp.setMsg("没有数据哦");
			rsp.setRetcode(2001);
			return rsp;
		}
		
		List<Long> ll=new ArrayList<Long>();
		for(int i=0;i<lpp.size();i++){
			ll.add(lpp.get(i).getUseridgoodguy());
		}
		//用这组id查询我帮助的人
		try{
			lp=peopleListService.donaterPeopleList(ll); 
		}catch(Exception e){
			rsp.setData(null);
			rsp.setMsg("没有数据哦");
			rsp.setRetcode(2001);
			return rsp;
		}
		if(lp==null || lp.isEmpty()){
			rsp.setData(null);
			rsp.setMsg("没有数据哦");
			rsp.setRetcode(2001);
			return rsp;
		}
		//将lpp中的其它有用信息放入到lp中
		//设置lp的密码域为null
		rsp.setData(lp);
		rsp.setMsg("获取我帮助的人列表成功");
		rsp.setRetcode(2000);
		return rsp;  //这个需要更改返回值
	}

}








