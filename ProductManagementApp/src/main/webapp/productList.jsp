<%@page import="com.sathya.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.sathya.ProductDao"  import="java.util.Base64"  import="com.sathya.Product"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>

<html>
		<head>
		<title>Product List</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script type="text/javascript" src="formvalidation.js"></script>
		</head>
		<body>
		<div>
		  <h1 class ="text-center text-success bg-dark">List Of Available Products....</h1>
		</div>
		<div>
		  <a class="btn btn-warning" href="addProduct.html">Save Product</a>
		</div>
		<div>
		<input type="text" value="Search">
		   <% Product product = (Product) request.getAttribute("product");
		       if (product != null) { %>
		        <p>ID: <%= product.getProId() %></p>
		        <p>Name: <%= product.getProName() %></p>
		        <p>Description: <%= product.getProPrice() %></p>
		        <p>Name: <%= product.getProBrand() %></p>
		        <p>Name: <%= product.getProMadeIn() %></p>
		        <p>Name: <%= product.getProMDate() %></p>
		        <p>Name: <%= product.getProEDate() %></p>
		        <p>Name: <%= product.getProImage() %></p>
		        <!-- Display other fields as needed -->
		    <% } else { %>
		        <p>No product found with the given name.</p>
		    <% } %>
		   
		</div>
		<div>
		   <a:if test="${saveResult==1}">
		   <h1 class="text-center text-primary">Data Inserted Successfully.....</h1>
		   
		   </a:if>
		</div>
		<div>
		   <a:if test="${delete==1}">
		   <h1 class="text-center text-danger">Data Deleted Successfully.....</h1>
		   </a:if>
		</div>
		<div>
		   <a:if test="${delete==0}">
		   <h1 class="text-center text-danger">Data Deletion Fail.....</h1>
		   </a:if>
		</div>
		<table class="table table-bordered table-striped">
		  <thead class="thead-dark">
		    <tr>
		    	<th>Product ID</th>
		    	<th>Product Name</th>
		    	<th>Product Cost</th>
		    	<th>Product Brand</th>
		    	<th>Product Made In</th>
		    	<th>Manufacture Date</th>
		    	<th>Expiry Date</th>		    	
		    	<th>Image</th>		    
		    	<th>Actions</th>
		    	
		    </tr>
		   </thead>
	      <tbody>
		    <a:forEach var="product" items="<%=new ProductDao().findAll() %>">
		    	<tr>
		    		<td>${product.proId}</td>
		    		<td>${product.proName}</td>
		    		<td>${product.proPrice}</td>
		    		<td>${product.proBrand}</td>
		    		<td>${product.proMadeIn}</td>
		    		<td>${product.proMDate}</td>
		    		<td>${product.proEDate}</td>
		    		
		    		
					<td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" 
		    		alt="Product Image" style="max-width:100px; max-height:100px;">
		    		</td>
		    		
		    		 		
		    		<td class="btn">
		    			<a href="./EditProductServlet?proId=${product.proId}">Edit</a>
		    		</td>
		    		<td class="btn">		
		    			<a href="./DeleteProductServlet?proId=${product.proId}">Delete</a>
		    		</td>
		    </tr>
		    </a:forEach>
		    </tbody>
		  </table>
		</body>
</html>