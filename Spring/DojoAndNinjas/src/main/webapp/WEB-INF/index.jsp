<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

  <!-- c:out ; c:forEach ; c:if -->
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Formatting (like dates) -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
      <!-- form:form -->
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!-- for rendering errors on PUT routes -->
        <%@ page isErrorPage="true" %>   

        <!DOCTYPE html>
        <html>

        <head>
          <meta charset="ISO-8859-1" />
          <title>Insert title here</title>
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous" />
        </head>

        <body>
          
          <div class="container">
            <h1>Add a Dojo Location</h1>
            <a href="/ninja/add">Add A Ninja to a Dojo</a>
            <form:form action="/dojo/create" method="post" modelAttribute="theDojo">
              <form:errors path="name" class="text-danger" /> <br>
              <label for="dojo name">New Dojo:</label>
              <form:input type="text" path="name" class="form-control" style="width: 15%" />
              <button type="submit" class="btn btn-success">Submit</button>
            </form:form>

            <hr>
            <table class="table table-info table-striped">
              <thead>
                <tr class=" table-dark">
                  <th scope="col">#</th>
                  <th scope="col">Dojo Name</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items='${ allDojos }' var='dojo' varStatus="loop">
                <tr>
                  <th scope="row">${loop.index+1}</th>
                  <td><a href="/dojo/${dojo.id}/students">${dojo.name}</a></td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </body>

        </html>