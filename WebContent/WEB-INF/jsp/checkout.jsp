<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/sidebar.jsp" />
<c:url value="./thanks.html" var="thanks" />
<c:url var="showCart" value="/showCart.html" />
<c:if test="${!empty user }">
<p> Hello ${user.getFirstname()}</p>
</c:if>
<h3>Invoice:</h3>
 	


	<c:if test="${!empty invoice}">
<form method="get" action="${thanks}">

<br>
<c:forEach items="${in}"  var="inl">
<p>${inl.getProduct().getCode()}  -------  ${inl.getQuantity()} -------- ${ inl.calculateItemTotal()} <br>
 </c:forEach>
Total Price: ${invoice.getTotalAmount() }
<br>
<input type="submit" value="Finish">
</form>  	
<br>

</c:if>
</body>
</html>