package com.auribox.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.auribox.web.handler.MainHandler;

@Controller
public class MainController {

	private static final Logger systemLogger = LoggerFactory.getLogger("system");
	
	@Autowired
	MainHandler mainHandler;

	@RequestMapping(value = "status")
	@ResponseBody
	public String getStatus() {
		systemLogger.info("Incomming request for :{} and was made by :{}", 
				"getStatus Method", "Ethien Salinas");
		return mainHandler.getStatusKeyword();
	}

	@RequestMapping(value = "showMessage.html", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView getShowMessageView() {
		systemLogger.info("Incomming request for :{} and was made by :{}", 
				"getShowMessageView Method", "Ethien Salinas");
		return mainHandler.getShowMessageView();
	}
	
	@RequestMapping(value = "initdb")
	@ResponseBody
	public String initDb() {
		systemLogger.warn("Incomming request for :{} and was made by :{}", 
				"initDb Method", "Ethien Salinas");
		return mainHandler.initDB();
	}

	@RequestMapping(value = "person/all")
	public ModelAndView getPerson() {
		return mainHandler.getAllPersons();
	}

	@RequestMapping(value = "person/{id}")
	public ModelAndView getPersonById(@PathVariable int id) {
		systemLogger.info("Request for Person: {}", id);
		return mainHandler.getPersonById(id);
	}
	
	@RequestMapping(value = "person/save")
	@ResponseBody
	public String savePersona(HttpServletRequest request,
			@RequestParam(defaultValue="Bart Simpson") String nombre,
			@RequestParam int edad,
			@RequestParam(required=false) String direccion) {
		System.out.println(request.getParameterMap());
		return "{\"nombre\":\""+nombre+"\"}";
	}
}
