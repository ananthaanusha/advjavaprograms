import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	//1.create product table
	public int createProductTable() throws ClassNotFoundException, SQLException{
		int res1=0;
		try(Connection connection=DbConnection.createConnection();
				Statement statement=connection.createStatement())
		{
			//create the table 
			
			res1=statement.executeUpdate("create table pro(pId number,pName varchar(30),pSalary number)");
			System.out.println("Table Created Successfully..."+res1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res1;
	}
	
	//2.insert the data into pro table
	public int saveProduct(Product product) throws SQLException, ClassNotFoundException {
		int res=0;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("insert into pro values(?,?,?)"))
		{
			//read the data from pro and set into parameters
			preparedStatement.setInt(1, product.getpId());
			preparedStatement.setString(2, product.getpName());
			preparedStatement.setDouble(3, product.getpPrice());
			
			//EXECUTE THE QUERY
			res=preparedStatement.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//3.getProductById()
	public Product getProductById(int pId) throws ClassNotFoundException, SQLException {
		Product product=null;
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("select * from pro where pId=?"))
		{
			preparedStatement.setInt(1, pId);
			
			//store the data in resultSet object
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				product=new Product();
				product.setpId(resultSet.getInt(1));
				product.setpName(resultSet.getString(2));
				product.setpPrice(resultSet.getDouble(3));
			}
			
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	
	//4.getAllProducts
	
		public List<Product> getAllProducts(){
			List<Product> products=new ArrayList<>();
			try(Connection connection=DbConnection.createConnection();
					Statement statement=connection.createStatement())
			{
				ResultSet resultSet=statement.executeQuery("select * from pro");
				while(resultSet.next()) {
					Product product=new Product();
					product.setpId(resultSet.getInt(1));
					product.setpName(resultSet.getString(2));
					product.setpPrice(resultSet.getDouble(3));
					
					products.add(product);
				}
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return products;
		}
		
		
	 //5.updateByPrice()
		public int updateByPrice(double primaryRange, double incAmount) {
			int count=0;
			try(Connection connection=DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("update pro set pSalary=pSalary+? where pSalary>?"))
			{
				preparedStatement.setDouble(1, incAmount);
				preparedStatement.setDouble(2, primaryRange);
				
				count=preparedStatement.executeUpdate();
			}
			catch(ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			return count;
			
		}
		
		//6.deleteById()
		public int deleteById(int pId) throws ClassNotFoundException, SQLException {
			int count=0;
			try(Connection connection=DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("delete from pro where pId=?"))
			{				
				preparedStatement.setInt(1, pId);
				count=preparedStatement.executeUpdate();				
			}
			
			return count;
		}
		//7.deleteByPrice
		public int deleteByPrice(double pPrice) throws SQLException, ClassNotFoundException {
			int count=0;
			try(Connection connection=DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("delete from pro where pSalary > ?"))
			{
				preparedStatement.setDouble(1, pPrice);
				count=preparedStatement.executeUpdate();
			}
			return count;
		}
		//8.drop table
		public int dropTable() throws ClassNotFoundException, SQLException {
			int count=0;
			try(Connection connection=DbConnection.createConnection();
					Statement statement=connection.createStatement())
			{
				count=statement.executeUpdate("drop table pro");
			}
			return count;
		}
}
