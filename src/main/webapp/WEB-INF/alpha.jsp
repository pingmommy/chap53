<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>alpha</title>
<style type="text/css">
table {
 border-collapse: collapse;
 font-size: 2em;
 font-family: monospace;
}
</style>
</head>
<body>
<h1>AlphaForm실습</h1>
<table>
<tbody>
 <c:forEach var="row" items="${alphas}">
 	<tr>
 		<c:forEach var="alpha" items="${row}"> 
 		  <td style="background:${alpha.bg}; color:${alpha.fg};">${alpha.ch}</td>
 		</c:forEach>
 	</tr>
 </c:forEach>
</tbody>
</table>
<hr>
<table>
<c:forEach var="i" begin="0" end="19">
	<tr>
	<c:forEach var="j" begin="0" end="39">
	  <td style="background:${alphas[i][j].bg}; color:${alphas[i][j].fg};">${alphas[i][j].ch}</td>
	</c:forEach>
	</tr>
</c:forEach>
</table>
</body>
</html>