package com.ims.requests.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.requests.DAO.RequestLogsDAO;
import com.ims.requests.models.RequestLogs;

@WebServlet("/RequestLogsServlet")
public class RequestLogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RequestLogs> logs = RequestLogsDAO.getAllRequestLogs();
        request.setAttribute("logs", logs);
        request.getRequestDispatcher("adminRequests.jsp").forward(request, response);
	}

}
