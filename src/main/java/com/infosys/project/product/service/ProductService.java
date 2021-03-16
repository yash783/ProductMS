package com.infosys.project.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infosys.project.product.dto.ProductDTO;
import com.infosys.project.product.entity.Product;
import com.infosys.project.product.repository.ProductRepository;
import com.infosys.project.validator.Validator;

@Service
public class ProductService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	Environment env;

	public List<ProductDTO> getAllProducts() {

		List<Product> products = productRepo.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();

		for (Product product : products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}

		logger.info("Product details : {}", productDTOs);
		return productDTOs;
	}
	
	public List<ProductDTO> getBySellerId(Integer sellerId) {
		logger.info("Fetching product details of seller : {}", sellerId);
		List<ProductDTO> productDTOList = new ArrayList<>();
		List<Product> productList = productRepo.getBySellerId(sellerId);
		for (Product product : productList) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOList.add(productDTO);
		}
		return productDTOList;
	}
	
	public ProductDTO getSpecificProduct(Integer productId) {
		logger.info("Product details : {}", productId);
		ProductDTO productDTO = null;
		Optional<Product> optProduct = productRepo.findById(productId);
		if (optProduct.isPresent()) {
			Product product = optProduct.get();
			productDTO = ProductDTO.valueOf(product);
		}

		return productDTO;
	}
	
	public List<ProductDTO> getProductsCategoryAndProductName(String category,String productName) {

		List<Product> products = productRepo.getByCategoryAndProductName(category, productName);
		List<ProductDTO> productDTOs = new ArrayList<>();

		for (Product product : products) {
			ProductDTO productDTO = ProductDTO.valueOf(product);
			productDTOs.add(productDTO);
		}

		logger.info("Product details by category and productName : {}", productDTOs);
		return productDTOs;
	}
	
	public Integer registerProduct(ProductDTO productDTO) throws Exception {
		Integer productId = null;
		try {
			logger.info("Creation request for product");
			Validator.validateProduct(productDTO);
			Product product = productDTO.createEntity();
			productRepo.save(product);
			productId = product.getProdId();
			logger.info("Created product with id {}", productId);
		} catch (Exception e) {
			String errorMessage = env.getProperty(e.getMessage());
			logger.error(errorMessage);
			throw new Exception(errorMessage);
		}
		return productId;
	}
}
