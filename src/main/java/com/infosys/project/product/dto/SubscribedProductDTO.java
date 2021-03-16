package com.infosys.project.product.dto;

import com.infosys.project.product.entity.SubscribedProduct;

public class SubscribedProductDTO {
	
	Integer prodId;
	
	Integer buyerId;
	
	Integer quantity;

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public SubscribedProductDTO() {
		super();
	}
	
	public static SubscribedProductDTO valueOf(SubscribedProduct subscribedProduct) {
		SubscribedProductDTO subscribedProductDTO = new SubscribedProductDTO();
		subscribedProductDTO.setProdId(subscribedProduct.getMyKey().getProdId());
		subscribedProductDTO.setBuyerId(subscribedProduct.getMyKey().getBuyerId());
		subscribedProductDTO.setQuantity(subscribedProduct.getQuantity());
		return subscribedProductDTO;
	}
}
