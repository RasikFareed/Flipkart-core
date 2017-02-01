package com.flipkart.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Customer {
	
	private int customerId;
	private String customerName;
	private String emailId;
	private String password;
	private String address;
	private boolean active;
	private LocalDate createdDate;

}
