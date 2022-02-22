<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>

<!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<!-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   -->
<!-- for rendering errors on PUT routes -->
<!-- <%@ page isErrorPage="true" %>    -->

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
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
      <div class="d-flex justify-content-between">
        <h1>${selectedBook.title}</h1>
        <a href="/books"> Back to Book Shelf</a>
      </div>
    <h1></h1>  
      <div class="mt-4">
        <c:choose>
          <c:when test="${hasRead}">
            You have read <span style="color:red; font-weight: bold">${selectedBook.title}</span> by <span style="color:green; font-weight: bold">${selectedBook.author}</span>
          </c:when>
          <c:otherwise> 
            ${selectedBook.getOwners().get(0).userName} has read <span style="color:red; font-weight: bold">${selectedBook.title}</span> by <span style="color:green; font-weight: bold">${selectedBook.author}</span>
          </c:otherwise>
        </c:choose>
        <div>
          here are the owners thoughts
        </div>
        <div style="border : solid grey 3px ; width:400px ;height:auto">
          ${selectedBook.comments}
        </div>
      </div>
    </div>
  </body>
</html>
