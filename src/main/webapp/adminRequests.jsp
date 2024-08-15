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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<table class="table table-bordered border-primary">
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
			response.setContentType("text/html");
			out.println("<a href='AcceptRequest?id=" + req.getRequestId() + "'>Accept</a>");%></td>
			<td><% 
			response.setContentType("text/html");
			out.println("<a href='RejectRequest?id=" + req.getRequestId() + "'>Reject</a>");%></td>
		</tr>
		<%}%>
	</table>
</body>
</html>