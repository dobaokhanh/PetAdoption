<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../../resources/bootstrap/bootstrap.jsp"%>
<title>Send Pet</title>
</head>
<body>
	<%@ include file="../share/navbar.jsp"%>
	<div class="container">
		<div class="col-sm-8">
			<form:form action="addNewPet" modelAttribute="pet" method="POST"
				class="form-group">
				<form:hidden path="id"/>
				<div class="form-group">
					<label>Name</label>
					<form:input path="name" class="form-control"
						placeholder="Enter pet name" />
					<form:errors path="name" style="color: red"/>
				</div>
				
				<div class="form-group">
					<label>Age</label>
					<form:input path="age" class="form-control"
						placeholder="Age" />
					<form:errors path="age" style="color: red"/>
				</div>
				
				<div class="form-group">
					<label>Breeds</label>
					<form:select path="breed">
						<form:options items="${breedOptions }"/>
					</form:select>
					<form:errors path="breed" style="color: red"/>
				</div>
				
				<div class="form-group">
					<label>Describe</label>
					<form:textarea path="describe" class="form-control" placeholder="Describe"/>
					<form:errors path="describe" style="color: red"/>
				</div>
				
				<div class="form-group">
					<label>Adopted</label>
					<form:select path="adopted">
						<form:option value="false">No</form:option>
						<form:option value="true">Yes</form:option>
					</form:select>
				</div>
				
				<input type="submit" value="Submit">
			</form:form>
		</div>
	</div>
</body>
</html>