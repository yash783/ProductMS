package com.infosys.project.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.project.product.dto.ProductDTO;
import com.infosys.project.product.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;
	
	@Autowired
	Environment env;
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getAllProducts() {
		logger.info("Fetching all products");
		return productService.getAllProducts();
	}
	
	@GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getSpecificProducts(@PathVariable Integer productId) {
		logger.info("Fetching details of product {}", productId);
		return productService.getSpecificProduct(productId);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getProductsByCategoryAndProductName(@RequestParam("category") String category, @RequestParam("productName") String productName) {
		logger.info("Fetching details of category {} and productName {}",category,productName);
		return productService.getProductsCategoryAndProductName(category, productName);
	}
	
	@GetMapping(value ="/findbysellerid", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getProductsByCategoryAndProductName(@RequestParam("sellerid") Integer sellerId) {
		logger.info("Fetching details of products for sellerId", sellerId);
		return productService.getBySellerId(sellerId);
	}
	
	@PostMapping(value = "/add",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerBuyer(@RequestBody ProductDTO productDTO) {
		ResponseEntity<String> response = null;
		try{
			logger.info("Creation request for product");
			Integer productId = productService.registerProduct(productDTO);
			logger.info("Creation successfull for productid {}", productId);
			String successMessage = env.getProperty("UserInterface.REGISTRATION_SUCCESS") + "for productid " + productId;
			response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		} catch(Exception e) {
			String errorMessage = env.getProperty(e.getMessage());
			logger.error(errorMessage);
			response = new ResponseEntity<String>(env.getProperty(errorMessage), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
