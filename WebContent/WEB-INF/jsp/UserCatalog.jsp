<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
    
    <script src="../assets/js/html5shiv.js "></script>
   
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-responsive.css">

<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/header.jsp" />
<body>
<p></p><p></p><p></p><p></p>
<c:url value="prodDetails.html" var="productDisplay" />
<c:url var="showCart" value="/showCart.html" />
<div class="container">
<div class="hero-unit">
<c:if test="${!empty user }">
<p> Hello ${user.getFirstname()}</p>
</c:if>
<h3>Products Available:</h3>
 	

Enter the product code to see the product details.
	</div>
	
<form method="get" action="${productDisplay}">
 <div class="row">
	<c:forEach items="${product}" var="curprod">
	
        <div class="span4">
<input type="radio" name="productCode" value="${curprod.getCode()}" required /><br><img src="${pageContext.request.contextPath}/images/music.png" height="100" width="100"><br>   ${curprod.getCode()}  <br>
         ${curprod.getDescription()}  
	</div>
	
	
	</c:forEach>
	</div>
<br>
<input class="btn" type="submit" value="Get Details">
</form>  	
<br>
</div>

</body>
</html>