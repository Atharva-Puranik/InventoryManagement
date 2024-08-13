package com.ims.crud.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.crud.DAO.productDAO;
import com.ims.crud.models.Product;

@WebServlet("/findProduct")
public class findProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public findProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId =Integer.parseInt(request.getParameter("productId"));
		Product productToBeUpdated = productDAO.findProductById(productId);
		
		request.setAttribute("product", productToBeUpdated);
		//request.setAttribute("productId", productId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductForm.jsp");
		dispatcher.forward(request, response);
		
	}

}
