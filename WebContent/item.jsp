<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>item</title>

<!-- links CSS to this HTML page -->
<link rel="stylesheet" href="styleMe.css">

<!-- JavaScript to handle changes -->
<script type="text/javascript">
	function toCartFromItem() {
		document.getElementsByName("hiddenItem")[0].setAttribute('data',
				'cart.jsp');
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

			<div class="item">

				<div class="itemImg">
					<img alt="" src="${SingleProduct.imageURL}">
				</div>

				<div class="itemInfor">

					<h3>Name: ${SingleProduct.productName}</h3>
					<h4>Category: ${SingleProduct.category}</h4>
					<h4>Price: $ ${SingleProduct.price}</h4>

				</div>

			</div>

			<div class="itemDescription">
				<!-- button   <button type="button" onclick="toCartFromItem();">Add to Cart</button> -->


				<form id="addToCart" name="addToCart" action="addToCart"
					method="post">
					<input type="button" id="addButton" value="Add To Cart"
						onclick="getElementById('addToCart').submit();" /> <input
						type="hidden" name="action" value="addToCart" /> <input
						type="hidden" name="product" value="${SingleProduct.productCode}" />
				</form>

				<!-- description -->
				<h4>Description: ${SingleProduct.description}</h4>
			</div>

			<!-- hidden element -->
			<input hidden="true" name="hiddenItem" id='hiddenItem' value="">


		</div>

	</div>

	<%@ include file="footer.jsp"%>

</body>

</html>


