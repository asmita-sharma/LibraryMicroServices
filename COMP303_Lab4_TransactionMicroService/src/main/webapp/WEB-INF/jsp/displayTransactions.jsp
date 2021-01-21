<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Transaction List</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <table class="table table-striped">
   <thead class="thead-dark">
    <th scope="row">Transaction ID</th>
    <th scope="row">Customer ID</th>
    <th scope="row">Book ID</th>
    <th scope="row">Transaction Date</th>
    <th scope="row">Transaction Type</th>
    <th scope="row">Update</th>
    <th scope="row">Delete</th>
   </thead>
   <tbody>
    <c:forEach items="${articleList }" var="article" >
     <tr>
      <td>${article.transactionId }</td>
      <td>${article.customerId }</td>
      <td>${article.bookId }</td>   
      <td>${article.trxnDate }</td>
      <td>${article.trxnType }</td>
      <td>
       <spring:url value="/editTransaction/${article.transactionId}" var="editURL" />
       <a class="btn btn-info" href="${editURL}" role="button" >Update</a>
      </td>
      <td>
       <spring:url value="/deleteTransaction/${article.transactionId}" var="deleteURL" />
       <a class="btn btn-danger" href="${deleteURL}" role="button" >Delete</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/addNewTransaction/" var="addURL" />
  <a class="btn btn-success" href="${addURL}" role="button" >Add New Transaction</a>
 </div>
</body>
</html>