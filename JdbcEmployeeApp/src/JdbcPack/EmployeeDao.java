package JdbcPack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	public int save(Employee emp) throws ClassNotFoundException, SQLException {
		//declare the resources
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int count=0;
		
		
			//get the connection
			connection=DbConnection.createConnection();
			
			//create preparedStatement object
			
			preparedStatement = connection.prepareStatement("insert into emp values(?,?,?)");
			
			//Read the data from emp object and set to parameters
			preparedStatement.setInt(1, emp.getEmpId() );
			preparedStatement.setString(2, emp.getEmpName());
			preparedStatement.setDouble(3, emp.getEmpSalary());
			
			count=preparedStatement.executeUpdate();
			
			//close the resources
			if(connection !=null)
				connection.close();
			if(preparedStatement !=null)
				preparedStatement.close();				
		return count;
		
	}
	//2.findById()
	public Employee findById(int empId) {
		Employee employee=null;
		try(Connection connection=DbConnection.createConnection();
				                  PreparedStatement preparedStatement=connection.prepareStatement("select * from emp where Id=?"))
		{
			//set the data to parameter
			preparedStatement.setInt(1, empId);
			
			//execute the query
			ResultSet resultSet=preparedStatement.executeQuery();
			//setting the result set values into employee object
			if(resultSet.next()) {
				employee=new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
			}
			
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		return employee;
	}	
	
	//3.deleteById
	public int deleteById(int empId) {
		int count=0;
		try(Connection connection=DbConnection.createConnection();
									PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where Id=?"))
		{
			//set data to parameter
			preparedStatement.setInt(1, empId);
			//execute query
			count=preparedStatement.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//4.deleteBySalary
	public int deleteBySalary(double sal) {
		int count=0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where salary=?"))
				{
				//set data to parameter
				preparedStatement.setDouble(1, sal);
				//execute query
				count=preparedStatement.executeUpdate();
				
				}
				catch(Exception e) {
				e.printStackTrace();
				}
				return count;

	}
	public List<Employee> findAll(){
		List<Employee> emps=new ArrayList<>();
		try(Connection connection=DbConnection.createConnection();
									Statement statement=connection.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select * from emp");
			while(resultSet.next()) {
				Employee employee=new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
				emps.add(employee);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emps;
	}
	
	//5.updateSalary()
	public int updateSalary(double currentSalary,double incrementSalary)
	{
		int count=0;
		
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("update emp set salary=salary+? where salary>?"))
		{
			preparedStatement.setDouble(1,incrementSalary);
			preparedStatement.setDouble(2, currentSalary);
			
			 count=preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
