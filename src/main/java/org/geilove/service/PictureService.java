package org.geilove.service;

import java.util.List;
import java.util.Map;

import org.geilove.pojo.Picture;
import org.geilove.sqlpojo.PicturePojo;

public interface PictureService {
	
	public List<PicturePojo> getSomePictures(Map<String,Object> map); 
	
	public int insertRecord(Picture record);
	
}
