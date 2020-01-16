<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<%@ include file="./WEB-INF/resources/bootstrap/bootstrap.jsp"%>
</head>
<body>
	<%@ include file="WEB-INF/views/share/navbar.jsp"%>
	<div class="jumbotron">
		<h1 class="display-4">Pet Adoption</h1>
		<p class="lead">Let's help these poor pets find a new home. This
			web application created for the purpose that anyone is not able to
			keep their pets, you could send your pet informations and anyone is
			able to adopt the pets could help them find a new home.</p>
		<hr class="my-4">
		<p>Join us and let us know if you need help with your pets, or you
			want to see these cute pets.</p>
		<a class="btn btn-primary btn-lg"
			href="${pageContext.request.contextPath }/pets/">See Pets</a>
	</div>
</body>
</html>