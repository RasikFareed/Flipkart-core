package com.flipkart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.flipkart.model.Customer;
import com.flipkart.model.Order;
import com.flipkart.model.Products;
import com.flipkart.util.ConnectionUtil;

public class OrderDAO {
	
	private JdbcTemplate jdbctemplate=ConnectionUtil.getJdbcTemplate();
	

	public List<Order> findAll() {
		String sql = "SELECT ID, CUSTOMER_ID,PRODUCT_ID,QTY,TOTAL_AMOUNT,ORDERED_DATE,STATUS FROM ORDERS";
		return jdbctemplate.query(sql, (rs, rowNo) -> convert(rs));

	}

	
	public Order findOne(int id) {
		String sql = "SELECT ID, NAME,PRICE, RELEASED_DATE,ACTIVE FROM PRODUCTS WHERE ID = ?";
		Object[] params = { id };
		return jdbctemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));

	}

	private Order convert(ResultSet rs) throws SQLException {
		Order o = new Order();
		o.setOrderId(rs.getInt("ID"));
		
		Customer customer=new Customer();
		customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
		o.setCustomerId(customer);
		
		Products product=new Products();
		product.setProductId(rs.getInt("PRODUCT_ID"));
		o.setProduct_id(product);
		
		o.setQuantity(rs.getInt("QTY"));
		o.setTotalAmount(rs.getInt("TOTAL_AMOUNT"));
		o.setOrderedDate(rs.getDate("ORDERED_DATE").toLocalDate());
		o.setStatus(rs.getString("STATUS"));
	
		return o;
	}
}
