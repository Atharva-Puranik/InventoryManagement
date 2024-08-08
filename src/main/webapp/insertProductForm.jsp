<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Provide Product Details</h1>
	<form action="insertProduct" method="get">
		<label for="productName">Product Name:</label>
		<input type="text" name="productName"/><br>
		<label for="productCategory">Product Category:</label>
		<input type="text" name="productCategory"/><br>
		<label for="productQuantity">Product Quantity:</label>
		<input type="number" name="productQuantity"/><br>
		<input type="submit" name="Submit">
		<input type="reset" name="Reset">
	</form>

</body>
</html>