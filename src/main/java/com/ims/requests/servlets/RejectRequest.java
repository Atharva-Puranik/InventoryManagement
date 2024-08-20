package com.ims.requests.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.requests.DAO.RequestLogsDAO;
import com.ims.requests.models.RequestLogs;
import com.ims.requests.DAO.AdminRequestDAO;

@WebServlet("/RejectRequest")
public class RejectRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int requestId = Integer.parseInt(request.getParameter("id"));
		System.out.println(requestId);
		RequestLogs log = new RequestLogs();
		log.setRequestId(requestId);
		log.setUserName((String) request.getSession().getAttribute("username"));
		log.setProductName(AdminRequestDAO.getProductNameFromId(requestId));
		log.setQuantity(AdminRequestDAO.getRequestQuantity(requestId));
		log.setStatus("Rejected");
		log.setActionTime(LocalDateTime.now());
		RequestLogsDAO.addRequest(log);
		AdminRequestDAO.deleteRequest(requestId);
		response.sendRedirect("AdminRequest");
	}

}
