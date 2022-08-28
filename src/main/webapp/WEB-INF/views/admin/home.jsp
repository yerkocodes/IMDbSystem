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
	
	<section class="container mx-auto">
		<h1>HOME ADMIN <c:out value="${session}"></c:out> </h1>
	</section>
</body>
</html>