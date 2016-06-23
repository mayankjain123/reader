<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>userInfo</title>

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

			<form name="myForm" action="RegistrationServlet"
				onsubmit="return validateForm()" method="post">
				<table>
					<tr>
						<td colspan=2 align="center"><h3>User Details</h3></td>
					</tr>
					<tr>
						<td align="center">First Name:</td>
						<td><input type="text" name="fname" /></td>
					</tr>
					<tr>
						<td align="center">Last Name:</td>
						<td><input type="text" name="lname" /></td>
					</tr>
					<tr>
						<td align="center">Email:</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td align="center">Address 1:</td>
						<td><input type="text" name="addr1" /></td>
					</tr>
					<tr>
						<td align="center">Address 2:</td>
						<td><input type="text" name="addr2" /></td>
					</tr>
					<tr>
						<td align="center">City:</td>
						<td><input type="text" name="city" /></td>
					</tr>
					<tr>
						<td align="center">State:</td>
						<td><input type="text" name="state" /></td>
					</tr>
					<tr>
						<td align="center">Zip:</td>
						<td><input type="text" name="zip" /></td>
					</tr>
					<tr>
						<td align="center">Country:</td>
						<td><input type="text" name="country" /></td>
					</tr>
					<tr>
						<td align="center">Password:</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td align="center">Confirm Password:</td>
						<td><input type="password" name="cpassword" /></td>
					</tr>
					<tr>
						<td colspan=2 align="center"><input type="submit"
							value="Register" /></td>
					</tr>
				</table>
			</form>


		</div>

	</div>

	<%@ include file="footer.jsp"%>

</body>


</html>