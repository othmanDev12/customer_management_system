<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit Customer</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
	<style type="text/css">
	  .error {
	     color: red;
	  }
	</style>
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
	     <div class="col-md-4" align="center">
	         <h4>Save Customer</h4>
	     </div> 
	   </div>
	</div>
	
	
	<div class="container">
	   <div class="row justify-content-center">
	      <div class="col-md-4">
	         <form:form action="processCustomerForm" modelAttribute="customer" method="post">
	           <form:hidden path="id"/>
	              <div class="form-group">
	                <label for="firstName">FirstName: </label>
	                <form:input path="firstName" class="form-control"/>
	                <form:errors path="firstName" cssClass="error" />
	              </div>
	              <div class="form-group">
	                <label for="lastName">LastName: </label>
	                <form:input path="lastName" class="form-control"/>
	                <form:errors path="lastName" cssClass="error" />
	              </div>
	              <div class="form-group">
	                <label for="email">email: </label>
	                <form:input path="email" class="form-control"/>
	                <form:errors path="email" cssClass="error" />
	              </div>
	              <div align="center">
	                 <button class="btn btn-primary" type="submit">Save</button>
	                 <button class="btn btn-danger" type="button" onClick="window.location.href='list'">Cancel</button>
	              </div>
	          </form:form>
	      </div>
	   </div>
	</div>
</body>
</html>