<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Survey Results</title>
</head>
<body>

	<h2>Survey Results</h2>

	<div class="grid">
		<c:forEach items="${parksSurveyCount}" var="park">
			<figure class="effect-marley">
				<a href="${detailPageURL}"><img alt="National Park Picture"
					src="<c:url value="/img/parks/${park.imageName}" />"></a>
				<figcaption>
					<h2><c:out value="${park.name}" /><br> <span> NationalPark</span>
					</h2>
					<p>
						There are <strong><c:out value="${park.surveyCount}" /></strong> surveys for this
						park. Better start planning a trip to this
						well-loved national park!
					</p>
				</figcaption>
			</figure>

		</c:forEach>
	</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
</html>