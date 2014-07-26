package br.com.cts.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception{
		try{
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "pgpadrao", "pgpadrao123");
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
}