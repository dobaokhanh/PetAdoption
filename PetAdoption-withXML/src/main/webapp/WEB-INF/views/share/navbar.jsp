<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../../resources/bootstrap/bootstrap.jsp"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath }/">Pet
					Adoption</a>
			</div>
			<ul class=" navbar-nav navbar-right">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/"> <i
						class="fas fa-home"></i> Home
				</a></li>

				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/owners/"> <i
						class="fas fa-user"></i> Owners
				</a></li>

				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/pets/"> <i
						class="fas fa-paw"></i> Pets
				</a></li>
				
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/fosters/"> <i
						class="fas fa-user"></i> Fosters
				</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>