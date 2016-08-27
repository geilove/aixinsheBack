package org.geilove.vo;

import org.springframework.web.multipart.MultipartFile;

public class UploadDemoVo {
	   private MultipartFile imgFile;
//	   private String ps;
//	    public String getPs() {
//		return ps;
//	}
//
//	public void setPs(String ps) {
//		this.ps = ps;
//	}

		public MultipartFile getImgFile() {
	        return imgFile;
	    }
	 
	    public void setImgFile(MultipartFile imgFile) {
	        this.imgFile = imgFile;
	    }
	 
	    @Override
	    public String toString() {
	        return "UploadDemoVo [imgFile=" + imgFile + "]";
	    }
	     
	    public boolean validateFile() {
	        
	        return true;
	    }
}
