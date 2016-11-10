package org.geilove.service;

import java.util.List;
import java.util.Map;

import org.geilove.pojo.Confirm;

public interface ConfirmService {
      public List<Confirm> getConfirmLists(Map<String,Object> map);
      
      public Integer getPeopleConfirms(Map<String,Object> map);
      
      public Integer addRecordSelective(Confirm confirm);
      
}
