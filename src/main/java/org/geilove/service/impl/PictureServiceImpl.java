package org.geilove.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.geilove.service.PictureService;
import org.geilove.sqlpojo.PicturePojo;
import org.springframework.stereotype.Service;
import org.geilove.dao.PictureMapper;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {
 
	@Resource
	PictureMapper  pictureMapper;
	
	public List<PicturePojo> getSomePictures(Map<String,Object> map){
		
		List<PicturePojo> picList=pictureMapper.selectByMap(map);
		return picList;
	}
}
