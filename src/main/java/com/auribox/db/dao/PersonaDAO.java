package com.auribox.db.dao;
 
import java.util.List;

import org.auribox.model.Persona;
 
public interface PersonaDAO {
	
	public void createTable();
 
    public void save(Persona persona);
     
    public List<Persona> list();

    public Persona getPersonaById(int id);
     
}