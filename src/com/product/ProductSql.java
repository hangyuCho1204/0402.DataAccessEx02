package com.product;

public class ProductSql {
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Product
	
	public static final String PRODUCT_INSERT= " insert into product( id, name, price, description ) values( 'id'||product_id.nextval, :name, :price, :description ) ";
	public static final String PRODUCT_DELETE = " delete product  where id  = :id ";
	public static final String PRODUCT_UPDATE = " update product set price = :price, description = :description where id = :id ";
	public static final String PRODUCT_SELECT_ALL= " select  * from product ";
	public static final String PRODUCT_SELECT_BY_PK = " select * from product where id = :id ";
	public static final String PRODUCT_LIKE_BY_NAME = " select * from product where name like :name ";
	
}
