<%-- Note: we can't usefully put the page directive with the desired character
    encoding (UTF-8) here in this file even though we want the same one in all 
    pages because the JSP spec says "Only the character encoding specified for 
    the requested page is used; the encodings of files included via the include 
    directive are not taken into consideration." (JSP.4.2 Response Char Encoding)
    JSP will generate a HTML <meta> tag for UTF-8 from this info. 
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>Music Shop</title>
<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
  <link href="../assets/css/bootstrap.css" rel="stylesheet">
    
    <script src="../assets/js/html5shiv.js"></script>
   
    <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
 <link rel="shortcut icon" href="<c:url value='/images/pizzapie.ico'/>">
<body>
  <c:url var="welcomeURL" value="/welcome.html" />
       
        <c:url var="catalogWelcomeURL" value="/UserCatalog.html" />
        <c:url var="viewCartURL" value="/showCart.html" />
         <c:url var="logoutURL" value="/thanks.html" />
         <c:url var="register" value="/register.html" />
	  <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">The Music Shop</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"> <a href="${welcomeURL}">Home</a></li>
              <li><a href="${catalogWelcomeURL}">Browse Catalog</a></li>
              <li><a href="${viewCartURL}">View Cart</a></li>
              <li><a href="${register}">Register</a></li>
              <li><a href="${logoutURL}">Logout</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

</body>
	
	