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
<title>Add Book</title>
<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
crossorigin="anonymous"
/>
</head>
<body>
<div class="container">
<h1>Add a Book to Your Shelf</h1>
<form:form action="/books/create" method="post" modelAttribute="newBook">
  
  <form:errors path="title" class="text-danger"/>
  <div class="form-floating mb-3">
    <form:input  path="title"  class="form-control" id="floatingInput" placeholder="1"/>
    <label for="floatingInput">Title</label>
  </div>
  <form:errors path="author" class="text-danger"/>
  <div class="form-floating mb-3">
    <form:input  path="author"  class="form-control" id="floatingInput" placeholder="1"/>
    <label  for="floatingInput">Author's Name</label>
  </div>
  <form:errors path="comments" class="text-danger"/>
  <div class="form-floating mb-3">
    <form:textarea  path="comments" rows="4" cols="50" class="form-control" id="floatingInput" placeholder="1"/>
    <label  for="floatingInput">My Thoughts</label>
  </div>
  <div>
    <form:button type="submit" class="btn btn-primary">Submit</form:button>
    <a href="/books" class="btn btn-warning">Cancel</a>
  </div>
</form:form>

</div>
</body>
</html>