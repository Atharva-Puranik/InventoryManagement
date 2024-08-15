<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Requests</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="UserRequest">
<div class="form-group">
<label for="product">Enter item name</label>
<input type="text" class="form-control" name="product">
</div>
<div class="form-group">
<label for="quantity">Enter quantity</label>
<input type="number" class="form-control" name="quantity" min="1">
</div>
<div class="form-group">
<button type="submit" class="btn btn-primary my-1">Submit</button>
</div>
</form>
</body>
</html>