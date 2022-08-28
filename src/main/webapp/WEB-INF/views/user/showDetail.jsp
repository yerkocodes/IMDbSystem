<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Details</title>
<%@ include file="../../layouts/headCDN.html"  %>
</head>
<body>
	<%@ include file="../../layouts/navbar.html"%>
	
	<header class="container mx-auto mt-5">
		<h1>Title: <c:out value="${show.getShowTitle()}"></c:out> </h1>	
		<h2>Network: <c:out value="${show.getShowNetwork()}"></c:out> </h2>	
	</header>
	
	<main>
		<section class="container mx-auto">

		<h3 class="fw-bold">Users who rated this show</h3>

			<table class="table">
				<thead>
					<tr class="table-dark">
						<th scope="col">Name</th>
						<th scope="col">Rating</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Mark</td>
						<td>Otto</td>
					</tr>
				</tbody>
			</table>
			
			<div class="my-3">
				<a class="btn btn-primary" href="/show/edit?showId=${show.getId()}" role="button">Edit</a>
			</div>

			<form:form name="sendRating" action="/changeRating" method="POST" class="row gy-2 gx-3 align-items-center">
				<div class="col-auto align-items-center">
					<p class="m-0">Leave a rating: </p>
					<input name="showId" type="hidden" value="${show.getId()}">
				</div>
				<div class="col-auto">
					<label class="visually-hidden" for="autoSizingSelect">Preference</label>
					<select name="rating" class="form-select" id="autoSizingSelect">
						<option selected disabled>Choose an option</option>
						<option value="1">★</option>
						<option value="2">★★</option>
						<option value="3">★★★</option>
						<option value="4">★★★★</option>
						<option value="5">★★★★★</option>
					</select>
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary" disabled>Rate!</button> <!-- TO DO - Falta refactorizar el metodo de rating -->
				</div>
			</form:form>

		</section>
	</main>

</body>
</html>