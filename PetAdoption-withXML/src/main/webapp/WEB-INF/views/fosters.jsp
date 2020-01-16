<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fosters</title>
	<%@ include file="../resources/bootstrap/bootstrap.jsp"%>
</head>
<body>
	<%@ include file="./share/navbar.jsp"%>

	<div class="container">
		<div class="col-offset-1">
			<h4>Foster</h4>
		</div>
		
		<input type="button" value="Add Foster" 
			onClick="window.location.href='showAddForm'; return false;" /> 
		
		<div class="col-sm-10">
			<table class="table table-bordered">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Address</th>
						<th scope="col">City</th>
						<th scope="col">Phone</th>
						<th scope="col">Email</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>

				<tbody>
					<!-- loop over and print out owners -->
					<c:if test="${not empty fosters }">
						<c:forEach var="tempFoster" items="${fosters }">

							<c:url var="updateLink" value="/fosters/showUpdateForm">
								<c:param name="fosterId" value="${tempFoster.id}"></c:param>
							</c:url>

							<c:url var="deleteLink" value="/fosters/delete">
								<c:param name="fosterId" value="${tempFoster.id}"></c:param>
							</c:url>

							<tr>
								<td>${tempFoster.name}</td>
								<td>${tempFoster.address}</td>
								<td>${tempFoster.city}</td>
								<td>${tempFoster.phone }</td>
								<td>${tempFoster.email }</td>
								<td>
									<!-- display the update form --> 
									<a href="${updateLink}">Update</a>
									 
									| 
									
									<!-- delete customer --> 
									<a href="${deleteLink}"
									onClick="if (!(confirm('Are you sure you want to delete this foster ?'))) return false;">Delete
								</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>