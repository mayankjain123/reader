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

			<form id="login" name="login" action="login"
				method="post">

				<input type="button" value="Login As Existing User" onclick="getElementById('login').submit();"> <input
					type="hidden" name="action" value="login">

			</form>

			<br> <br>

			<form id="registration" name="registration" action="registration" method="post">

				<input type="button" value="Create New User" onclick="getElementById('registration').submit();"> <input
					type="hidden" name="action" value="registration">

			</form>


		</div>

	</div>

	<%@ include file="footer.jsp"%>

</body>


</html>