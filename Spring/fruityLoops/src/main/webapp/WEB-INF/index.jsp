<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>First JSP</title>


 

</head>
<body>
	<div class="container" style="width:400px">
	<h1 style="color: pink">Fruit Store Inventory</h1>
	<p>	Testing Jquery</p>
	<p>	Testing Jquery2</p>
	<table class="table table-dark table-sm">
		<thead>
			<tr>
				<th>number</th>
				<th scope="col">Fruit</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="thing" items="${inventory}" varStatus="loop">
				<tr>
					<td>${loop.index+1}</td>
				<td>${thing.name}</td>
				<td>${thing.price } </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button onClick="testColor()">pushme</button>
</div>
<script type="text/javascript" src="/js/jstest.js"></script>
</body>
</head>