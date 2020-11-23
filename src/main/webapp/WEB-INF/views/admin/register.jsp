<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:form action="/admin/register" method="POST" modelAttribute="account">
		Tên : <f:input  path="mail" />
		<br>
		Mk : <f:password path="password"/>
		<br>
		
		Date:	
		<f:hidden path="created_at"/>
		    <input type="submit" name="submit" value="submit">
	</f:form>
</body>
</html>