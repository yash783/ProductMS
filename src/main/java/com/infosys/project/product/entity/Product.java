package com.infosys.project.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prodid")
	Integer prodId;
	
	@Column(nullable=false,length=255)
	String brand;
	
	@Column(nullable=false,length=255)
	String category;
	
	@Column(nullable=false,length=255)
	String description;
	
	@Column(nullable=false,length=255)
	String image;
	
	@Column(name="productname",nullable=false,length=255)
	String productName;
	
	@Column(name="subcategory",length=255)
	String subCategory;
	
	@Column(nullable=false,precision=10,scale=2)
	Float price;
	
	@Column(nullable=true)
	Integer rating;
	
	@Column(name="sellerid",nullable=false)
	Integer sellerId;
	
	@Column(nullable=false)
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

	public Product() {
		super();
	}

	
}
