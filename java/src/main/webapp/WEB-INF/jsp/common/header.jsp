<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>National Park Geek</title>
<c:url value="/css/site.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
<link
	href='https://fonts.googleapis.com/css?family=Righteous|Playfair+Display+SC:400,900'
	rel='stylesheet' type='text/css'>
</head>

<div class="header">
	<div class="sides">
		<img class="sides" alt="NPGeeksLogo"
			src="<c:url value="/img/logo.png" />">
	</div>
	<div class="sides">
		
		<div class="simple-menu">
			<ul class="menu-list">
				<li class="menu-list"><a href = "/m3-java-capstone">Home</a></li>
				<li class="menu-list"><a href = "/m3-java-capstone/surveyInput">Survey</a></li>
				<!-- <li class="menu-list"><a href = "/m3-java-capstone/surveySuccessful">Results</a></li> -->
			</ul>
		</div>
	</div>
	<div class="info">
		<h4>
			<a href="#category"></a>Explore Our
		</h4>
		<h1>NATIONAL PARKS</h1>
		<div class="meta">
			<img class="author" alt="NPGeeksLogo"
			src="<c:url value="/img/geek.png" />"><br> Brought To You By <a href="/m3-java-capstone">NPGeeks</a>
		</div>
	</div>
</div>
<!-- <section class="content"></section> -->