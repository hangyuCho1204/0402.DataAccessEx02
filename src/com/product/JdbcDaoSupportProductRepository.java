
package com.product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("JdbcDaoSupportProductRepository")
public class JdbcDaoSupportProductRepository extends NamedParameterJdbcDaoSupport implements ProductRepository{
	
	public JdbcDaoSupportProductRepository() {}
	
	@Autowired
	public JdbcDaoSupportProductRepository(DataSource datasource){
		super.setDataSource(datasource);
	}
	
	@Override
	public int delete(String pk) {
	
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("id", pk);
		
		return getNamedParameterJdbcTemplate().update(ProductSql.PRODUCT_DELETE, params);
		
	}@Override
	public int insert(Product product) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("name", product.getName());
		params.put("price", product.getPrice());
		params.put("description", product.getDescription());// TODO Auto-generated method stub
			return getNamedParameterJdbcTemplate().update(ProductSql.PRODUCT_INSERT, params);
	}@Override
	public List<Product> select() {
		// TODO Auto-generated method stub
		return getNamedParameterJdbcTemplate().query(ProductSql.PRODUCT_SELECT_ALL, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product customer = new Product();
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setPrice(rs.getInt("price"));
				customer.setDescription(rs.getString("description"));
				
				return customer;
			}
		});
	}

	@Override
	public Product selectById(String pk) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("id", pk);
		
		return getNamedParameterJdbcTemplate().queryForObject(ProductSql.PRODUCT_SELECT_BY_PK, params, new RowMapper<Product>(){
			@Override
			public Product mapRow(ResultSet rs, int rowNum)
					throws SQLException {

				Product customer = new Product();
				
				customer.setName(rs.getString("name"));
				customer.setPrice(rs.getInt("price"));
				customer.setDescription(rs.getString("description"));
				
				return customer;
			}
		});
	}
	
	
	@Override
	public int update(Product product) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("price", product.getPrice());
		params.put("description", product.getDescription());
		params.put("id", product.getId());
		
		return getNamedParameterJdbcTemplate().update(ProductSql.PRODUCT_UPDATE, params);
	}
	
	/*public Product selectById(String pk) {
	Map<String, Object> params = new HashMap<String, Object>();
	
	params.put("id", pk);
	
	return getNamedParameterJdbcTemplate().queryForObject(ProductSql.PRODUCT_SELECT_BY_PK, params, new RowMapper<Product>(){
		@Override
		public Product mapRow(ResultSet rs, int rowNum)
				throws SQLException {

			Product customer = new Product();
			
			customer.setName(rs.getString("name"));
			customer.setPrice(rs.getInt("price"));
			customer.setDescription(rs.getString("description"));
			
			return customer;
		}
	});
}*/
	
	@Override
	public List<Product> Like(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "%"+name+"%");
		return getNamedParameterJdbcTemplate().query(ProductSql.PRODUCT_LIKE_BY_NAME, params, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				System.out.println(rowNum);
				
				Product product = new Product();
				
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				
				return product;
			}
		});
	}
	
	
	
	/*public List<Product> select() {
		// TODO Auto-generated method stub
		return getNamedParameterJdbcTemplate().query(ProductSql.PRODUCT_SELECT_ALL, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product customer = new Product();
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setPrice(rs.getInt("price"));
				customer.setDescription(rs.getString("description"));
				
				return customer;
			}
		});
	}*/
}
