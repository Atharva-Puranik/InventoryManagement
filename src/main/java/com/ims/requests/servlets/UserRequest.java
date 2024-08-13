package com.ims.requests.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.requests.DAO.UserRequestDAO;
import com.ims.requests.models.Requests;

@WebServlet("/UserRequest")
public class UserRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("product");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int productId = UserRequestDAO.getProductId(productName);
		System.out.println("id=" + productId);
		Requests userRequest = new Requests(productId, quantity);
		UserRequestDAO.addRequest(userRequest);
		response.setContentType("text/html");
		response.getWriter().println("<b>Added Request</b>");
		request.getRequestDispatcher("homePage.jsp").include(request, response);
	}
}
