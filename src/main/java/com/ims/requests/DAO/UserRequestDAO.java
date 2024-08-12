package com.ims.requests.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ims.crud.configs.dbConnection;
import com.ims.requests.models.Requests;

public class UserRequestDAO {
	static Session session = dbConnection.initDatabase();
	public static int getProductId(String productName) {
		session.beginTransaction();
		String hql = "SELECT p.productId FROM Product p WHERE p.productName = :productName";
	    Query<Integer> query = session.createQuery(hql, Integer.class);
	    query.setParameter("productName", productName);
	    List<Integer> results = query.list();
	    session.getTransaction().commit();;
	    if (!results.isEmpty()) {
            return results.get(0);
        }
		return 0;
		
	}
	public static void addRequest(Requests userRequest) {
		session.beginTransaction();
		session.save(userRequest);
		session.getTransaction().commit();
	}
}
