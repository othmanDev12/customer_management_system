<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>List of Customers</title>
</head>
<body>

	<div id="container ">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="mb-4 mt-2">
					<h2>CRM - Customer Relationship Manger</h2>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container">
	   <div class="row justify-content-center">
	     <div class="col-md-8">
	        <button class="btn btn-warning btn-lg mb-3 mt-2" onClick="window.location.href='add-customer-showform'">Create Customer</button>
	     </div>
	   </div>
	</div>
	

	<div id="data">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">First Name</th>
								<th scope="col">Last Name</th>
								<th scope="col">Email</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<c:forEach var="customer" items="${customers}">
						   <c:url var="customerParams" value="/customers/showUpdateForm">
						        <c:param name="itemId" value="${customer.id }"></c:param>
						   </c:url>
						   
					       <c:url var="customerDelete" value="/customers/delete">
						        <c:param name="customerId" value="${customer.id }"></c:param>
						   </c:url>
							<tr>
								<td>${customer.firstName }</td>
								<td>${customer.lastName }</td>
								<td>${customer.email }</td>
								<td>
								  <button class="btn btn-warning" >
								     <a href="${customerParams}">Update</a>
								   </button>
								   <button class="btn btn-danger">
								      <a href="${customerDelete}" onclick="if(!(confirm('are you sure that you want to delete this customer'))) return false">Delete</a>
								   </button>
								</td>
							</tr>
							<tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>