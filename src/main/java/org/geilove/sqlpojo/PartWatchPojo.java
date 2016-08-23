package org.geilove.sqlpojo;

import java.util.Date;

//这个是从DoubleFans表取出的需要显示的数据
public class PartWatchPojo {
	
    private Long useridfollowe; //关注者id

    private Long useridbefocus; //被关注者id

    private Date paydate;   //关注的时间

    private Byte paytag;   //关注标识，1主动关注，2被动关注

    private Byte doublefans;  //是否相互关注

	public Long getUseridfollowe() {
		return useridfollowe;
	}

	public void setUseridfollowe(Long useridfollowe) {
		this.useridfollowe = useridfollowe;
	}

	public Long getUseridbefocus() {
		return useridbefocus;
	}

	public void setUseridbefocus(Long useridbefocus) {
		this.useridbefocus = useridbefocus;
	}

	public Date getPaydate() {
		return paydate;
	}

	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}

	public Byte getPaytag() {
		return paytag;
	}

	public void setPaytag(Byte paytag) {
		this.paytag = paytag;
	}

	public Byte getDoublefans() {
		return doublefans;
	}

	public void setDoublefans(Byte doublefans) {
		this.doublefans = doublefans;
	}
    
}
