package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Customer;


public class TestCustomerDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Customer customer=new Customer();
		CustomerDAO customerDao=new CustomerDAO();
		customer.setCustomerId(1);
		customer.setCustomerName("rasik");
		customer.setEmailId("rasik@gmail.com");
		customer.setPassword("12345");
		customer.setAddress("Coimbatore");
		
		customerDao.save(customer);
		
		List<Customer> list = customerDao.findAll();
		for (Customer i : list) {
			System.out.println(i);
		}
		
	}

}
