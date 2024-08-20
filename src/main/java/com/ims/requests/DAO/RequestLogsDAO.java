package com.ims.requests.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ims.crud.configs.dbConnection;
import com.ims.requests.models.RequestLogs;
import com.ims.requests.models.Requests;

public class RequestLogsDAO {
	@SuppressWarnings("unchecked")
	public static List<Requests> getAllRequestLogs() {
		try(Session session = dbConnection.initDatabase()){
			session.beginTransaction();
			String hql = "FROM RequestLogs";
			Query<?> query = session.createQuery(hql);
			List<Requests> requests = (List<Requests>) query.list();
			session.getTransaction().commit();
			System.out.println(requests);
			return requests;
		}
	}
	public static void addRequest(RequestLogs log) {
		try(Session session = dbConnection.initDatabase()){
			session.beginTransaction();
			session.save(log);
			session.getTransaction().commit();
		}
	}
}
