package DAO;

import org.hibernate.Session;

import configurations.dbConnection;
import models.Product;

public class productDAO {

	static Session session = dbConnection.initDatabase();

	public static void insertProduct(Product product) {
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();

		session.close();

	}

	public static void display() {

	}

	public static void updateProductRecord(int updateId) {

	}

	public static void deleteProductRecord(int deleteId) {

	}

}
