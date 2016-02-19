<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/sidebar.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
	<c:if test="${!empty user }">
<p> Hello ${user.getFirstname()}</p>
</c:if>
	<h1>Welcome to the Music Shop System</h1>
	<h2>Get the Music of your choice!</h2>
	
</section>
<jsp:include page="/includes/footer.jsp" />

