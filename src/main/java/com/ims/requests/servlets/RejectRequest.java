package com.ims.requests.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.requests.DAO.AdminRequestDAO;

@WebServlet("/RejectRequest")
public class RejectRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int requestId = Integer.parseInt(request.getParameter("id"));
		System.out.println(requestId);
		AdminRequestDAO.deleteRequest(requestId);
		response.sendRedirect("AdminRequest");
	}

}
