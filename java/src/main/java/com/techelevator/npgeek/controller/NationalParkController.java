package com.techelevator.npgeek.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.database.NationalParkDAO;
import com.techelevator.npgeek.database.SurveyDAO;
import com.techelevator.npgeek.database.WeatherDAO;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.Weather;

@Controller
@SessionAttributes({ "temperatureIndicator", "parkCode", "parks", "parksSurveyCount"})
public class NationalParkController {

	@Autowired
	private NationalParkDAO parkDAO;
	@Autowired
	private SurveyDAO surveyDAO;
	@Autowired
	private WeatherDAO weatherDAO;

	
	@RequestMapping("/")
	public String displayAllParks(HttpServletRequest request) {

		request.setAttribute("nationalParkList", parkDAO.getAllParks());
		
		return "homePage";
	}

	@RequestMapping(path = "/detailPage", method = RequestMethod.GET)
	public String displayParksDetailPage(HttpServletRequest request, ModelMap map, @RequestParam String parkCode) {
	
		if(parkCode ==null) {
			parkCode = (String) map.get("parkCode");
		}
		
		String temperatureIndicator =  request.getParameter("temperatureIndicator");
		String test = null;
		if(temperatureIndicator == null && map.containsAttribute("temperatureIndicator")) {
			temperatureIndicator = (String) map.get("temperatureIndicator");
			map.addAttribute("temperatureIndicator", temperatureIndicator);
		}
		if(map.containsAttribute("temperatureIndicator") && !(map.get("temperatureIndicator").toString().equals(temperatureIndicator) && temperatureIndicator != null)) {
			test = temperatureIndicator;
			map.addAttribute("temperatureIndicator", test);
		}
		if(temperatureIndicator == null || !(map.containsAttribute("temperatureIndicator"))) {
			test = "F";
			map.addAttribute("temperatureIndicator", test);
		}
		else map.addAttribute("temperatureIndicator", temperatureIndicator);
		
		
		String indicator = (String) map.get("temperatureIndicator");
		
		request.setAttribute("park", parkDAO.getParkByParkCode(parkCode));
		request.setAttribute("weather1", weatherDAO.getDailyWeather(1, parkCode, indicator));
		request.setAttribute("weather2", weatherDAO.getDailyWeather(2, parkCode, indicator));
		request.setAttribute("weather3", weatherDAO.getDailyWeather(3, parkCode, indicator));
		request.setAttribute("weather4", weatherDAO.getDailyWeather(4, parkCode, indicator));
		request.setAttribute("weather5", weatherDAO.getDailyWeather(5, parkCode, indicator));

		return "detailPage";
	}
	
	@RequestMapping(path = "/detailPage", method = RequestMethod.POST)
	public String handleDetailPageTempConversion(ModelMap map, HttpServletRequest request) {
		String parkCode = request.getParameter("parkCode");
		String temperatureIndicator =  request.getParameter("temperatureIndicator");
		String test = null;
		if(temperatureIndicator == null && map.containsAttribute("temperatureIndicator")) {
			temperatureIndicator = (String) map.get("temperatureIndicator");
			map.addAttribute("temperatureIndicator", temperatureIndicator);
		}
		if(temperatureIndicator == null || !(map.containsAttribute("temperatureIndicator"))) {
			test = "F";
			map.addAttribute("temperatureIndicator", test);
		}
		if(map.containsAttribute("temperatureIndicator") && temperatureIndicator != null && !(map.get("temperatureIndicator").toString().equals(temperatureIndicator))) {
			test = temperatureIndicator;
			map.addAttribute("temperatureIndicator", test);
		}
		
	
		
		map.addAttribute("parkCode", parkCode);
		return "redirect:/detailPage";
	}

	@RequestMapping(path = "/surveyInput", method = RequestMethod.GET)
	public String showSurveyQuestions(ModelMap map, HttpServletRequest request) {
		request.setAttribute("parks", parkDAO.getAllParks());
		map.addAttribute("parks",  parkDAO.getAllParks());
		if (!map.containsAttribute("survey")) {
			map.addAttribute("survey", new Survey());
		}
		return "surveyInput";
	}

	@RequestMapping(path = "/surveyInput", method = RequestMethod.POST)
	public String handleSurvey(@Valid @ModelAttribute("survey") Survey survey, BindingResult result,
			RedirectAttributes attr, ModelMap map) {
		
		if (result.hasErrors()) {
			return "surveyInput";
		}

		attr.addFlashAttribute("survey", survey);

		surveyDAO.saveSurvey(survey);
		return "redirect:/surveyResult";
	}

	@RequestMapping(path = "/surveySuccessful", method = RequestMethod.GET)
	public String showTotalSurveys(ModelMap map, HttpServletRequest request) {
		map.addAttribute("parksSurveyCount", parkDAO.listOfParksOrderedBySurveyCount());
		request.setAttribute("parksSurveyCount", parkDAO.listOfParksOrderedBySurveyCount());

		return "surveyResult";
	}

	@RequestMapping(path = "/surveyResult", method = RequestMethod.GET)
	public String displaySurveyResultPage(HttpServletRequest request) {

		request.setAttribute("parksSurveyCount", parkDAO.listOfParksOrderedBySurveyCount());

		return "surveyResult";
	}

}
