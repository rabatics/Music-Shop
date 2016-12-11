<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
    
    <script src="../assets/js/html5shiv.js "></script>
   
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-responsive.css">

<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/header.jsp" />
<body>
<p></p><p></p><p></p><p></p><p></p>

<c:url value="AddToCart.html" var="AddToCart" />
<c:url var="play" value="/playSong.html" />
<c:url var="showCart" value="/showCart.html" />
<div class="container">
<div class="hero-unit">
<c:if test="${!empty user }">
<p> Hello ${user.getFirstname()}</p>
</c:if>
<h3>Product Details:</h3>
 	


	<c:if test="${!empty product}">

<form method="get" action="${play}">
${product.getCode()} <br>

 <div class="row">
<c:forEach items="${product.getTracks()}" var="track">

	<div class="span4">
	<img src="${pageContext.request.contextPath}/images/music.png" height="100" width="100"><br>
 <input type="radio" name="trackname" value="${track.getTrackNumber()}" required />   ${track.getTitle()}</div>
	
	</c:forEach>
	</div>
<button class="btn btn-primary" type="submit" >Play <span class="glyphicon glyphicon-volume-up" aria-hidden="true"></span></button>
</form>  	
<br>
<form method="get" action="${AddToCart}">
Quantity:<input class="form-control" type="number" name="quantity" value=1 min="1" max="50" required>
<input class="btn btn-primary" type="submit" value="Add ${product.getCode()}  To Cart">
</form>  	
<br>

</c:if>
</div>
</div>
</body>
</html>