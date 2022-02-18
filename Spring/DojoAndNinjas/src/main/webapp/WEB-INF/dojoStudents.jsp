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
    <h1>Dojo Class: ${dojo.name}</h1>
    <p><a href="/">Home</a></p>
    <table class="table table-success table-striped">
      <thead>
        <tr class="table">
          <th scope="col">#</th>
          <th scope="col">First Name</th>
          <th scope="col">Last Name</th>
          <th scope="col">Age</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items='${ dojo.ninjas }' var='ninjaObj' varStatus="loop">
        <tr>
          <th scope="row">${loop.index +1}</th>
          <td>${ninjaObj.firstName}</td>
          <td>${ninjaObj.lastName}</td>
          <td>${ninjaObj.age}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>


  </div>

</body>
</html>