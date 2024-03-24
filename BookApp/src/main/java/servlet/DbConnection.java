package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		Connection connection=null;
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","anusha","anusha");
			
		
		return connection;
	}
}
