package com.flipkart.dao;

import java.time.LocalDate;
import java.util.List;

import com.flipkart.model.Products;

public class TestProductsDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Products products = new Products();

		/*
		 * products.setProductName("Laptop"); products.setProductPrice(50000);
		 * products.setReleasedDate(LocalDate.now());
		 */
		products.setProductId(1);
		// products.isActive();
		ProductsDAO productsDao = new ProductsDAO();
		// productsDao.save(products);
		// productsDao.update(products);
		List<Products> list = productsDao.findAll();
		for (Products i : list) {
			System.out.println(i);
		}

		// System.out.println(productsDao.findOne(1));
	}

}
