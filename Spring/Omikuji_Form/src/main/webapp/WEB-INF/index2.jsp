<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<div class="container d-block justify-content-start" style="width:600px">
	<h1>Here is you Message</h1>
	
	<div style="background-color: aqua; width:200px">
	 in <%=session.getAttribute("years") %> years you will live in <%=session.getAttribute("city")%> with <%=session.getAttribute("person")%> as your roommate, <%=session.getAttribute("hobby")%> for a living. the next time you see a <%=session.getAttribute("thing")%>, you will have good luck. Also, <%=session.getAttribute("blurb")%>
	</div>
	
	<a href="/Omikuji" target="_self" rel="noopener noreferrer">Go back to Form</a>
	
</div>
</body>
</html>