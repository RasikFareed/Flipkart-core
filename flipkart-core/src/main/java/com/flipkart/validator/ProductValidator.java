package com.flipkart.validator;

import com.flikart.exception.ValidatorException;
import com.flipkart.dao.ProductsDAO;
import com.flipkart.model.Products;
import com.flipkart.util.Validator;


public class ProductValidator {
	Validator validator=new Validator();
	
	public void saveValidator(Products product)throws ValidatorException{
		validator.isInvalid(product.getProductName(), "name");
		ProductsDAO productdao=new ProductsDAO();
		productdao.save(product);
		
		
	}
}
