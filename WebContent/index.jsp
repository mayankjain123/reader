<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>the readER</title>
	
	<!-- links CSS to this JSP page -->
	<link rel="stylesheet" href="styleMe.css">
	
	<!-- JavaScript to handle changes -->
	<script src="MyJavaScript.js" type="text/javascript"></script>
	
</head>

<body>

	<%@ include file="header.jsp" %>
	
	<%@ include file="userNavigation.jsp" %>	

	<!-- section is divided into two vertical parts, options & siteContent -->
	<div class="section">
		
		<!-- options for navigating through different pages -->
		<%@ include file="siteNavigation.jsp" %>		
		
		<!-- actual site content is hold here -->
		<div class="siteContent">
			
			  <object width="800" height="400" data="IndexInfo.jsp" id="bodyInformation"></object>  
			      
		</div>
		
	</div>
	
	<%@ include file="footer.jsp" %>

</body>

</html>


<!-- 

	<p>You're in the right place. Tell us what titles or genres you've enjoyed in the past, and we'll give you surprisingly insightful recommendations.</p>			
				<br><br><br>
				<img alt="" src="home1.jpg">
				<img alt="" src="home2.jpg">
				<img alt="" src="home3.jpg">
				<img alt="" src="home4.jpg">
				<img alt="" src="home5.jpg">
			

 -->
