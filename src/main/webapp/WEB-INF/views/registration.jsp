<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
 <%@ include file="../layouts/headCDN.html"%>
</head>
<body>
	<%@ include file="../layouts/navbar.html"%>
	
	
	<main>
		<form:form class="container mx-auto my-5" method="POST" action="/register" modelAttribute="Users">

			<div class="mb-3">
				<label for="inputUsername" class="form-label">Username</label>
				<input name="username" type="text" class="form-control" id="inputUsername" required>
			</div>

			<div class="mb-3">
				<label for="inputEmailUser" class="form-label">Email address</label>
				<input name="email" type="email" class="form-control" id="inputEmailUser" aria-describedby="emailHelp" required>
			</div>

			<div class="mb-3">
				<label for="inputPasswordUser" class="form-label">Password</label>
				<input name="password" type="password" class="form-control" id="inputPasswordUser" required>
			</div>

			<div class="mb-3">
				<label for="inputPasswordConfirmUser" class="form-label">Password confirm</label>
				<input name="passwordConfirmation" type="password" class="form-control" id="inputPasswordConfirmUser" required>
			</div>

			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1" required>
				<label class="form-check-label" for="exampleCheck1">Check me out</label>
			</div>

			<button type="submit" class="btn btn-primary">Sign up</button>

		</form:form>
	</main>

</body>
</html>