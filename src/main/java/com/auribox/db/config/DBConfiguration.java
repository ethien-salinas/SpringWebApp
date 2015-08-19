package com.auribox.db.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConfiguration {
	
    public static final String URL = "jdbc:hsqldb:mem:.";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";
    public static final String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
 
    private static final Logger daoLogger = LoggerFactory.getLogger("dao");
    private static final Logger exceptionLogger = LoggerFactory.getLogger("exception");
    
    public static Connection getConnection() {
    	daoLogger.info("getting connection from HSQLDB");
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
        	exceptionLogger.error("SQL Error getting connection with error: {}", e.getMessage());
        	e.printStackTrace();
        }catch (Exception e) {
        	exceptionLogger.error("Ex Error getting connection with error: {}", e.getMessage());
        	e.printStackTrace();
		}
        return connection;
    }
 
}