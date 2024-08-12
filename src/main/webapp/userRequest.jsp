<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Requests</title>
</head>
<body>
<form action="UserRequest">
<pre>
<label for="product">Enter item name</label>
<input type="text" name="product">
</pre>
<pre>
<label for="quantity">Enter quantity</label>
<input type="number" name="quantity" min="1">
</pre>
<pre>
<input type="submit">
</pre>
</form>
</body>
</html>