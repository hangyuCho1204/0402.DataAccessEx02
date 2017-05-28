package com.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	@Qualifier("JdbcDaoSupportCustomerRepository")
	private CustomerRepository CustomerRepository;
	
	public int saveCustomer(Customer customer) {
		
		
		return CustomerRepository.insert(customer);
	}
	
	public int modifiyCustomer(Customer customer) {
		
		
		return CustomerRepository.update(customer);
	}
	
	public int removeCustomer(String pk) {
		
		
		return CustomerRepository.delete(pk);
	}

	public List<Customer> getCustomers() {
		
		List<Customer> customers =CustomerRepository.select();
		
		return customers;
	}
	
	public Customer getCustomersPk(String pk) {
		
		Customer customer = CustomerRepository.selectById(pk);
		
		return customer;
	}
	
	public List<Customer> like(String name) {
		
		List<Customer> customer = CustomerRepository.Like(name);
		
		return customer;
	}
}
