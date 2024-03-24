import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//step-1:load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded Successfully");
		
		//step-2:create the connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","anusha","anusha");
		System.out.println("Connection created successfully");
		
		//step-3:process the query
		Statement s=con.createStatement();
		String q="create table emp(id number,name varchar(30),salary number)";
		int res1=s.executeUpdate(q);
		System.out.println("Table Created Successfully..."+res1);
		
		//step-4:close the resources
		con.close();
		System.out.println("connection closed successfully...");
		}
}
