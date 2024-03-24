import java.sql.SQLException;
import java.util.*;
public class ProductClient {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ProductDao dao=new ProductDao();
//		int res=dao.createProductTable();
//		System.out.println("Table Created Successfully..."+res);
//---------------------------------------------------------------------------------------------
		
		//call saveProduct() method
//		int res1=dao.saveProduct(new Product(1001, "sugar", 40));
//		System.out.println("Record created successfully" +res1);
//		int res2=dao.saveProduct(new Product(1002, "salt", 20));
//		System.out.println("Record created successfully" +res2);
//		int res3=dao.saveProduct(new Product(1003, "surf", 20));
//		System.out.println("Record created successfully" +res3);
//		int res4=dao.saveProduct(new Product(1004, "soap", 20));
//		System.out.println("Record created successfully" +res4);
//		int res5=dao.saveProduct(new Product(1005, "paste", 20));
//		System.out.println("Record created successfully" +res5);
//---------------------------------------------------------------------------------------------
		
		//call getProductById
//		Product product=dao.getProductById(1002);
//		System.out.println(product);
//---------------------------------------------------------------------------------------------
		
		//getAllProducts
		
//		List<Product> list=dao.getAllProducts();
//		list.stream().forEach(a ->System.out.println(a));
//---------------------------------------------------------------------------------------------
		//call updateByPrice() method
//		int count=dao.updateByPrice(20, 100);
//		System.out.println("Updated Successfully."+count);
//---------------------------------------------------------------------------------------------
		//deleteById()
//		int count=dao.deleteById(1002);
//		System.out.println("Deleted Record Successfully :"+count);
//---------------------------------------------------------------------------------------------
		//deleteByPrice()
//		int count=dao.deleteByPrice(20);
//		System.out.println("Record Deleted Successfully:"+count);
//---------------------------------------------------------------------------------------------
		
		//drop the table
//		int count=dao.dropTable();
//		System.out.println("Table dropped successfully:"+count);
		
	}
	

}
