package org.geilove.vo;

import org.geilove.pojo.Item;

public class ItemFull {
		private Item item;
		
	    private String circleidstartPhoto; //项目创建者的头像地址
	    
	    private String circleidstartNickName;//项目创建者的昵称
	    
	    private String circleidsuperviseNickName; //项目监督团队的昵称
    
	    private String useridprincipalNickName; //项目具体执行人的昵称

		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}

		public String getCircleidstartPhoto() {
			return circleidstartPhoto;
		}

		public void setCircleidstartPhoto(String circleidstartPhoto) {
			this.circleidstartPhoto = circleidstartPhoto;
		}

		public String getCircleidstartNickName() {
			return circleidstartNickName;
		}

		public void setCircleidstartNickName(String circleidstartNickName) {
			this.circleidstartNickName = circleidstartNickName;
		}

		public String getCircleidsuperviseNickName() {
			return circleidsuperviseNickName;
		}

		public void setCircleidsuperviseNickName(String circleidsuperviseNickName) {
			this.circleidsuperviseNickName = circleidsuperviseNickName;
		}

		public String getUseridprincipalNickName() {
			return useridprincipalNickName;
		}

		public void setUseridprincipalNickName(String useridprincipalNickName) {
			this.useridprincipalNickName = useridprincipalNickName;
		}
	    
}
