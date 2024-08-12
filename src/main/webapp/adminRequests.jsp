<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ims.requests.DAO.AdminRequestDAO" %>
<%@ page import="com.ims.requests.models.Requests" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Requests</title>
</head>
<body>
<table>
		<caption>All Requests</caption>
		<tr>
			<th>Name</th>
			<th>Quantity</th>
			<th>Accept</th>
			<th>Reject</th>
		</tr>		
		<% List<Requests> requests = (List<Requests>) request.getAttribute("requests"); %>
		<% for(Requests req: requests){ %>
		<tr>
			<td><% int id = req.getProductId();
				String productName = AdminRequestDAO.getProductNameFromId(id);
				out.print(productName);
			%></td>
			<td><%= req.getQuantity() %></td>
			<td><% 
			response.setContentType("text.html");
			out.println("<a href='AcceptRequest?id=" + req.getRequestId() + "'>Accept</a>");%></td>
			<td><% 
			response.setContentType("text.html");
			out.println("<a href='RejectRequest?id=" + req.getRequestId() + "'>Reject</a>");%></td>
		</tr>
		<%}%>
	</table>
</body>
</html>