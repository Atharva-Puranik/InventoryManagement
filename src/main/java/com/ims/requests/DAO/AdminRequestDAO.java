package com.ims.requests.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ims.crud.configs.dbConnection;
import com.ims.requests.models.Requests;
public class AdminRequestDAO {
	@SuppressWarnings("unchecked")
	public static List<Requests> getAllRequests() {
		try(Session session = dbConnection.initDatabase()){
			session.beginTransaction();
			String hql = "FROM Requests";
			Query<?> query = session.createQuery(hql);
			List<Requests> requests = (List<Requests>) query.list();
			session.getTransaction().commit();
			System.out.println(requests);
			return requests;
		}
	}
	public static String getProductNameFromId(int requestId) {
		try(Session session = dbConnection.initDatabase()){
			session.beginTransaction();
			String hql = "Select productName FROM Product WHERE productId=:id";
			Query<String> query = session.createQuery(hql, String.class);
			query.setParameter("id", requestId);
			List<String> results = query.list();
			session.getTransaction().commit();
			if (!results.isEmpty()) {
				return results.get(0);
			}
			return "";
		}
	}
	public static int getRequestQuantity(int requestId) {
		try(Session session = dbConnection.initDatabase()){			
			session.beginTransaction();
			String hql = "Select quantity FROM Requests WHERE requestId=:id";
			Query<Integer> query = session.createQuery(hql, Integer.class);
			query.setParameter("id", requestId);
			List<Integer> results = query.list();
			session.getTransaction().commit();
			if (!results.isEmpty()) {
				return results.get(0);
			}
			return 0;
		}
	}
	public static int getInventoryQuantity(int requestId) {
		try(Session session = dbConnection.initDatabase()){			
			session.beginTransaction();
			String hql = "Select quantity FROM Product WHERE productId=(SELECT productId from Requests where requestId=:id)";
			Query<Integer> query = session.createQuery(hql, Integer.class);
			query.setParameter("id", requestId);
			List<Integer> results = query.list();
			session.getTransaction().commit();
			if (!results.isEmpty()) {
				return results.get(0);
			}
			return 0;
		}
	}
	public static void deleteRequest(int requestId) {
		try(Session session = dbConnection.initDatabase()){			
			session.beginTransaction();
			String hql = "DELETE FROM Requests WHERE requestId=:id";
			Query<?> query = session.createQuery(hql);
			query.setParameter("id", requestId);
			query.executeUpdate();
			session.getTransaction().commit();
		}
	}
}
