package com.ims.crud.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ims.crud.DAO.productDAO;
import com.ims.crud.configs.dbConnection;
import com.ims.crud.models.Inventory;
import com.ims.crud.models.Product;

@WebServlet("/updateProduct")
public class updateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateProduct() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productName = request.getParameter("productName");
		String productCategory = request.getParameter("productCategory");
		int productQuantity =Integer.parseInt(request.getParameter("productQuantity"));
		int productId =Integer.parseInt(request.getParameter("productId"));
		
		Product productWithUpdatedDetails = new Product(productId,productName,productCategory);
		boolean check = productDAO.updateProductRecord(productWithUpdatedDetails,productQuantity, productId);
		if(check) {
			response.sendRedirect("homePage.jsp"); 
		} else {
			response.sendRedirect("homePage.jsp"); 
		}
		
    }
}
