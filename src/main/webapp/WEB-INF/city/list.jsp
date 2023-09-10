<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>city</title>
</head>
<body>
<h1>CITYLIST</h1>
<form action="/city/list">
<input type="text" name="cityname">
<input type="text" name="district"> 
<input type="submit">
</form>
<table border="1" width ="500">
<thead>
	<th>id</th>
	<th>name</th>
	<th>country_code</th>
	<th>district</th>
	<th>population</th>
</thead>

<tbody>
 	<c:forEach var="city" items="${list}">
 	<tr>
 	 	<td>${city.id}</td>
 	 	<td>${city.name}</td>
 	 	<td>${city.country_code}</td>
 	 	<td>${city.district}</td>
 	 	<td>${city.population}</td>
 	</tr>
 	</c:forEach>
</tbody>
</table>
</body>
</html>