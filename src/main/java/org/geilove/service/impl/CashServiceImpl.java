package org.geilove.service.impl;

import javax.annotation.Resource;

import org.geilove.dao.CashMapper;
import org.geilove.pojo.Cash;
import org.geilove.service.CashService;
import org.springframework.stereotype.Service;

@Service("cashervice")
public class CashServiceImpl implements CashService {
	@Resource CashMapper cashMapper;
	
	public  Cash getCashRecord(Long cashid){
		 Cash cash=new Cash();
		 cash= cashMapper.selectByPrimaryKey(cashid);
		 return cash;
	}
	
	public int cashInsert(Cash cash){
		int tag=cashMapper.insert(cash);
		return tag;
	}
}
