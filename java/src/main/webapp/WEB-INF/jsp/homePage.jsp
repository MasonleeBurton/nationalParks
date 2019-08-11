<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<c:url var="detailPageURL" value="/detailPage">
		<c:param name="parkCode">${park.parkCode}</c:param>
	</c:url>
	<div class="grid">
		<c:forEach items="${nationalParkList}" var="park">

			<figure class="effect-marley homeImg">
				<a href="${detailPageURL}${park.parkCode}"><img class = "homeImg" alt="National Park Picture"
					src="<c:url value="/img/parks/${park.imageName}" />"></a>
				<figcaption>
					<h2><c:out value="${park.name}" /><br> <span> NationalPark</span>
					</h2>
					<p><em class = "standOut"><c:out value="${park.state}" /></em><br><c:out value="${park.parkDescription}" /></p> 
	
				</figcaption>
				
			</figure>

		</c:forEach>
	</div>

</html>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
