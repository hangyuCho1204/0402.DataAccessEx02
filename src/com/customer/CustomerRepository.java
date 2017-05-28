package com.customer;

import java.util.List;

public interface CustomerRepository {
	public int insert(Customer customer);
	public List<Customer> select();
	public int update(Customer customer);
	public int delete(String pk);
	public Customer selectById(String pk);
	public List<Customer> Like(String name);
}
