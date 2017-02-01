package com.flipkart.model;

import java.time.LocalDate;


import lombok.Data;

@Data
public class Products {

	private int productId;
	private String productName;
	private int productPrice;
	private boolean active;
	private LocalDate releasedDate;
}
