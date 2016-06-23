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
						<th><h3>Your Cart</h3></th>
						<th><h4>To remove and item, change the quantity to zero.</h4></th>
					</tr>
				</table>


			</div>



			<div class="cartItems">

				<br>



				<table style="width: 100%">
					<tr>
						<th class="algLef">Item</th>
						<th class="algRgt">Price</th>
						<th class="algRgt">Quantity</th>
						<th class="algRgt">Total</th>
					</tr>
					<tr>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
					</tr>



					<c:set var="count" value="0" scope="page" />
					<c:forEach items="${productInCart}" var="product">

						<tr>
							<td class="algLef">${productInCart[count].productName}</td>
							<td class="algRgt">$ ${productInCart[count].price}</td>

							<td><input type="text" id="itemQuantity" name="dummy"
								value="${productInCart[count].countItems}"></td>

							<td class="algRgt">${productInCart[count].price}X
								${productInCart[count].countItems}</td>

							<c:set var="count" value="${count + 1}" scope="page" />
						</tr>

					</c:forEach>


					<tr>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
						<td><hr></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td class="algRgt"><h4>Total</h4></td>
						<td class="algRgt">$ ${totalAmount}</td>
					</tr>


				</table>

			</div>

			<div class="cartButtons">
				<!--  
					<button type="button" onclick="toCart();">Update Cart</button>   <br><br>
					<button type="button" onclick="afterCheckout();">Checkout</button>  
				-->

				<form id="addToCart1" name="addToCart" action="addToCart" method="post">
				
					<input type="button" value="Update Cart" onclick="getElementById('addToCart1').submit();" /> 
					
					<input type="hidden" name="action" value="Update Cart" />
					
			    </form> 
			    
				<br> <br>
				
				<form id="checkoutchoice" name="checkoutchoice" action="checkoutchoice" method="post">
					
					<input type="button" value="Check Out" onclick="getElementById('checkoutchoice').submit();" /> 
						
				    <input type="hidden" name="action" value="CheckOut" />

				</form>


			</div>

			<!-- hidden element -->

			<input hidden="true" name="hiddenCart" id='hiddenCart' value="">


		</div>

	</div>

	<%@ include file="footer.jsp"%>



</body>

</html>
