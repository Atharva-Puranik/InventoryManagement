<%@page import="com.ims.crud.models.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Product> productsList = (List<Product>) request.getAttribute("productsList");
	%>

	<table>
		<caption>All Products</caption>
		<tr>
			<th>Product Id.</th>
			<th>Name</th>
			<th>Category</th>
			<th>Quantity</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<% for(Product product: productsList){ %>
		<tr>
			<td><%= product.getProductId() %></td>
			<td><%= product.getProductName() %></td>
			<td><%= product.getCategory() %></td>
			<td><%= product.getInventory().getQuantity() %></td>
			<td><a href='findProduct?productId=<%= product.getProductId()%>'>Update</a></td>
			<td><a href='deleteProduct?productId=<%= product.getProductId()%>'>Delete</a></td>
		</tr>
		<%}%>
	</table>
</body>
</html>