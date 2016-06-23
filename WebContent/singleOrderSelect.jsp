<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cart</title>

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

			<div class="cartNotice">

				<table style="width: 130%">
					<tr>
						<th><h3>ITEM DETAILS</h3></th>
					</tr>
					<tr>
						<td><h4>Ship To:</h4></td>
					</tr>
					<tr>
						<td>${userLogedIn.firstName}    ${userLogedIn.lastName}</td>
					</tr>
					<tr>
						<td>${userLogedIn.address1}</td>
					</tr>
					<tr>
						<td>${userLogedIn.address2}</td>
					</tr>
					<tr>
						<td>${userLogedIn.city},${userLogedIn.state},
							${userLogedIn.country}</td>
					</tr>

				</table>

			</div>

			<div class="cartItems">

				<br>

				<table style="width: 100%">
					<tr>
						<th class="algLef">Item</th>
						<th class="algRgt">Price</th>
						<th class="algRgt">Category</th>
						<th class="algRgt">Price</th>
					</tr>
					<tr>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
					</tr>

					<tr>
						<td class="algLef">${productSelected.productName}</td>
						<td class="algRgt">$ ${productSelected.price}</td>
						<td class="algRgt">${productSelected.category}</td>
						<td class="algRgt">${productSelected.price}</td>
					</tr>

					<tr>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
					</tr>

				</table>


			</div>

		</div>

	</div>

	<%@ include file="footer.jsp"%>


</body>

</html>
