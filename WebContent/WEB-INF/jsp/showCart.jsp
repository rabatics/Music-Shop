<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/header.jsp" />
<c:url value="/removeCart.html" var="RemoveCart" />
<c:url var="showCart" value="/showCart.html" />
<c:url var="checkout" value="/checkout.html" />
<p></p><p></p><p></p><p></p>
<div class="container">
<div class="hero-unit">
<c:if test="${!empty user }">
<p> Hello ${user.getFirstname()}</p>
</c:if>
<h3>Cart Details:</h3>
 	


	<c:if test="${!empty cart}">
<form method="get" action="${RemoveCart}">

<br>
 <div class="row">
<c:forEach items="${cart.getItems()}"  var="i">
	<div class="span4">
	<img src="${pageContext.request.contextPath}/images/music.png" height="100" width="100"><br>
<input type="radio" name="remove" value="${i.getProduct().getCode()} " required />${i.getProduct().getCode()} <br> ${i.getQuantity()} <br> ${ i.calculateItemTotal()} <br>
</div>
 </c:forEach>
</div>
<br>
<input class="btn btn-danger" type="submit" value="Remove From Cart">
</form>  	

<form method="get" action="${checkout}">
<input  class="btn btn-success" type="submit" value="Checkout">
</form>
<br>

</c:if>
</div>
</div>
</body>
</html>