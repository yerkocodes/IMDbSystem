<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Show</title>
<%@ include file="../../layouts/headCDN.html"  %>
</head>
<body>
	<%@ include file="../../layouts/navbar.html"%>

	<header class="container mx-auto mt-5">
		<h1 class="fw-bold"><c:out value="${showToUpdate.getShowTitle()}"></c:out> </h1>	
	</header>
	
	<main>
		<section class="container my-5">
			<form:form name="formUpdateShow" action="/edit" method="POST" modelAttribute="updateShowForm">
				<input name="id" type="hidden" value="${showToUpdate.getId()}">
				<div class="row mb-3">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Show Title: </label>
					<div class="col-sm-10">
						<input name="showTitle" type="text" value="${showToUpdate.getShowTitle()}" class="form-control" id="inputEmail3">
					</div>
				</div>
				<div class="row mb-3">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Show Network: </label>
					<div class="col-sm-10">
						<input name="showNetwork" type="text" value="${showToUpdate.getShowNetwork()}" class="form-control" id="inputPassword3">
					</div>
				</div>
				<div class="d-flex justify-content-center my-2">
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
				<div class="my-2">
					<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">Delete</button>
				</div>
				<div class="my-5">
					<button type="submit" class="btn btn-dark btn-sm" href="" disabled>Go back</button>
				</div>
			</form:form>
		</section>
	</main>

	<!-- Modal -->
<!-- 	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
 	<div class="modal fade" id="exampleModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Delete Show</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="alert alert-danger" role="alert">
						You are completely sure you want to delete the show <span class="fw-bold"><c:out value="${showToUpdate.getShowTitle()}"></c:out></span>
					</div>
				</div>
				<div class="modal-footer">
					<a class="btn btn-success" href="/show/delete?showId=${showToUpdate.getId()}">Confirm</a>
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Abort</button>
				</div>
			</div>
		</div>
	</div>
	
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	

</body>
</html>