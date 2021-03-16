package com.infosys.project.validator;

import com.infosys.project.product.dto.ProductDTO;

public class Validator {
	
	public static void validateProduct(ProductDTO productDTO) throws Exception{
		if(!Validate.validateName(productDTO.getProductName())) {
			throw new Exception("Validator.INVALID_NAME");
		}
		if(!Validate.validateDescription(productDTO.getDescription())) {
			throw new Exception("Validator.INVALID_DDESCRIPTION");
		}
		if(!Validate.validatePrice(productDTO.getPrice())) {
			throw new Exception("Validator.INVALID_PRICE");
		}
		if(!Validate.validateStock(productDTO.getStock())) {
			throw new Exception("Validator.INVALID_STOCK");
		}
	}

}
