<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Foster</title>
</head>
<body>
<%@ include file="../share/navbar.jsp"%>
	<div class="container">
		<div class="col-sm-8">
			<form:form action="saveFoster" modelAttribute="foster" method="POST"
				class="form-group">
				<form:hidden path="id" />
				<div class="form-group">
					<label>Name</label>
					<form:input path="name" class="form-control"
						placeholder="Enter foster name" />
					<form:errors path="name" style="color: red"/>
				</div>

				<div class="form-group">
					<label>Address</label>
					<form:input path="address" class="form-control"
						placeholder="Address" />
					<form:errors path="address" style="color: red"/>
				</div>

				<div class="form-group">
					<label>City</label>
					<form:input path="city" class="form-control" placeholder="City" />
					<form:errors path="city" style="color: red"/>
				</div>

				<div class="form-group">
					<label>Phone</label>
					<form:input path="phone" class="form-control" placeholder="Phone" />
					<form:errors path="phone" style="color: red"/>
				</div>

				<div class="form-group">
					<label>Email</label>
					<form:input path="email" class="form-control" placeholder="Email" />
					<form:errors path="email" style="color: red"/>
				</div>

				<input type="submit" value="Submit">
			</form:form>
		</div>
	</div>
</body>
</html>