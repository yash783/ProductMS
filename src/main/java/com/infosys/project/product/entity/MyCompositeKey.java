package com.infosys.project.product.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class MyCompositeKey implements Serializable{
	
	@Column(name="buyerId", nullable=false)
	Integer buyerId;
	@Column(name="prodId", nullable=false)
	Integer prodId;
	
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId=buyerId;
	}
	
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId=prodId;
	}
}