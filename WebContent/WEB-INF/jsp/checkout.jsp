<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
    
    <script src="../assets/js/html5shiv.js "></script>
   
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-responsive.css">

<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
</head>
<body>
<div class="container">
<div class="hero-unit">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/header.jsp" />
<c:url value="./thanks.html" var="thanks" />
<c:url var="showCart" value="/showCart.html" />
<c:if test="${!empty user }">
<p> Hello ${user.getFirstname()}</p>
</c:if>
<h3>Invoice:</h3>
 	


	<c:if test="${!empty invoice}">
<form method="get" action="${thanks}">

<br>
<table class="table table-hover">
<tr>
<c:forEach items="${in}"  var="inl">
<td>${inl.getProduct().getCode()} </td><td> ${inl.getQuantity()} </td><td> ${ inl.calculateItemTotal()}</td> 
 </c:forEach>
 </tr>
 </table>
Total Price: ${invoice.getTotalAmount() }
<br>
<input class="btn btn-success" type="submit" value="Finish">
</form>  	
<br>

</c:if>
</div>
</div>
</body>
</html>