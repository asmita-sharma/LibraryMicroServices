<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Add Transaction</title>
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
  <spring:url value="/addTransaction" var="addURL" />
  <h2>Add Transaction</h2>
  <form:form modelAttribute="transactionForm" method="post" action="${addURL}" cssClass="form" >
   <form:hidden path="transactionId"/>
   <div class="form-group">
    <label>Transaction ID</label>
    <form:input path="transactionId" cssClass="form-control" id="transactionId" />
   </div>
   <div class="form-group">
    <label>Customer ID</label>
    <form:input path="customerId" cssClass="form-control" id="customerId" />
    <form:errors path="customerId" cssClass="error"/>
   </div>
    <div class="form-group">
    <label>Book ID</label>
    <form:input path="bookId" cssClass="form-control" id="bookId" />
    <form:errors path="bookId" cssClass="error"/>
   </div>
    <div class="form-group">
    <label>Transaction Date</label>
    <form:input path="trxnDate" cssClass="form-control" id="trxnDate" />
    <form:errors path="trxnDate" cssClass="error"/>
   </div>
    <div class="form-group">
    <label>Transaction Type</label>
    <form:input path="trxnType" cssClass="form-control" id="trxnType" />
    <form:errors path="trxnType" cssClass="error"/>
   </div>
   <button type="submit" class="btn btn-success">Add Transaction</button>
  </form:form>
  
 </div>
</body>
</html>