<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homeeee</title>
<%@ include file="../../layouts/headCDN.html"  %>
</head>
<body>
	<%@ include file="../../layouts/navbar.html"%>
	
	<section class="container mx-auto my-5">
		<h1 class="fw-bold">Welcome, <c:out value="${session}"></c:out></h1>
	</section>
	
	<main>
		<section class="container mx-auto mb-4">
			<h2>TV Shows</h2>
			<table class="table table-dark table-hover">
				<thead class="">
					<tr>
						<th scope="col">Shows</th>
						<th scope="col">Network</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${shows}" var="show">
					<tr>
						<td><a class="" href="/showDetails?showId=${show.getId()}"><c:out value="${show.getShowTitle()}"></c:out></a></td>
						<td><c:out value="${show.getShowNetwork()}"></c:out></td>
					</tr>
				</c:forEach>


				</tbody>
			</table>
		</section>
	</main>

</body>
</html>