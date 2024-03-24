package com.sathya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnecton {
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","anusha","anusha");
			return connection;
	}
}
