package com.infosys.project.product.dto;

import com.infosys.project.product.entity.Product;

public class ProductDTO {
	
	Integer prodId;
	String brand;
	String category;
	String description;
	String image;
	String productName;
	String subCategory;
	Float price;
	Integer rating;
	Integer sellerId;
	Integer stock;

	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public static ProductDTO valueOf(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProdId(product.getProdId());
		productDTO.setBrand(product.getBrand());
		productDTO.setCategory(product.getCategory());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		productDTO.setPrice(product.getPrice());
		productDTO.setProductName(product.getProductName());
		productDTO.setRating(product.getRating());
		productDTO.setSellerId(product.getSellerId());
		productDTO.setStock(product.getStock());
		productDTO.setSubCategory(product.getSubCategory());
		return productDTO;
	}
	
	public Product createEntity() {
		Product product = new Product();
		product.setProdId(this.getProdId());
		product.setBrand(this.getBrand());
		product.setCategory(this.getCategory());
		product.setDescription(this.getDescription());
		product.setImage(this.getImage());
		product.setPrice(this.getPrice());
		product.setProductName(this.getProductName());
		product.setRating(this.getRating());
		product.setSellerId(this.getSellerId());
		product.setStock(this.getStock());
		product.setSubCategory(this.getSubCategory());
		return product;
	}
	
}
