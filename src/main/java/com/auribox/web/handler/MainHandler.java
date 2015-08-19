package com.auribox.web.handler;

import org.auribox.model.Direccion;
import org.auribox.model.Persona;
import org.auribox.model.Personas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.auribox.db.dao.PersonaDAO;

@Component
public class MainHandler {
	
	private static final Logger systemLogger = LoggerFactory.getLogger("system");
	
	@Autowired
	Personas personas;
	
	@Autowired
	Persona persona;
	
	@Autowired
	PersonaDAO personaDAO;
	
	public String getStatusKeyword(){
		return "OK\n";
	}

	public ModelAndView getShowMessageView() {
		return new ModelAndView("showMessage", "message", "Ethien");
	}

	public ModelAndView getPersonById(int id) {
		Persona persona = personaDAO.getPersonaById(id);
		systemLogger.info("Person found: {}", persona);
		return new ModelAndView("showAPerson", "person", persona);
	}
	
	public ModelAndView getAllPersons() {
		return new ModelAndView("showPersons", "persons", personaDAO.list());
	}

	public String initDB() {
		personaDAO.createTable();
		
		Direccion direccion = new Direccion();
		direccion.setCalle("Evergreen Terrace");
		direccion.setColonia("Springfield");
		direccion.setNumExt(123);
		
		Persona p0 = new Persona();
		p0.setDireccion(direccion);
		p0.setEdad(31);
		p0.setNombre("Homero Simpson");
		personaDAO.save(p0);

		Persona p1 = new Persona();
		p1.setDireccion(direccion);
		p1.setEdad(30);
		p1.setNombre("Marge Simpson");
		personaDAO.save(p1);
		
		systemLogger.info("DB has been started");

		return "DB started";
	}

}
