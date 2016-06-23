<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<!-- provides user specific options like signIn, orders, cart details -->
	<div class="userNavigation">
		<h3> 
			<a id="signInLink" href="CheckOutChoice.jsp" >signIn</a> |
			<a id="cartLink" href="#" >Cart</a> |
			
			<a id="myOrderLink" onclick="getElementById('userNavigation').submit();" >My Orders</a>
			
			
			<form id="userNavigation" name="userNavigation" action="userNavigation" method="post">
					<input type="hidden" name="action" value="userNavigation" />
			</form>
					
		</h3>
	</div>

