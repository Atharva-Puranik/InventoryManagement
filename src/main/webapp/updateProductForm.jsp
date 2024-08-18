<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ims.crud.models.Product" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<%
		Product p = (Product)request.getAttribute("product");
	%>
	<h1>Provide Product Details</h1>
	<form action="updateProduct" method="get">
		<input type="text" name="productId" hidden value=<%=p.getProductId() %>></input><br>
		<label for="productName">Product Name:</label>
		<input type="text" name="productName" value=<%=p.getProductName() %>></input><br>
		<label for="productCategory">Product Category:</label>
		<input type="text" name="productCategory" value=<%=p.getCategory() %>></input><br>
		<label for="productQuantity">Product Quantity:</label>
		<input type="number" name="productQuantity" value=<%=p.getInventory().getQuantity() %>></input><br>
		<input type="submit" name="Submit">
		<input type="reset" name="Reset">
	</form>
	
</body>
</html>