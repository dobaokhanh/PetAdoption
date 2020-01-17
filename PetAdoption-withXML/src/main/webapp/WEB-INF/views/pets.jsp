<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pets</title>
<%@ include file="../resources/bootstrap/bootstrap.jsp"%>
</head>
<body>
	<%@ include file="./share/navbar.jsp"%>
	<div>
		<h4>Pets</h4>
	</div>
	
	<!-- button add new pet -->
	<input type="button" value="Add New Pet" 
		onClick="window.location.href='showAddForm'; return false;" />
	
	<div class="col-sm-10">
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Breed</th>
					<th scope="col">Describe</th>
					<th scope="col">Adopted</th>
					<th scope="col">Owner</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>

			<tbody>
				<c:if test="${not empty pets }">
					<!-- loop over all the pets -->
					<c:forEach var="tempPet" items="${pets }">
					
					<!-- link to show update form -->
					<c:url var="updateLink" value="/pets/showUpdateForm">
						<c:param name="petId" value="${tempPet.id}"></c:param>
					</c:url>
					
					<!-- link to delete pet -->
					<c:url var="deleteLink" value="/pets/delete">
						<c:param name="petId" value="${tempPet.id}"></c:param>
					</c:url>
					
						<tr>
							<th>${tempPet.name }</th>
							<th>${tempPet.age }</th>
							<th>${tempPet.breed }</th>
							<th>${tempPet.describe }</th>
							<th><c:if test="${tempPet.adopted == true }">Yes</c:if> <c:if
									test="${tempPet.adopted == false }">No</c:if></th>
							<th>${tempPet.owner.name }</th>
							
							<td>
									<!-- display the update form --> 
									<a href="${updateLink}">Update</a>
									 
									| 
									
									<!-- delete pet --> 
									<a href="${deleteLink}"
									onClick="if (!(confirm('Are you sure you want to delete this pet ?'))) return false;">Delete
								</a>
							</td>
							
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

</body>
</html>