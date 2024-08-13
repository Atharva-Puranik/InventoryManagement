package com.ims.crud.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.crud.DAO.productDAO;

@WebServlet("/deleteProduct")
public class deleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deleteProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int productId =Integer.parseInt(request.getParameter("productId"));
		productDAO.deleteProductRecord(productId);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("displayAllProducts");
		dispatcher.forward(request, response);
		
	}

}
