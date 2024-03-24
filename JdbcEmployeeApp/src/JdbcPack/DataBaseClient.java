package JdbcPack;

import java.sql.SQLException;
import java.util.List;

public class DataBaseClient {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		EmployeeDao employeeDao=new EmployeeDao();
		//1.save()
//		int res1=employeeDao.save(new Employee(101,"Anusha",1000));
//		System.out.println("Data Inserted Successfully  "+res1);
//		int res2=employeeDao.save(new Employee(102,"Srividya",2000));
//		System.out.println("Data Inserted Successfully  "+res2);
//		int res3=employeeDao.save(new Employee(103,"Sailaja",3000));
//		System.out.println("Data Inserted Successfully  "+res3);
//		int res4=employeeDao.save(new Employee(104,"Prathusha",4000));
//		System.out.println("Data Inserted Successfully  "+res4);
		//--------------------------------------------------------------------------------
		
		//findById
//		Employee em=employeeDao.findById(101);
//		System.out.println(em);
		//----------------------------------------------------------------------------------
		
//		//deleteById
//		int count=employeeDao.deleteById(102);
//		if(count==1)
//			System.out.println("Record deleted successfully");
//		else
//			System.out.println("Record deletion fail");
//		-----------------------------------------------------------------------------------------
//		//delete by salary()
//		int count2=employeeDao.deleteBySalary(1000);
//		if(count2!=0)
//			System.out.println("record deleted");
//		else
//			System.out.println("not deleted");
		
		//------------------------------------------------------------------------------------------
		//findAll()
//		List<Employee> emps=employeeDao.findAll();
//		emps.forEach(emps1->System.out.println(emps1));	
		//--------------------------------------------------------------------------------------------
		//updateSalary()
		int count=employeeDao.updateSalary(500, 1000);
		System.out.println("No of rows updates "+count);
		
	}

}
