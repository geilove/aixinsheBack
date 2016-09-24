package org.geilove.requestParam;

public class CashParam {
	
	private String proof;
	
	private Integer cashid; //应该是Long类型，受限于tweet表
	
	public String getProof() {
		return proof;
	}
	public void setProof(String proof) {
		this.proof = proof;
	}
	public Integer getCashid() {
		return cashid;
	}
	public void setCashid(Integer cashid) {
		this.cashid = cashid;
	}
	
}
