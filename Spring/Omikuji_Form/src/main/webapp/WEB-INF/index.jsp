<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<div class="container d-block justify-content-start" style="width:600px">
	<h1>Send an Omikuji</h1>
	<form action="/prepOmikuji" method="POST">
		<div class="mb-3">
			<label for="" class="form-lable">Pick any number from 5 to 25</label> <br>
			<input type="number" name="years" id="years" value="5" style="width:50px">
		</div>
		<div class="mb-3">
			<label for="" class="form-lable">Enter the name of any City</label> <br>
			<input type="text" name="city" id="city"  style="width:250px">
		</div>
		<div class="mb-3">
			<label for="" class="form-lable">Enter the name of any real Person</label> <br>
			<input type="text" name="person" id="person"  style="width:250px">
		</div>
		<div class="mb-3">
			<label for="" class="form-lable">Enter professional endeavor or hobby</label> <br>
			<input type="text" name="hobby" id="hobby"  style="width:250px">
		</div>
		<div class="mb-3">
			<label for="" class="form-lable">Enter ay type of living thing</label> <br>
			<input type="text" name="thing" id="thing"  style="width:250px">
		</div>
		<div class="mb-3">
			<label for="" class="form-lable">Say something nice about someone</label> <br>
			<textarea rows="5" cols="40" name="blurb" id="blurb"> </textarea>
		</div>
		<button type="submit">Send Message</button>
	</form>
</div>
</body>
</html>