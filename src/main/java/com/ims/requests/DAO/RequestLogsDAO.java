package com.ims.requests.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ims.crud.configs.dbConnection;
import com.ims.requests.models.RequestLogs;

public class RequestLogsDAO {
	@SuppressWarnings("unchecked")
	public static List<RequestLogs> getAllRequestLogs() {
		try(Session session = dbConnection.initDatabase()){
			session.beginTransaction();
			String hql = "FROM RequestLogs";
			Query<?> query = session.createQuery(hql);
			List<RequestLogs> logs = (List<RequestLogs>) query.list();
			session.getTransaction().commit();
			return logs;
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
