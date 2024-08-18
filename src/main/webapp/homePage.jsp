<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IMS Homepage</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<h1>IMS Homepage</h1>
    <div class="navbar">
        <a href="displayAllProducts" target="contentFrame">Display all Products</a>
        <a href="insertProductForm.jsp" target="contentFrame">Insert a Product</a>
        <a href="userRequest.jsp" target="contentFrame">Make a request</a>
        <a href="AdminRequest" target="contentFrame">Check requests</a>
    </div>
    <iframe name="contentFrame" src="displayAllProducts"></iframe>
</body>
</html>
