package com.sathya;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class ProductDao {
	public int save(Product product){
		int result=0;
		try(Connection connection=DbConnecton.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("insert into Product_data values(?,?,?,?,?,?,?,?)"))
				
		
		{
			preparedStatement.setString(1, product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			preparedStatement.setDate(6, product.getProMDate());
			preparedStatement.setDate(7, product.getProEDate());
			preparedStatement.setBytes(8, product.getProImage());
			

			
			result=preparedStatement.executeUpdate();	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

	
	public List<Product> findAll() throws ClassNotFoundException, SQLException{
		List<Product> pro=new ArrayList<>();
		try(Connection connection=DbConnecton.createConnection();
				Statement statement=connection.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select * from Product_data");
			while(resultSet.next()) {
				Product product=new Product();
				product.setProId(resultSet.getString("proId"));
				product.setProName(resultSet.getString("proName"));
				product.setProPrice(resultSet.getDouble("proPrice"));
				product.setProBrand(resultSet.getString("proBrand"));
				product.setProMadeIn(resultSet.getString("proMadeIn"));
				product.setProMDate(resultSet.getDate("proMfgDate"));
				product.setProEDate(resultSet.getDate("proExpDate"));
				product.setProImage(resultSet.getBytes("proImage"));
				//product.setProAudio(resultSet.getBytes("proAudio"));
//				product.setProVideo(resultSet.getBytes("proVideo"));
				
				pro.add(product);
				
			}
			return pro;
		}
	}
		
	
	
	public int deleteById(String proId) throws ClassNotFoundException, SQLException {
		int result=0;
		Connection connection=DbConnecton.createConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from Product_data where proId=?");
		preparedStatement.setString(1, proId);
		result=preparedStatement.executeUpdate();
		
		return result;
	}
	
	public Product findById(String proId)
	{
		Product product=new Product();
		try(Connection connection=DbConnecton.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select * from Product_data where proId=?"))
		{
			preparedStatement.setString(1, proId);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				product.setProId(resultSet.getString(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getDouble(3));
				product.setProBrand(resultSet.getString(4));
				product.setProMadeIn(resultSet.getString(5));
				product.setProMDate(resultSet.getDate(6));
				product.setProEDate(resultSet.getDate(7));
				product.setProImage(resultSet.getBytes(8));
				//product.setProAudio(resultSet.getBytes(9));
//				product.setProVideo(resultSet.getBytes(10));
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
				
	}
	
	public int updateById(Product product) 
	{
	int result=0;
	try(Connection connection=DbConnecton.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("update Product_data set proName=?,"
					+ "proPrice=?,proBrand=?,proMadeIn=?,proMfgDate=?,proExpDate=?,proImage=? where proId=?"))
		{
		preparedStatement.setString(1, product.getProName());
		preparedStatement.setDouble(2, product.getProPrice());
		preparedStatement.setString(3, product.getProBrand());
		preparedStatement.setString(4, product.getProMadeIn());
		preparedStatement.setDate(5, product.getProMDate());
		preparedStatement.setDate(6, product.getProEDate());
		preparedStatement.setBytes(7, product.getProImage());
		preparedStatement.setString(8, product.getProId());
		
		result=preparedStatement.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
		}
	return result;
	}
	
	public Product searchByName(String name) {
		Product product=new Product();
		try(Connection connection=DbConnecton.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("select * from Product_data where proName=?"))
		{
			preparedStatement.setString(1, name);
			 ResultSet resultSet=preparedStatement.executeQuery();
			 if(resultSet.next()) {
				 	product.setProId(resultSet.getString(1));
					product.setProName(resultSet.getString(2));
					product.setProPrice(resultSet.getDouble(3));
					product.setProBrand(resultSet.getString(4));
					product.setProMadeIn(resultSet.getString(5));
					product.setProMDate(resultSet.getDate(6));
					product.setProEDate(resultSet.getDate(7));
					product.setProImage(resultSet.getBytes(8));
				 
			 }
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
		
}
