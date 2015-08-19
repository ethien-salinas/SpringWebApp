package org.auribox.model;

import java.util.List;

public class Personas {
	
	private List<Persona> personas;

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public String toString() {
		return "Personas [personas=" + personas + "]";
	}
	
}
