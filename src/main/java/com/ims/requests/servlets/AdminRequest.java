package com.ims.requests.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ims.requests.DAO.AdminRequestDAO;
import com.ims.requests.models.Requests;

@WebServlet("/AdminRequest")
public class AdminRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Requests> requests = AdminRequestDAO.getAllRequests();
        request.setAttribute("requests", requests);
        request.getRequestDispatcher("adminRequests.jsp").forward(request, response);
	}
}
