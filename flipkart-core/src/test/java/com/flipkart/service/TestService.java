package com.flipkart.service;

import com.flikart.exception.ServiceException;
import com.flipkart.model.Products;

public class TestService {

	public static void main(String[] args) throws ServiceException {
		// TODO Auto-generated method stub
		ProductService p=new ProductService();
		Products pw=new Products();
		pw.setProductName("");
		p.save(pw);
		

	}

}
