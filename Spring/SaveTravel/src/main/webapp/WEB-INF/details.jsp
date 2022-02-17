<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <!-- <%@ page isErrorPage="true" %>    -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Detail</title>
<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
crossorigin="anonymous"
/>
<link rel="stylesheet" href="/css/style.css">

</head><body>
  <div class="container">
    <div class="d-flex justify-content-between" style="max-width:500px">
      <h1 style="color: #1a1acc" class="ms-2">Expense Detail</h1> 
    
      <a href="/" style="text-decoration:none" class="align-self-center">Go <img src="/icons/house.svg" class="filter-blue " alt=""> Home</a>
    </div>
    <div class="row">
      <div class="col-2">Expense Name:</div>
      <div class="col-2"> ${exp.expenseName}</div>
    </div>
    <hr>
    <div class="row">
      <div class="col-2">Description:</div>
      <div class="col-2"> ${exp.description}</div>
    </div>
    <hr>
    <div class="row">
      <div class="col-2">Vendor:</div>
      <div class="col-2"> ${exp.vendor}</div>
    </div>
    <div class="row">
      <div class="col-2">Amount:</div>
      <div class="col-2"> $${exp.amount}</div>
    </div>
  </div>
  
</body>
</html>