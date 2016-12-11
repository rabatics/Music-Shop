<jsp:include page="/includes/header.jsp" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
    
    <script src="../assets/js/html5shiv.js "></script>
   
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-responsive.css">

<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
<div class="hero-unit">
<section>
<c:if test="${!empty user }">
<p></p><p></p><p></p><p></p><p></p>	
<p> Hello ${user.getFirstname()}</p>
</c:if>
</section>


<section >

	
	<h1>Welcome to the Music Shop System</h1>
	<h2>Get the Music of your choice!</h2>
	
</section>
</div>
</div>
<jsp:include page="/includes/footer.jsp" />

