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
<jsp:include page="/includes/sidebar.jsp" />
<c:url value="/removeCart.html" var="RemoveCart" />
<c:url var="showCart" value="/showCart.html" />
<c:url var="checkout" value="/checkout.html" />
<c:if test="${!empty user }">
<p> Hello ${user.getFirstname()}</p>
</c:if>
<h3>Cart Details:</h3>
 	


	<c:if test="${!empty cart}">
<form method="get" action="${RemoveCart}">

<br>
<c:forEach items="${cart.getItems()}"  var="i">
<input type="radio" name="remove" value="${i.getProduct().getCode()} " required />${i.getProduct().getCode()}  -------  ${i.getQuantity()} -------- ${ i.calculateItemTotal()} <br>
 </c:forEach>

<br>
<input type="submit" value="Remove From Cart">
</form>  	

<form method="get" action="${checkout}">
<input type="submit" value="Checkout">
</form>
<br>

</c:if>
</body>
</html>