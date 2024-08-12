package com.ims.crud.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.crud.DAO.productDAO;
import com.ims.crud.models.Inventory;
import com.ims.crud.models.Product;

@WebServlet("/insertProduct")
public class insertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productName = request.getParameter("productName");
		String productCategory = request.getParameter("productCategory");
		int productQuantity =Integer.parseInt(request.getParameter("productQuantity"));
		
		Inventory i = new Inventory();
		i.setQuantity(productQuantity);
		Product p = new Product();
		p.setProductName(productName);
		p.setCategory(productCategory);
		p.setInventory(i);
		i.setProduct(p);
		
		productDAO.insertProduct(p);
		response.setContentType("text/html");
		response.getWriter().println("<b>Added Product</b>");
		request.getRequestDispatcher("homePage.jsp").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
