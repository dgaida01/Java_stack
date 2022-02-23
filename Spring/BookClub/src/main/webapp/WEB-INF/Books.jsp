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
<title>Book Shelf</title>
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
      <div>
        <h1>Welcome ${currentUser.userName}</h1>
        <p>books from everyon's shelf</p>
      </div>
    <a href="/logout">Logout</a>
    <a href="/trash/${currentUser.id}">Trash my account</a>
  </div>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Title</th>
          <th scope="col">Author</th>
          <th scope="col">Owners</th>
          <th scope="col" class="col-2">Actions</th>
          <th scope="col" > Rating</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items='${ allBooks }' var='bookObj' varStatus="loop">
          <tr>
            <th scope="row">${loop.index +1}</th>
            <td><a href="/books/${bookObj.id}/${currentUser.id}/details">${bookObj.title}</a></td>
            <td>${bookObj.author}</td>
            <td> <!-- Loop for getting all owners of the book -->
            <c:forEach items='${bookObj.owners}' var='ownerObj'>
              ${ownerObj.userName} /
            </c:forEach>
            </td>
            
            <td>
              <a href="/books/rate/${bookObj.id}">Add Rating</a>
              <a href="/books/delete/${bookObj.id}"> delete</a>
            </td>
            <td>
              <c:choose>
                <c:when test='${bookObj.bookRating.size()==0}'>
                  No Rating
                </c:when>
                <c:otherwise>
                  ${bookObj.averageRating()}
                </c:otherwise>
              </c:choose>
              
            
            </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <a href="/books/add" class="btn btn-success">Add Book</a>




  </div>

</body>
</html>