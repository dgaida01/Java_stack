<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
crossorigin="anonymous"
/>
</head>
<body>
<div class="container">
<h1>Add Rating to ${theBook.title}</h1>

<form:form action="/books/rate/${theBook.id}/create" method="post" modelAttribute="theScore" style="width:200px">
  <form:input type="hidden" value="${theBook.id}" path="aBook"/>
  <form:errors path="score" />
  <form:label path="score" >Rate from 1-10</form:label>
  <form:input path="score" type="number" step="any" class="form-control"/>
<button type="submit" class="btn btn-primary">Save</button>
<a href="/books" class="btn btn-warning">Cancel</a>
</form:form>


</div>
</body>
</html>