<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>checkout</title>

<!-- links CSS to this HTML page -->
<link rel="stylesheet" href="styleMe.css">

<!-- JavaScript to handle changes -->
<script src="MyJavaScript.js" type="text/javascript"></script>

</head>

<body>

	<%@ include file="header.jsp"%>

	<%@ include file="userNavigation.jsp"%>

	<!-- section is divided into two vertical parts, options & siteContent -->
	<div class="section">

		<!-- options for navigating through different pages -->
		<%@ include file="siteNavigation.jsp"%>

		<!-- actual site content is hold here -->
		<div class="siteContent">

			<br/><br/><br/>
			<h4>Select one of the following options.</h4>

			<form id="logintry" name="logintry" action="logintry"
				method="post">

				UserId :
				<input type="text" name="userId" />
						
				Password :
				<input type="password" name="userpass" />
				
				<input type="button" value="Login User" onclick="getElementById('logintry').submit();"> 
				
				<input type="hidden" name="action" value="logintry">

			</form>

			<br> <br>

		</div>

	</div>

	<%@ include file="footer.jsp"%>

</body>


</html>


