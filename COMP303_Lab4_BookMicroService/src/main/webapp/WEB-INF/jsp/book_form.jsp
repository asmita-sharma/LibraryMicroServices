<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Add Book</title>
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
  <spring:url value="/addBook" var="addURL" />
  <h2>Add Book</h2>
  <form:form modelAttribute="bookForm" method="post" action="${addURL}" cssClass="form" >
   <form:hidden path="bookId"/>
   <div class="form-group">
    <label>Book ID</label>
    <form:input path="bookId" cssClass="form-control" id="bookId" />
   </div>
   <div class="form-group">
    <label>Title</label>
    <form:input path="title" cssClass="form-control" id="title" />
    <form:errors path="title" cssClass="error"/>
   </div>
    <div class="form-group">
    <label>Author's First Name</label>
    <form:input path="authorFirstName" cssClass="form-control" id="authorFirstName" />
    <form:errors path="authorFirstName" cssClass="error"/>
   </div>
    <div class="form-group">
    <label>Author's Last Name</label>
    <form:input path="authorLastName" cssClass="form-control" id="authorLastName" />
    <form:errors path="authorLastName" cssClass="error"/>
   </div>
    <div class="form-group">
    <label>Rating</label>
    <form:input path="rating" cssClass="form-control" id="rating" />
    <form:errors path="rating" cssClass="error"/>
   </div>
   <button type="submit" class="btn btn-success">Add Book</button>
  </form:form>
  
 </div>
</body>
</html>