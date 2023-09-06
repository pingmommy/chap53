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
<h1>AlphaForm2실습</h1>

<form action="/alpha2">
	<fieldset>
		<legend>position</legend>
		<label>line</label>
		<input name="line" type="number" value="${empty param.line? 10 : param.line}" min="1" max="20">
		<label>column</label>
		<input name="column" type="number" value="${empty param.column? 20 : param.column}" min="1" max="40">
	</fieldset>
	<fieldset>
		<legend>character</legend>
		 <c:forEach var="ch" items="${chs}">
			<label for="${ch}">${ch}</label>
			<c:choose>
			  <c:when test="${empty param.ch and ch =='A'}">
			 	<input type="radio" name="ch" id="ch" value="${ch}" checked="checked" > 
			  </c:when>
			  <c:when test="${!empty param.ch and param.ch eq ch}">
			 	<input type="radio" name="ch" id="ch" value="${ch}" checked="checked" > 
			  </c:when>
			  <c:otherwise>
			 	<input type="radio" name="ch" id="ch" value="${ch}" > 
			 </c:otherwise>	 
			</c:choose>
		 </c:forEach>
	</fieldset>
	
	<fieldset>
		<legend>color</legend>
		
		<label>fg</label>
		<select name="fg">
		<c:forEach var="fg" items="${colors}">
			<c:choose>
				<c:when test="${param.fg eq fg}">
					<option value="${fg}" selected="selected">${fg}</option>
				</c:when>
				<c:otherwise>
					<option value="${fg}">${fg}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		 </select>
		 
		 <label>bg</label>
		 <select name="bg">
		<c:forEach var="bg" items="${colors}">
		  <c:choose>
		    <c:when test="${param.bg eq bg}">
			<option value="${bg}" selected="selected">${bg}</option>
		    </c:when>
		    <c:otherwise>
			<option value="${bg}">${bg}</option>
		    </c:otherwise>
		  </c:choose>
		</c:forEach>
		 </select>
		 
	</fieldset>

<input type="submit">
</form>
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

</body>
</html>