package org.geilove.service;

import org.geilove.pojo.Cash;

public interface ChangeManToBeHelpedService {
       public Integer changeSomeUserProfile(byte userType);  //4代表被帮助用户
       
       public Integer insertRecordIntoCashTable(Cash cash); //需要操作有关Cash表的插入操作
       
}
