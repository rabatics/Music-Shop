<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside id="sidebar">
    <nav>
        <c:url var="welcomeURL" value="/welcome.html" />
       
        <c:url var="catalogWelcomeURL" value="/UserCatalog.html" />
        <c:url var="viewCartURL" value="/showCart.html" />
         <c:url var="logoutURL" value="/thanks.html" />
         <c:url var="register" value="/register.html" />
       

        <h4>Links</h4>

        <a href="${welcomeURL}">Home</a><br>
       	<a href="${catalogWelcomeURL}">Browse Catalog</a> <br>
       	 	<a href="${viewCartURL}">View Cart</a> <br> 
       	 	 	<a href="${register}">Register</a> <br> 
       	 	<a href="${logoutURL}">Logout</a> <br>
        	
    </nav>
</aside>