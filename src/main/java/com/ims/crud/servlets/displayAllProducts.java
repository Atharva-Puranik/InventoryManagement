package com.ims.crud.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.crud.DAO.productDAO;
import com.ims.crud.models.Product;

@WebServlet("/displayAllProducts")
public class displayAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public displayAllProducts() {
		super();
		// TODO Auto-generated constructor stub

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> productsList = productDAO.fetchAllProducts();
        
		request.setAttribute("productsList", productsList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewProducts.jsp");
		dispatcher.forward(request, response);
		
	}

}
