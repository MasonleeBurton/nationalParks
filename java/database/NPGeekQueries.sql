SELECT parkcode, fivedayforecastvalue, low, high, forecast FROM weather WHERE parkcode = 'ENP'

SELECT * FROM park WHERE parkcode = 'CVNP'

SELECT count(survey_result.parkcode) AS surveyCount, park.parkname
FROM survey_result
JOIN park ON park.parkcode = survey_result.parkcode
GROUP BY park.parkname, park.parkcode
ORDER BY surveyCount DESC, park.parkname 

INSERT INTO survey_result(parkCode, emailAddress, state, activityLevel) 
VALUES ('GNP','mason@hotmail.com','Colorado','sedentary');

INSERT INTO survey_result(parkCode, emailAddress, state, activityLevel) 
VALUES ('YNP','steve@hotmail.com','Florida','active');

INSERT INTO survey_result(parkCode, emailAddress, state, activityLevel) 
VALUES ('YNP','ashton@hotmail.com','Idaho','inactive');


DELETE FROM survey_result


INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('ABCD',1,27,40,'snow');
INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('ABCD',2,20,79,'sunny');
INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('ABCD',3,19,76,'partly cloudy');
INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('ABCD',4,50,76,'cloudy');
INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('ABCD',5,25,32,'thunderstorms');

SELECT * FROM survey_result