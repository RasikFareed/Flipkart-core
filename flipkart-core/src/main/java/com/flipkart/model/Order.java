package com.flipkart.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Order {

	private int orderId;
	private Customer customerId;
	private Products product_id;
	private int quantity;
	private int totalAmount;
	private LocalDate orderedDate;
	private String status;
}
