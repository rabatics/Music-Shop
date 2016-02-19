<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Playing Song</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/sidebar.jsp" />

<c:if test="${!empty user }">
<p> Hello ${user.getFirstname()}</p>
</c:if>
<section>
<audio controls>
 <source src="sound/${product.getCode()}/${track}" type="audio/mpeg">
</audio>
</section>



</body>
</html>