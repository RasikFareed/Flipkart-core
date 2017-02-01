package com.flipkart.dao;

import java.util.Iterator;
import java.util.List;

import com.flipkart.model.Customer;
import com.flipkart.model.Order;
import com.flipkart.model.Products;

public class TestOrderDao {

	public static void main(String[] args) {
		OrderDAO orderdao=new OrderDAO();
		Order order=new Order();
		
		List<Order> list = orderdao.findAll();
		Iterator<Order> i = list.iterator();
		while (i.hasNext()) {
			Order orders = (Order) i.next();
			System.out.println(orders.getOrderId()+"\t"+orders.getCustomerId().getCustomerId()+"\t"+orders.getProduct_id().getProductId()+"\t"+orders.getQuantity()+"\t"+orders.getTotalAmount()+"\t"+orders.getOrderedDate()+"\t"+orders.getStatus());
		}
	}

}
