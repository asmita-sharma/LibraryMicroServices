<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Add Customer</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
 
 <style type="text/css">
 .error {
    color: red;
    font-style: italic;
 </style>
 
}
 
</head>
<body>
 <div class="container">
  <spring:url value="/addCustomer" var="addURL" />
  <h2>Add Customer</h2>
  <form:form modelAttribute="customerForm" method="post" action="${addURL}" cssClass="form" >
   <form:hidden path="customerId"/>
   <div class="form-group">
    <label>Customer ID</label>
    <form:input path="customerId" cssClass="form-control" id="customerId" />
   </div>
   <div class="form-group">
    <label>First Name</label>
    <form:input path="firstName" cssClass="form-control" id="firstName" />
    <form:errors path="firstName" cssClass="error"/>
   </div>
    <div class="form-group">
    <label>Last Name</label>
    <form:input path="lastName" cssClass="form-control" id="lastName" />
    <form:errors path="lastName" cssClass="error"/>
   </div>
    <div class="form-group">
    <label>Address</label>
    <form:input path="address" cssClass="form-control" id="address" />
    <form:errors path="address" cssClass="error"/>
   </div>
    <div class="form-group">
    <label>Phone</label>
    <form:input path="phone" cssClass="form-control" id="phone" />
    <form:errors path="phone" cssClass="error"/>
   </div>
    <div class="form-group">
    <label>Email ID</label>
    <form:input path="emailId" cssClass="form-control" id="emailId" />
    <form:errors path="emailId" cssClass="error"/>
   </div>
   <button type="submit" class="btn btn-success">Add Customer</button>
  </form:form>
  
 </div>
</body>
</html>