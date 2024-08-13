package com.ims.requests.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.requests.DAO.AdminRequestDAO;

@WebServlet("/AcceptRequest")
public class AcceptRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int requestId = Integer.parseInt(request.getParameter("id"));
		int requestQuantity = AdminRequestDAO.getRequestQuantity(requestId);
		int inventoryQuantity = AdminRequestDAO.getInventoryQuantity(requestId);
		if(inventoryQuantity > requestQuantity) {
			//updateProduct.java
			AdminRequestDAO.deleteRequest(requestId);
		}
		else {
			response.setContentType("text.html");
			response.getWriter().println("Not enough quantity in inventory!");
		}
		request.getRequestDispatcher("homePage.jsp").include(request, response);
	}

}
