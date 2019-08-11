<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE>
<html>
<head>
<title>Survey Page</title>
</head>

<body>
<div class="grid" id="surveyForm">
	<c:set var="pageTitle" value="Survey Form" />
	<h1>Favorite National Park Survey</h1>
	<h2>We both know you have that favorite national park that you just can't help but go back to. So spill the beans - tell us which one it is! Just fill out the survey below, and you're all set!</h2>
<br>
		<c:url value="/surveyInput" var="surveyUrl" />

		<form:form action="${surveyUrl}" method="POST" modelAttribute="survey"> 

			<figure>
				<label for="parkCode">Name Of Park:&nbsp;&nbsp;</label> <select name="parkCode" path = "parkCode" required>
					<option value="" disabled selected > -- select an option -- </option>
					<c:forEach items="${parks}" var="park">
						<option value="${park.parkCode}">${park.parkName}</option>
					</c:forEach>
					<form:errors path="parkCode" cssClass="error" />
				</select>

			</figure>

			<figure>
				<label for="emailAddress">Email:&nbsp;&nbsp;</label>
				<input required type="text" name="emailAddress" path="emailAddress" />
				<form:errors path="emailAddress" cssClass="error" />

			</figure>

			<figure>
				<label for="state">State Of Residence:&nbsp; &nbsp;</label> <select name="state" path = "state" required>
					<option value="" disabled selected > -- select an option -- </option>
					<option value="AL">Alabama</option>
					<option value="AK">Alaska</option>
					<option value="AZ">Arizona</option>
					<option value="AR">Arkansas</option>
					<option value="CA">California</option>
					<option value="CO">Colorado</option>
					<option value="CT">Connecticut</option>
					<option value="DE">Delaware</option>
					<option value="DC">District Of Columbia</option>
					<option value="FL">Florida</option>
					<option value="GA">Georgia</option>
					<option value="HI">Hawaii</option>
					<option value="ID">Idaho</option>
					<option value="IL">Illinois</option>
					<option value="IN">Indiana</option>
					<option value="IA">Iowa</option>
					<option value="KS">Kansas</option>
					<option value="KY">Kentucky</option>
					<option value="LA">Louisiana</option>
					<option value="ME">Maine</option>
					<option value="MD">Maryland</option>
					<option value="MA">Massachusetts</option>
					<option value="MI">Michigan</option>
					<option value="MN">Minnesota</option>
					<option value="MS">Mississippi</option>
					<option value="MO">Missouri</option>
					<option value="MT">Montana</option>
					<option value="NE">Nebraska</option>
					<option value="NV">Nevada</option>
					<option value="NH">New Hampshire</option>
					<option value="NJ">New Jersey</option>
					<option value="NM">New Mexico</option>
					<option value="NY">New York</option>
					<option value="NC">North Carolina</option>
					<option value="ND">North Dakota</option>
					<option value="OH">Ohio</option>
					<option value="OK">Oklahoma</option>
					<option value="OR">Oregon</option>
					<option value="PA">Pennsylvania</option>
					<option value="RI">Rhode Island</option>
					<option value="SC">South Carolina</option>
					<option value="SD">South Dakota</option>
					<option value="TN">Tennessee</option>
					<option value="TX">Texas</option>
					<option value="UT">Utah</option>
					<option value="VT">Vermont</option>
					<option value="VA">Virginia</option>
					<option value="WA">Washington</option>
					<option value="WV">West Virginia</option>
					<option value="WI">Wisconsin</option>
					<option value="WY">Wyoming</option>
					<form:errors path="state" cssClass="error" />
				</select>


			</figure>
			<figure>
				<label for="activityLevel">Activity Level: &nbsp; &nbsp;</label> 
				
					<input required type="radio" name="activityLevel" value="inactive">Inactive &nbsp;
					<input type="radio" name="activityLevel" value="sedentary">Sedentary &nbsp;
					<input type="radio" name="activityLevel" value="active">Active &nbsp;
					<input type="radio" name="activityLevel" value="extremelyActive">Extremely Active &nbsp;
					<form:errors path="activityLevel" cssClass="error" />
				

			</figure>
			<br>
			<figure class="button">
				<input type="submit" value="Submit" />
			</figure>


		</form:form>

	</div>
	<c:import url="/WEB-INF/jsp/common/footer.jsp" />
</html>