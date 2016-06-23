<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>catalog</title>

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

			<!-- actual site content (here catalog information) -->
			<div class="CatalogInfo" id='CatalogInfo'>

				<h3>Category :</h3>

				<select onchange="changecatalog();" id='changeCatalog'>

					<c:set var="count" value="0" scope="page" />
					<c:forEach items="${categoryName}" var="product">
						<option value="${categoryName[count]}">
							<c:out value="${categoryName[count]}" />
						</option>
						<c:set var="count" value="${count + 1}" scope="page" />

						<!-- <option value="Fiction">Fiction</option> 
  				<option value="Art">Art</option> -->

					</c:forEach>

				</select> <br> <br>



				<table style="width: 100%">
					<tr>
						<th></th>
						<th>Product</th>
						<th>Category</th>
						<th>Price</th>
					</tr>
					<tr>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
					</tr>

					<c:set var="count1" value="0" scope="page" />
					<c:forEach items="${allProduct}" var="product">

						<tr id="${allProduct[count1].productCode}">
							<td><img alt="" src="${allProduct[count1].imageURL}"></td>

							<form id="${allProduct[count1].productName}" action="CatalogData"
								method="get">
								<td><a id='${allProduct[count1].productCode}'
									onclick="getElementById('${allProduct[count1].productName}').submit();">

										<input type="hidden" name="productCode"
										value="${allProduct[count1].productCode}" /> <c:out
											value="${allProduct[count1].productName}" />
								</a></td>
							</form>

							<td><c:out value="${allProduct[count1].category}" /></td>
							<td>$ <c:out value="${allProduct[count1].price}" />
							</td>
						</tr>
						<c:set var="count1" value="${count1 + 1}" scope="page" />

					</c:forEach>

					<tr>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
					</tr>
				</table>

				<!-- hidden element -->
				<input hidden="true" name="hidden" id='hidden' value="">

			</div>

		</div>

	</div>

	<%@ include file="footer.jsp"%>


</body>

</html>
