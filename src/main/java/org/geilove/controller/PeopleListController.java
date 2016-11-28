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
import org.geilove.vo.IwatchPeopleVo;
import org.geilove.vo.PeopleListVo;
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
		Date watchsDate=new Date();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("loadMoreTag", loadMoreTag);
		map.put("userID", userid); //xml中是userid必须对应
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("lastTime", lastTime); // 这里的lastTime指的就是关注的时间
		List<User> lp=new ArrayList<User>();
		//先到关注表查询关注关心，获取到一组id，用这组id获取关注人列表已有现成代码	
		List<PeopleListVo> listPVo=new ArrayList<PeopleListVo>(); //包含userid和时间戳的数据
		List<Long> ll=new ArrayList<Long>();
		try{
			//我所关注人的ids,根据关注的时间，是在这里进行了refresh和loadMore的控制,筛选出一组合适的ids
			listPVo=mainService.getWatcherIdsListMen(map); 
			
			if(listPVo==null ||listPVo.size()==0 ||listPVo.isEmpty()){
				rsp.setData(null);
				rsp.setMsg("没有更多数据了");
				rsp.setRetcode(2001);
				return rsp;
			}
			int i=0;
			for( ;i<listPVo.size();i++){
				ll.add(listPVo.get(i).getUseridbefocus());
			}
			watchsDate=listPVo.get(i-1).getPaydate(); //这个paydate要跟pojo对应，这意味着查看我捐钱列表需要个新的vo
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
			//System.out.println(e);			
			rsp.setData(lp);
			rsp.setMsg("没有更多数据了");
			rsp.setRetcode(2001);
			return rsp; 
		}
		//循环lp，将用户密码统一设置为null
		rsp.setData(lp);
	    lp.get(listPVo.size()-1).setRegisterdate(watchsDate); //最后一项数据的注册时间更改为关注时间，妥协的做法
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
		Date watchsDate=new Date();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("loadMoreTag", loadMoreTag);
		map.put("userid", userid); //xml中是userid必须对应
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("lastTime", lastTime);
		List<User> lp=new ArrayList<User>();
		//先到关注表查询关注关心，获取到一组id，用这组id获取关注人列表已有现成代码	
		
		List<Long> ll=new ArrayList<Long>();
		List<IwatchPeopleVo> lpvo=new ArrayList<IwatchPeopleVo>();
		try{
			lpvo=mainService.getMyFansids(map); //我所关注人的ids		
			if(lpvo==null ||lpvo.isEmpty()){
				rsp.setData(null);
				rsp.setMsg("没有更多数据了");
				rsp.setRetcode(2001);
				return rsp;
			}
			//循环lpvo将数据放入ll中
			int i=0;
			for( ;i<lpvo.size();i++){
				ll.add(lpvo.get(i).getUseridfollowe());
			}
			watchsDate=lpvo.get(i-1).getPaydate(); //这个paydate要跟pojo对应，这意味着查看我捐钱列表需要个新的vo
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
        int i=0;
		for( ;i<lpvo.size();i++){
			ll.add(lpvo.get(i).getUseridfollowe());
		}
		
		rsp.setData(lp);
		//是用了关注的时间来获取一组ids，但是前端更新lastTime是用了最后一个用户的注册时间，为省事，这里把lp中，最末的用户注册时间，更改为lastTime
		//将lpvo中的最后一项数据的时间取出来，放入到lp中
		 lp.get(lpvo.size()-1).setRegisterdate(watchsDate); //最后一项数据的注册时间更改为关注时间，妥协的做法		
		 rsp.setMsg("获取我的粉丝列表成功");
		 rsp.setRetcode(2000);
		 return rsp;  //这个需要更改返回值
	}
	//帮助我的人列表
	@RequestMapping(value="/helpme")
	public @ResponseBody PeopleListRsp getHelpMeMen(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		PeopleListRsp rsp=new PeopleListRsp();	
		String token=commonPeopleListParam.getToken();			
		String useridStr=token.substring(32);		
		Long userid=Long.valueOf(useridStr).longValue();
		
		Integer loadMoreTag =commonPeopleListParam.getLoadMoreTag();
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();
		String lastTime=commonPeopleListParam.getLastTime();
			
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("userid", userid); 
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("lastTime", lastTime);
		map.put("loadMoreTag", loadMoreTag); //1代表刷新  2代表加载更多
		List<User> lp=new ArrayList<User>();
				
		//先到捐钱人列表进行查询，得到一组id列表，然后用这组列表到User表查询moneysource表
		List<PartHelpPojo> lpp=new ArrayList<PartHelpPojo>();
		try{
			lpp=helpService.getGodHelpMe(map);
		}catch(Exception e){
			rsp.setData(null);
			rsp.setMsg("还没有人帮助我");
			rsp.setRetcode(2001);
			return rsp;
		}
		if(lpp==null || lpp.size()==0 || lpp.isEmpty()){
			rsp.setData(null);
			rsp.setMsg("还没有人帮助我");
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
			rsp.setMsg("还没有人帮助我");
			rsp.setRetcode(2001);
			return rsp;
		}
		if(lp==null || lp.isEmpty()){
			rsp.setData(null);
			rsp.setMsg("还没有人帮助我");
			rsp.setRetcode(2001);
			return rsp;
		}
		//将lpp中的其它有用信息放入到lp中
		for(int i=0;i<lpp.size();i++){
			lp.get(i).setTobeusetwo(lpp.get(i).getMoneynum()); //具体的钱数
			lp.get(i).setRegisterdate(lpp.get(i).getHelptime()); //帮助的时间
		}
		rsp.setData(lp);
		rsp.setMsg("获取帮助我的人列表成功");
		rsp.setRetcode(2000);
		return rsp;  //这个需要更改返回值
	}
	//我帮助的人列表,这个可以用
	@RequestMapping(value="/ihelp")
	public @ResponseBody PeopleListRsp getIhelpMen(@RequestBody CommonPeopleListParam commonPeopleListParam ){
		PeopleListRsp rsp=new PeopleListRsp();	
		String token=commonPeopleListParam.getToken();			
		String useridStr=token.substring(32);		
		Long userid=Long.valueOf(useridStr).longValue();
		
		Integer loadMoreTag =commonPeopleListParam.getLoadMoreTag();
		Integer page=commonPeopleListParam.getPage();
		Integer pageSize=commonPeopleListParam.getPageSize();
		String lastTime=commonPeopleListParam.getLastTime();
			
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("userid", userid); 
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("lastTime", lastTime);
		map.put("loadMoreTag", loadMoreTag); //1代表刷新  2代表加载更多
		List<User> lp=new ArrayList<User>();
				
		//先到捐钱人列表进行查询，得到一组id列表，然后用这组列表到User表查询moneysource表
		List<PartHelpPojo> lpp=new ArrayList<PartHelpPojo>();
		try{
			lpp=helpService.getGuyIHelp(map); //loadMore在这里使用
		}catch(Exception e){
			System.out.println(e);
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
			ll.add(lpp.get(i).getUseridbehelped());
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
		//将lpp中的其它有用信息放入到lp中,帮助的时间放入User的registerdate中，
		for(int i=0;i<lpp.size();i++){
			lp.get(i).setTobeusetwo(lpp.get(i).getMoneynum()); //具体的钱数
			lp.get(i).setRegisterdate(lpp.get(i).getHelptime()); //帮助的时间
		}
		//设置lp的密码域为null
		rsp.setData(lp);
		rsp.setMsg("获取我帮助的人列表成功");
		rsp.setRetcode(2000);
		return rsp;  //这个需要更改返回值
	}

}








