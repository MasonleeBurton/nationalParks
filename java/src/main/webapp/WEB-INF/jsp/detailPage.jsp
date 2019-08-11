<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE>
<html>
<head>

<title></title>
</head>
<body>

<div class="grid" id="surveyForm">
	<c:url var="temperatureUrl" value="/detailPage" />
	<form:form action="${temperatureUrl}" method="POST">
		<div class = "button">
			<label for="temperatureIndicator">Change Temperature Setting: &nbsp;</label>
			<select name="temperatureIndicator">
				<option value="F">Fahrenheit</option>
				<option value="C">Celsius</option>
			</select> &nbsp; &nbsp;
			<input type="hidden" name="parkCode" value="${park.parkCode}" />
			<div class="button">
				<input type="submit" value="Submit"></input>
			</div>
			</div>
	</form:form>
	</div>
	<h2 class="detailTitle">
		<c:out value="${park.name}" />
		&nbsp;| &nbsp; <span> NationalPark</span>
	</h2>
	<div class="grid">
		<figure class="effect-marley">
			<img alt="Product Image"
				src='<c:url value="/img/parks/${park.imageName}"></c:url>' />
			<figcaption class="quote">
				<h2 class="quote">
					<em class="topQuote">&#8220</em> <br>
					<c:out value="${park.inspirationalQuote}" />
					<em class="bottomQuote">&#8221</em> <br> <br> --<span><c:out
							value="${park.inspirationalQuoteSource}" /></span>
				</h2>
			</figcaption>
		</figure>

		<figure class="effect-marley description-flex">
			<img class="spaceImg" alt="SpaceImage"
				src='<c:url value="/img/white.png"></c:url>' />
			<div class="detail-flex">
				<div class="half description">
					<div class="detail">
						<c:out value="${park.parkDescription}" />
					</div>

				</div>
			</div>
		</figure>
		<figure class="effect-marley detail-flex">
			<img class="spaceImg" alt="SpaceImage"
				src='<c:url value="/img/white.png"></c:url>' />
			<div class="detail-flex">
				<div class="half">
					<div class="detail">
						State &nbsp;| &nbsp;<span><c:out value="${park.state}" /></span>
					</div>
					<br>
					<div class="detail">
						Acreage &nbsp;| &nbsp;<span><c:out value="${park.acreage}" /></span>
					</div>
					<br>
					<div class="detail">
						Elevation &nbsp;| &nbsp;<span><c:out
								value="${park.elevationInFeet}" /> ft</span>
					</div>
					<br>
					<div class="detail">
						Distance Of Trails &nbsp;| &nbsp;<span><c:out
								value="${park.milesOfTrail}" /> miles</span>
					</div>
					<br>
					<div class="detail">
						Number Of Campsites &nbsp;| &nbsp;<span><c:out
								value="${park.numberOfCampsites}" /></span>
					</div>
				</div>
				<div class="half">
					<div class="detail">
						Climate &nbsp;| &nbsp;<span><c:out value="${park.climate}" /></span>
					</div>
					<br>
					<div class="detail">
						Year Founded &nbsp;| &nbsp;<span><c:out
								value="${park.yearFounded}" /></span>
					</div>
					<br>
					<div class="detail">
						Annual Visitor Count &nbsp;| &nbsp;<span><c:out
								value="${park.annualVisitorCount}" /></span>
					</div>
					<br>
					<div class="detail">
						Entry Fee &nbsp;| &nbsp;<span><c:out
								value="$${park.entryFee}.00" /></span>
					</div>
					<br>
					<div class="detail">
						Animal Species &nbsp;| &nbsp;<span><c:out
								value="${park.numberOfAnimalSpecies}" /></span>
					</div>
				</div>
			</div>
		</figure>

	</div>

	<figure class="effect-marley detail-flex">
		<img class="spaceImg" alt="SpaceImage"
			src='<c:url value="/img/white.png"></c:url>' />
		<div class="detail-flex weatherForecast">
			<div class="weatherToday weatherDetail">
				Today: <img alt="National Park Picture"
					src="<c:url value="/img/weather/${weather1.imageName}" />">
				<div class="todayTemps">
					<div>
						High &nbsp;| <span><c:out
								value="${weather1.high}${weather1.indicator}" /></span>
					</div>
					&nbsp; &nbsp; &nbsp;
					<div>
						Low &nbsp;| <span><c:out
								value="${weather1.low}${weather1.indicator}" /></span>
					</div>
				</div>
				<br>
				<div>
					<span><c:out value="${weather1.forecastMessage}" /> <c:out
							value="${weather1.highLowMessage}" /></span>
				</div>
			</div>

			<div class="weatherRemainingWeekdays">
				<div class="weatherDetail">

					<img alt="National Park Picture"
						src="<c:url value="/img/weather/${weather2.imageName}" />">

					<div>
						High &nbsp;| <span><c:out
								value="${weather2.high}${weather2.indicator}" /></span>
					</div>
					<div>
						Low &nbsp;| <span><c:out
								value="${weather2.low}${weather2.indicator}" /></span>
					</div>


				</div>
				<div class="weatherDetail">
					<img alt="National Park Picture"
						src="<c:url value="/img/weather/${weather3.imageName}" />">
					<div>
						High &nbsp;| <span><c:out
								value="${weather3.high}${weather3.indicator}" /></span>
					</div>
					<div>
						Low &nbsp;| <span><c:out
								value="${weather3.low}${weather3.indicator}" /></span>
					</div>
				</div>
				<div class="weatherDetail">
					<img alt="National Park Picture"
						src="<c:url value="/img/weather/${weather4.imageName}" />">
					<div>
						High &nbsp;| <span><c:out
								value="${weather4.high}${weather4.indicator}" /></span>
					</div>
					<div>
						Low &nbsp;| <span><c:out
								value="${weather4.low}${weather4.indicator}" /></span>
					</div>
				</div>
				<div class="weatherDetail">
					<img alt="National Park Picture"
						src="<c:url value="/img/weather/${weather5.imageName}" />">
					<div>
						High &nbsp;| <span><c:out
								value="${weather5.high}${weather5.indicator}" /></span>
					</div>
					<div>
						Low &nbsp;| <span><c:out
								value="${weather5.low}${weather5.indicator}" /></span>
					</div>
				</div>
			</div>
		</div>
	</figure>

</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
</html>