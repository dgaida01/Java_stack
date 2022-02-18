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
<title>Add Ninja</title>
<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
crossorigin="anonymous"
/>
</head>
<body>
  <div class="container">
    <h1>Add Ninja</h1>
    
    <form:form action="/ninja/create" method="post" modelAttribute="ninja" style="width: 25%">
      <form:errors path="dojo"/>
      <form:select class="form-select mb-3" path="dojo">
        <option value="" disabled selected hidden>Choose Dojo...</option>
        <c:forEach items='${ dojoList }' var='dojoObj'>        
        <form:option path="dojo" value="${dojoObj.id}">${dojoObj.name}</form:option>
        </c:forEach>
      </form:select>
      <form:errors path="firstName" class="text-danger"/>
      <div class="form-floating mb-3">
        <form:input type="text" path="firstName" class="form-control"   placeholder="1"/>
        <label path="firstName">First Name:</label>
      </div>
      <form:errors path="lastName" class="text-danger"/>
      <div class="form-floating mb-3">
        <form:input type="text" class="form-control" path="lastName"  placeholder="1"/>
        <label path="lastName">Last Name:</label>
      </div>
      <form:errors path="age" class="text-danger"/>
      <div class="form-floating mb-3">
        <form:input type="number" class="form-control" path="age" placeholder="1"/>
        <label path="age">Age:</label>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
      <a href="/" class="btn btn-warning">Cancel</a>
    </form:form>

</div>

</body>
</html>