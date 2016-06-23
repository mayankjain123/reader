<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order List</title>

<!-- links CSS to this HTML page -->
<link rel="stylesheet" href="styleMe.css">

<!-- JavaScript to handle changes -->
<script src="MyJavaScript.js" type="text/javascript"></script>

<script type="text/javascript">
	
	function setValue(c){
		//document.getElementById("textInfo").innerHTML = c;
		document.getElementById("textInfo").value = c;
		document.getElementById("selectedOrderItem").submit();
	}

</script>

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

			<h4>All Orders</h4>
			
			
			
			<table>
				<tr>
					<th><h4>Order Number</h4></th>
					<th><h4>Product</h4></th>
					<th><h4>Category</h4></th>
					<th><h4>Price</h4></th>
				</tr>
				
				<c:set var="count" value="0" scope="page" />
				<c:forEach var="item" items="${theOrders}">
					<tr>
						<td> <a onclick="setValue(${count})" href="#"> ${item.productCode} </a> </td>
						<td>${item.productName}</td>
						<td>${item.category}</td>
						<td>${item.price}</td>
					</tr>
					<c:set var="count" value="${count + 1}" scope="page" />
				</c:forEach>
			</table>
	
			<form id="selectedOrderItem" name="selectedOrderItem" action="selectedOrderItem" method="post">
				<input type="hidden" name="textInfo" id="textInfo" > 
			</form>
			
			<!-- <p id="textInfo" name="textInfo"></p> -->
			
		</div>

	</div>

	<%@ include file="footer.jsp"%>


</body>

</html>
