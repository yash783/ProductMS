package com.infosys.project.product.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subscribedproduct")
public class SubscribedProduct {
	
	@Column(nullable=false)
	Integer quantity;
	
	@EmbeddedId
	private MyCompositeKey myCompositeKey;
	
	public MyCompositeKey getMyKey() {
		return myCompositeKey;
	}
	public void setMyKey(MyCompositeKey myCompositeKey) {
		this.myCompositeKey=myCompositeKey;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public SubscribedProduct() {
		super();
	}
	
}
