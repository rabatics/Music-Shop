<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/sidebar.jsp" />
<c:url value="prodDetails.html" var="productDisplay" />
<c:url var="showCart" value="/showCart.html" />
<c:if test="${!empty user }">
<p> Hello ${user.getFirstname()}</p>
</c:if>
<h3>Products Available:</h3>
 	

Enter the product code to see the product details.
	
<form method="get" action="${productDisplay}">
<table>
	<c:forEach items="${product}" var="curprod">
	<tr><td>
<input type="radio" name="productCode" value="${curprod.getCode()}" required /></td><td> &nbsp; &nbsp; &nbsp;   ${curprod.getCode()}  
     </td><td> &nbsp; &nbsp; &nbsp; &nbsp;     ${curprod.getDescription()}  </td></tr>
	
	</c:forEach>
	</table>
<br>
<input type="submit" value="Get Details">
</form>  	
<br>


</body>
</html>