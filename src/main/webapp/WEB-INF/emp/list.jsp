<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmpList</title>
</head>
<form action="/emp/list">
	<input type="text" name="search">
	<input type="submit">
</form>
<body>
<table border="1" width="700">
<thead>
	<th>empno</th>
	<th>ename</th>
	<th>gender</th>
	<th>job</th>
	<th>mgr</th>
	<th>hiredate</th>
	<th>sal</th>
	<th>comm</th>
	<th>deptno</th>
	</thead>
<tbody>
	<c:forEach var="emp" items="${list}">
	<tr>
		<td>${emp.empno}</td>
		<td>${emp.ename}</td>
		<td>${emp.gender}</td>
		<td>${emp.job}</td>
		<td>${emp.mgr}</td>
		<td>${emp.hiredate}</td>
		<td>${emp.sal}</td>
		<td>${emp.comm}</td>
		<td>${emp.deptno}</td>
	</tr>
	</c:forEach>
</tbody>
</table>

</body>
</html>