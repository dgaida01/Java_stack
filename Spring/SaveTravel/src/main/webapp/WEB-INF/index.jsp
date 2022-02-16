<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
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
    <title>Expense</title>
    <!-- Bootstrap -->
    <link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous"
    />
</head>

<body>
    <div class="container">
		<h1 style="color: #1a1acc" class="ms-4">Safe Travels</h1>

		<table class="table" style="width: 400px">
        	<thead>
        		<tr>
					<th scope="col">#</th>
					<th scope="col">Expense</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
        		</tr>
        	</thead>
			<tbody>
			<c:forEach items="${allExp}" var="anExp" varStatus="loop">
				<tr>
					<th scope="row">${loop.index+1}</th>
					<td>${anExp.expenseName}</td>
					<td>${anExp.vendor}</td>
					<td>${anExp.amount}</td>
				</tr>
			</c:forEach>
			</tbody>
    	</table>
    	<h1 style="color: #1a1acc" class="ms-2">Add an expense</h1>
    	<form:form action="/addExpense" method="post" modelAttribute="exp" >
			<form:errors path="expenseName" class="text-danger" />
        	<div class="form-floating mb-3" style="width: 400px">				
				<form:input
					type="text"
					path="expenseName"
					class="form-control"
					id="expenseName"
					placeholder="1"
        		/>
        	<form:label path="expenseName">Expense Name</form:label>
        </div>
			<form:errors path="vendor" class="text-danger"/>	
        <div class="form-floating mb-3" style="width: 400px">
			<form:input
            type="text"
            path="vendor"
            class="form-control"
            id="vendor"
            placeholder="1"
          />
          <form:label path="vendor">Vendor</form:label>
        </div>
		<form:errors path="amount" class="text-danger"/>
        <div class="form-floating mb-3" style="width: 400px">
        	<form:input
            type="number"
			step="any"
            path="amount"
            class="form-control"
            id="amount"
            placeholder="1"
          />
          <form:label path="amount">Amount</form:label>
        </div>
		<form:errors path="description" class="text-danger"/>
        <div class="form-floating mb-3" style="width: 400px">
          <form:input
            type="text"
            path="description"
            class="form-control"
            id="description"
            placeholder="1"
          />
          <form:label path="description">Description</form:label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form:form>
    </div>
  </body>
</html>
