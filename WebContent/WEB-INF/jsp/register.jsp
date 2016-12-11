<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Register</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
    
    <script src="../assets/js/html5shiv.js "></script>
   
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-responsive.css">

<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/header.jsp" />
<body>
<div class="container">
<div class="hero-unit">


<c:url value="/registerUser.html" var="catalog" />

<p></p><p></p><p></p><p></p><p></p>
<h1>Registration :</h1>

<c:if test="${!empty user }">
<p> Hello ${user.getFirstname()}</p>
<p>You are registered with us with the email address : ${user.getEmailAddress()}</p>
</c:if>
<c:if test="${empty user }">
<p>To register for our downloads, enter your name and email
   address below. Then, click on the Submit button.</p>

<form action="${catalog}" method="get">
       <c:if test="${flag==0}">
<input type="hidden" name="red" value="0" />
</c:if>
       
       <c:if test="${flag==1}">
<input type="hidden" name="red" value="1" />
</c:if>
 <c:if test="${flag==2}">
<input type="hidden" name="red" value="2" />
</c:if>
    <label class="pad_top">Email:</label>
    <input type="email" name="email" value="" required><br>
    <label class="pad_top">First Name:</label>
    <input type="text" name="firstName" value="" required><br>
    <label class="pad_top">Last Name:</label>
    <input type="text" name="lastName" value="" required><br>        
    <label>&nbsp;</label>
    <input class="btn btn-primary" type="submit" value="Register">
</form>
</c:if>
</div></div>
</body>

</html>
