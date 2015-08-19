package com.auribox.db.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.auribox.model.Direccion;
import org.auribox.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.auribox.db.config.DBConfiguration;

@Component
public class PersonaDAOImpl implements PersonaDAO {
	
	private static final Logger daoLogger = LoggerFactory.getLogger("dao");
	private static final Logger exceptionLogger = LoggerFactory.getLogger("exception");
	
	public void createTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DBConfiguration.getConnection();
			statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS PERSONA "
					+ "(id int primary key IDENTITY,"
					+ "nombre varchar(255), " 
					+ "edad integer, "
					+ "calle varchar(255), "
					+ "colonia varchar(255), "
					+ "numExt integer)");
		} catch (Exception e) {
			exceptionLogger.error("Error creating table with error: {}", e.getMessage());
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void save(Persona persona) {
		
		daoLogger.info("Call to save(Person) is processing");
		
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        String statement = "INSERT INTO persona "
        		+ "(nombre, edad, calle, colonia, numExt) "
        		+ "VALUES (?, ?, ?, ?, ?)";
        try {
            connection = DBConfiguration.getConnection();
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setInt(2, persona.getEdad());
            preparedStatement.setString(3, persona.getDireccion().getCalle());
            preparedStatement.setString(4, persona.getDireccion().getColonia());
            preparedStatement.setInt(5, persona.getDireccion().getNumExt());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        	exceptionLogger.error("Error saving Person with error: {}", e.getMessage());
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}

    public List<Persona> list() {
    	List<Persona> personas = new ArrayList<Persona>();
		Persona persona = null;
		Direccion direccion = new Direccion();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String statement = "SELECT * FROM PERSONA";
        try {
            connection = DBConfiguration.getConnection();
            preparedStatement = connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	persona = new Persona();
                persona.setId(resultSet.getInt("id"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setEdad(resultSet.getInt("edad"));
                direccion.setCalle(resultSet.getString("calle"));
                direccion.setColonia(resultSet.getString("colonia"));
                direccion.setNumExt(resultSet.getInt("numExt"));
                persona.setDireccion(direccion);
                System.out.println(persona);
                personas.add(persona);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(personas);
        return personas;
    }

	public Persona getPersonaById(int id) {
		Persona person = new Persona();
		Direccion direccion = new Direccion();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String statement = "SELECT * FROM PERSONA WHERE id = ?";
        try {
            connection = DBConfiguration.getConnection();
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //person.setId(resultSet.getInt("id"));
                person.setNombre(resultSet.getString("nombre"));
                person.setEdad(resultSet.getInt("edad"));
                direccion.setCalle(resultSet.getString("calle"));
                direccion.setColonia(resultSet.getString("colonia"));
                direccion.setNumExt(resultSet.getInt("numExt"));
                person.setDireccion(direccion);
            }
        } catch (Exception e) {
        	exceptionLogger.error("Error gettingPersonById with error: {}", e.getMessage());
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return person;
	}

}
