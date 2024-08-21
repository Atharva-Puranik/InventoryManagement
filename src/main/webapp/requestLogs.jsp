<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ims.requests.DAO.RequestLogsDAO" %>
<%@ page import="com.ims.requests.models.RequestLogs" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Logs</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<table class="table table-bordered border-primary">
		<tr>
			<th>Request ID</th>
			<th>Username</th>
			<th>Product Name</th>
			<th>Quantity</th>
			<th>Status</th>
			<th>Timestamp</th>
		</tr>		
		<% List<RequestLogs> logs = (List<RequestLogs>) request.getAttribute("logs"); %>
		<% for(RequestLogs log: logs){ %>
		<tr>
			<td><% 
			log.getRequestId();
			%></td>
		</tr>
		<tr>
			<td><% 
			log.getUserName();
			%></td>
		</tr>
		<tr>
			<td><% 
			log.getProductName();
			%></td>
		</tr>
		<tr>
			<td><% 
			log.getQuantity();
			%></td>
		</tr>
		<tr>
			<td><% 
			log.getStatus();
			%></td>
		</tr>
		<tr>
			<td><% 
			log.getActionTime();
			%></td>
		</tr>
		<%}%>
	</table>
</body>
</html>