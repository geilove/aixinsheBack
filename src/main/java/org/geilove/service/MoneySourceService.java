package org.geilove.service;
import java.util.List;
import java.util.Map;

import  org.geilove.pojo.MoneySource;
import org.geilove.sqlpojo.PartHelpPojo;
public interface MoneySourceService {
        public   List<PartHelpPojo> getIhelpMen( Map<String,Object> map); //获取我帮助的人
        public   List<PartHelpPojo> getHelpMeMen( Map<String,Object> map);//获取帮助我的人       
}
