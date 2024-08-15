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
		System.out.println("Accept servlet");
		response.setContentType("text/html");
		int requestId = Integer.parseInt(request.getParameter("id"));
		int requestQuantity = AdminRequestDAO.getRequestQuantity(requestId);
		System.out.println("request quantity: " + requestQuantity);
		int inventoryQuantity = AdminRequestDAO.getInventoryQuantity(requestId);
		System.out.println("inventory quantity: " +inventoryQuantity);
		if(inventoryQuantity > requestQuantity) {
			//updateProduct.java
			response.getWriter().println("request accepted");
			AdminRequestDAO.deleteRequest(requestId);
		}
		else {
			response.getWriter().println("Not enough quantity in inventory!");
		}
		request.getRequestDispatcher("AdminRequest").include(request, response);
	}

}
