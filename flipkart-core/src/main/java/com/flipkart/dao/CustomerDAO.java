package com.flipkart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.flipkart.model.Customer;
import com.flipkart.util.ConnectionUtil;

public class CustomerDAO implements DAO<Customer> {
	private JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Customer c) {
		String sql = "INSERT INTO CUSTOMERS(NAME,EMAIL_ID,PASSWORD,ADDRESS)VALUES(?,?,?,?)";
		Object[] params = { c.getCustomerName(), c.getEmailId(), c.getPassword(), c.getAddress() };
		int rows = jdbctemplate.update(sql, params);
		System.out.println(rows);
	}

	public void update(Customer c) {
		String sql = "UPDATE CUSTOMERS SET NAME=?,EMAIL_ID=?,PASSWORD=?,ADDRESS=?,ACTIVE=? WHERE ID=?";
		Object[] params = { c.getCustomerName(), c.getEmailId(), c.getPassword(), c.getAddress(), c.isActive(),
				c.getCustomerId() };
		int rows = jdbctemplate.update(sql, params);
		System.out.println(rows);

	}

	public void delete(int id) {
		String sql = "DELETE FROM CUSTOMERS WHERE ID=?";
		Object params = id;
		int rows = jdbctemplate.update(sql, params);
		System.out.println(rows);

	}

	@Override
	public List<Customer> findAll() {
		String sql = "SELECT ID, NAME,EMAIL_ID,PASSWORD,ADDRESS,ACTIVE,CREATED_DATE FROM CUSTOMERS";
		return jdbctemplate.query(sql, (rs, rowNo) -> convert(rs));

	}

	@Override
	public Customer findOne(int id) {
		String sql = "SELECT NAME,EMAIL_ID,PASSWORD,ADDRESS,ACTIVE,CREATED_DATE FROM CUSTOMERS WHERE ID = ?";
		Object[] params = { id };
		return jdbctemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));

	}

	private Customer convert(ResultSet rs) throws SQLException {
		Customer c = new Customer();
		c.setCustomerId(rs.getInt("ID"));
		c.setCustomerName(rs.getString("NAME"));
		c.setEmailId(rs.getString("EMAIL_ID"));
		c.setPassword(rs.getString("PASSWORD"));
		c.setAddress(rs.getString("ADDRESS"));
		c.setActive(rs.getBoolean("ACTIVE"));
		c.setCreatedDate(rs.getDate("CREATED_DATE").toLocalDate());
		return c;
	}

}
