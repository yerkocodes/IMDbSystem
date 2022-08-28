<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new Show</title>
<%@ include file="../../layouts/headCDN.html"  %>
</head>
<body>
	<%@ include file="../../layouts/navbar.html"%>

	<header class="container mx-auto mt-5">
		<h1 class="fw-bold">Create a new show</h1>	
	</header>
	
	<main>
		<section class="container my-5">
			<form:form name="formUpdateShow" action="/add" method="POST" modelAttribute="addShowForm">
				<div class="row mb-3">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Show Title: </label>
					<div class="col-sm-10">
						<input name="showTitle" type="text" class="form-control" id="inputEmail3">
					</div>
				</div>
				<div class="row mb-3">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Show Network: </label>
					<div class="col-sm-10">
						<input name="showNetwork" type="text" class="form-control" id="inputPassword3">
					</div>
				</div>
				<div class="d-flex justify-content-center my-2">
					<button type="submit" class="btn btn-primary">Create</button>
				</div>
				<div class="my-5">
					<button type="submit" class="btn btn-dark btn-sm" href="" disabled>Go back</button>
				</div>
			</form:form>
		</section>
	</main>

</body>
</html>