package org.geilove.sqlpojo;

import java.util.Date;

public class PartHelpPojo {
	
	private Long useridbehelped;

    private Long useridgoodguy;

    private Integer moneynum;

    private Date helptime;
    
	public Long getUseridbehelped() {
		return useridbehelped;
	}

	public void setUseridbehelped(Long useridbehelped) {
		this.useridbehelped = useridbehelped;
	}

	public Long getUseridgoodguy() {
		return useridgoodguy;
	}

	public void setUseridgoodguy(Long useridgoodguy) {
		this.useridgoodguy = useridgoodguy;
	}

	public Integer getMoneynum() {
		return moneynum;
	}

	public void setMoneynum(Integer moneynum) {
		this.moneynum = moneynum;
	}

	public Date getHelptime() {
		return helptime;
	}

	public void setHelptime(Date helptime) {
		this.helptime = helptime;
	}
}
