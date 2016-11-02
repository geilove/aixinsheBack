package org.geilove.service;

import org.geilove.pojo.Cash;

public interface CashService {
     public  Cash  getCashRecord(Long cashid);
     public int cashInsert(Cash cash);
}
