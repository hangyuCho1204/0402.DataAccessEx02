package com.product;

import java.util.List;

public interface ProductRepository {
	public int insert(Product product);
	public List<Product> select();
	public int update(Product product);
	public int delete(String pk);
	public Product selectById(String pk);
	public List<Product> Like(String name);
}
