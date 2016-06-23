<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


	<div class="siteNavigation">		
			
				<!--<a class="homeLink" id='homeLink' onclick="indexUpdate();" >Home</a> <br>
				  <a id='catalogLink' onclick="catalogUpdate();" >Catalog</a> <br>   
				<a href="#" >About</a> <br>
			    <a href="#" >Contact Us</a> <br> -->
			    
			    
			    	<ul>
			    		
			    		<li> <a class="homeLink" id='homeLink' onclick="indexUpdate();" > <h3>Home</h3> </a> </li>
            			<form id="ct" action="CatalogData" method="get">
            				<li> <a id='catalogLink' onclick="getElementById('ct').submit();"> <input type="hidden" name="action" value="catalog"/> <h3>Catalog</h3> </a></li>
            			</form>
            			
            			<form id="aboutUs" action="aboutUs" method="get">
            				<li> <a href="aboutUs.jsp" > <h3>About</h3> </a> </li>
            			</form>
            			
            			<form id="contactUs" action="contactUs" method="get">
            				<li> <a id='contactUs' onclick="getElementById('contactUs').submit();"> <h3>Contact Us</h3> </a> </li>
            			</form>
            			
			    	</ul>
			    
			    
			
		</div>
		