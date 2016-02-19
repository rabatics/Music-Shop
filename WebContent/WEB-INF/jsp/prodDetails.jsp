<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/sidebar.jsp" />
<c:url value="AddToCart.html" var="AddToCart" />
<c:url var="play" value="/playSong.html" />
<c:url var="showCart" value="/showCart.html" />
<c:if test="${!empty user }">
<p> Hello ${user.getFirstname()}</p>
</c:if>
<h3>Product Details:</h3>
 	


	<c:if test="${!empty product}">

<form method="get" action="${play}">
${product.getCode()} <br>
<table>
<c:forEach items="${product.getTracks()}" var="track">

	<tr><td>
 <input type="radio" name="trackname" value="${track.getTrackNumber()}" required /></td><td>   ${track.getTitle()}</td></tr>
	
	</c:forEach>
	</table>
<input type="submit" value="Play Song">
</form>  	
<br>
<form method="get" action="${AddToCart}">
Quantity:<input type="number" name="quantity" value=1 min="1" max="50" required>
<input type="submit" value="Add ${product.getCode()}  To Cart">
</form>  	
<br>

</c:if>
</body>
</html>