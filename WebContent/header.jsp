<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	
	<div class="header">
	
		<div class="nameLogo">
			<!-- contains web site name and logo -->
			<img alt="" src="logo2.png">
			<h2>the read</h2><h1>ER</h1>
		</div>
		
		<div class="pageUpdates">
			<h4 id="NotSignedIn" > ${currUsr} </h4>
			<h4 id="NavigationLink" class="NavigationLink" > ${navLink} </h4>
		</div>	
	</div>