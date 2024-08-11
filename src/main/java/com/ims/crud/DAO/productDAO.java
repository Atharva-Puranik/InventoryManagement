package com.ims.crud.DAO;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.query.*;

import com.ims.crud.configs.dbConnection;
import com.ims.crud.models.Product;

public class productDAO {

	static Session session = dbConnection.initDatabase();

	public static void insertProduct(Product product) {
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();

		session.close();
	}

	public static List<Product> fetchAllProducts() {
		session.beginTransaction();
		String SELECT_ALL_PRODUCTS = "FROM Product";
		List<Product> result =  session.createQuery(SELECT_ALL_PRODUCTS,Product.class).list();
		session.close();
		return result;
	}

	public static Product updateProductRecord(int updateId) {
		Product p = new Product();
		return p;
	}

	public static void deleteProductRecord(int deleteId) {

	}

}
