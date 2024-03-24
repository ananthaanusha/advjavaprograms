import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static  Connection createConnection() throws ClassNotFoundException, SQLException {
		//load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//create the connection
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","anusha","anusha");
		
		return connection;
		}
}
