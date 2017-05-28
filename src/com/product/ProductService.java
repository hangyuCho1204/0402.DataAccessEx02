package com.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	@Qualifier("JdbcDaoSupportProductRepository")
	private ProductRepository productRepository;
	
	public int saveProduct(Product product) {
		
		
		return productRepository.insert(product);
	}
	
	public int modifiyProduct(Product product) {
		
		
		return productRepository.update(product);
	}
	
	public int removeProduct(String pk) {
		
		
		return productRepository.delete(pk);
	}

	public List<Product> getProducts() {
		
		List<Product> products =productRepository.select();
		
		return products;
	}
	
	public Product getProductsPk(String pk) {
		
		Product product = productRepository.selectById(pk);
		
		return product;
	}
	
	public List<Product> productLike(String name){
		System.out.println("service name : " + name);
		return productRepository.Like(name);
	}
}
