package com.flipkart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.flipkart.model.Products;
import com.flipkart.util.ConnectionUtil;

public class ProductsDAO implements DAO<Products> {

	private JdbcTemplate jdbctemplate= ConnectionUtil.getJdbcTemplate();
	@Override
	public void save(Products p) {
		String sql="INSERT INTO PRODUCTS(NAME,PRICE,RELEASED_DATE)VALUES(?,?,?)";
		Object[] params={p.getProductName(),p.getProductPrice(),p.getReleasedDate()};
		int rows=jdbctemplate.update(sql, params);
		System.out.println(rows);
	}

	@Override
	public void update(Products p) {
		String sql="UPDATE PRODUCTS SET NAME=?,PRICE=?,ACTIVE=?,RELEASED_DATE=? WHERE ID=?";
		Object[] params={p.getProductName(),p.getProductPrice(),p.isActive(),p.getReleasedDate(),p.getProductId()};
		int rows=jdbctemplate.update(sql, params);
		System.out.println(rows);

	}

	@Override
	public void delete(int id) {
		String sql="DELETE FROM PRODUCTS WHERE ID=?";
		Object params=id;
		int rows=jdbctemplate.update(sql, params);
		System.out.println(rows);
	}

	@Override
	public List<Products> findAll() {
		String sql ="SELECT ID, NAME,PRICE, RELEASED_DATE,ACTIVE FROM PRODUCTS";
		return jdbctemplate.query(sql, (rs,rowNo) ->convert(rs));
		
	}

	@Override
	public Products findOne(int id) {
		String sql ="SELECT ID, NAME,PRICE, RELEASED_DATE,ACTIVE FROM PRODUCTS WHERE ID = ?";
		Object[] params = {id};
		return jdbctemplate.queryForObject(sql,params, (rs,rowNo) ->convert(rs));
		
	}
	
	private Products convert(ResultSet rs) throws SQLException {
		Products p = new Products();

		p.setProductId(rs.getInt("ID"));
		p.setProductName(rs.getString("NAME"));
		p.setProductPrice(rs.getInt("Price"));
		p.setActive(rs.getBoolean("ACTIVE"));
		p.setReleasedDate(rs.getDate("RELEASED_DATE").toLocalDate());
		return p;
	}



}
	
