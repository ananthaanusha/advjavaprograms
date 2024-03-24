package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	//1.create book table
		public int createBookTable() throws ClassNotFoundException, SQLException{
			int res1=0;
			try(Connection connection=DbConnection.createConnection();
					Statement statement=connection.createStatement())
			{
				//create the table 
				
				res1=statement.executeUpdate("create table book(bId number,bName varchar2(50),bTitle varchar(80),bDate date, bAuthor varchar2(30),bPrice number)");
				System.out.println("Table Created Successfully..."+res1);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return res1;
		}
		
		//2.insert the data into pro table
		public int saveBook(Book book) throws SQLException, ClassNotFoundException {
			int res=0;
			try(Connection connection=DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("insert into pro values(?,?,?,?,?)"))
			{
				//read the data from book and set into parameters
				preparedStatement.setString(1, book.getbName());
				preparedStatement.setString(2, book.getbTitle());
				preparedStatement.setString(3, book.getbAuthor());
				preparedStatement.setString(4, book.getbDate());
				preparedStatement.setDouble(5, book.getbPrice());
				
				//EXECUTE THE QUERY
				res=preparedStatement.executeUpdate();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return res;
		}
		
		//3.getBookById()
		public Book getBookById(int bId) throws ClassNotFoundException, SQLException {
			Book book=null;
			try(Connection connection=DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("select * from pro where bId=?"))
			{
				preparedStatement.setInt(1, bId);
				
				//store the data in resultSet object
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
					book=new Book();
					book.setbId(resultSet.getInt(1));
					book.setbName(resultSet.getString(2));
					book.setbTitle(resultSet.getString(3));
					book.setbAuthor(resultSet.getString(4));
					book.setbDate(resultSet.getString(5));
					book.setbPrice(resultSet.getDouble(6));
				}
				
				
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return book;
		}
		
		
		//4.getAllBooks
		
			public List<Book> getAllBooks(){
				List<Book> books=new ArrayList<>();
				try(Connection connection=DbConnection.createConnection();
						Statement statement=connection.createStatement())
				{
					ResultSet resultSet=statement.executeQuery("select * from book");
					while(resultSet.next()) {
						Book book=new Book();
						book.setbId(resultSet.getInt(1));
						book.setbName(resultSet.getString(2));
						book.setbTitle(resultSet.getString(3));
						book.setbAuthor(resultSet.getString(4));
						book.setbDate(resultSet.getString(5));
						book.setbPrice(resultSet.getDouble(6));
						
						books.add(book);
					}
				}
				catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				return books;
			}
			
			
		 //5.updateByPrice()
			public int updateByPrice(double primaryRange, double incAmount) {
				int count=0;
				try(Connection connection=DbConnection.createConnection();
						PreparedStatement preparedStatement=connection.prepareStatement("update book set bPrice=bPrice+? where bPrice>?"))
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
			public int deleteById(int bId) throws ClassNotFoundException, SQLException {
				int count=0;
				try(Connection connection=DbConnection.createConnection();
						PreparedStatement preparedStatement=connection.prepareStatement("delete from book where bId=?"))
				{				
					preparedStatement.setInt(1, bId);
					count=preparedStatement.executeUpdate();				
				}
				
				return count;
			}
			//7.deleteByPrice
			public int deleteByPrice(double bPrice) throws SQLException, ClassNotFoundException {
				int count=0;
				try(Connection connection=DbConnection.createConnection();
						PreparedStatement preparedStatement=connection.prepareStatement("delete from book where bPrice > ?"))
				{
					preparedStatement.setDouble(1, bPrice);
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
					count=statement.executeUpdate("drop table book");
				}
				return count;
			}
}
