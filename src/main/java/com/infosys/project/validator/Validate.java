package com.infosys.project.validator;

public class Validate {
	
	public static Boolean validateName(String name){
		String regex = "^[\\p{L} .'-]+$";
		if(name.matches(regex) && name.length() <= 100) {
			return true;
		}
		return false;
	}
	
	public static Boolean validateDescription(String description){
		if(description.length() <= 500) {
			return true;
		}
		return false;
	}
	
	public static Boolean validatePrice(Float price) {
		if(price >= 200.0) {
			return true;
		}
		return false;
	}
	
	public static Boolean validateStock(Integer stock) {
		if(stock >= 10) {
			return true;
		}
		return false;
	}

}
