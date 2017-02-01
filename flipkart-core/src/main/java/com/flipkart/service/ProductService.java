package com.flipkart.service;

import com.flikart.exception.ServiceException;
import com.flikart.exception.ValidatorException;
import com.flipkart.dao.ProductsDAO;
import com.flipkart.model.Products;
import com.flipkart.validator.ProductValidator;

public class ProductService {
	ProductValidator pvalidator=new ProductValidator();
	ProductsDAO productdao=new ProductsDAO();
	public void save(Products p) throws ServiceException{
	
		try {
			pvalidator.saveValidator(p);
			productdao.save(p);
		} catch (ValidatorException e) {			
			throw new ServiceException("Cannot Insert",e);
		}
		
	
	}
}

