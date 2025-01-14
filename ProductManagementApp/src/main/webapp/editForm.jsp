<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.sathya.ProductDao"  import="java.util.Base64"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html>
<html>
<head>
<title>This is Edit Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

		
</head>
<body>
<!--<a:if test="${result==1}">
		   <h1 class="text-center text-danger">Data Updated Successfully.....</h1>
		   </a:if>
		</div>
		<div>
		   <a:if test="${result==0}">
		   <h1 class="text-center text-danger">Data Updation Fail.....</h1>
		   </a:if>
		</div>-->

<div class="container mt-5 text-center">
	<h2 class="text-center font-italic mb-1">Update Product</h2>
	  <form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit="return alertSuccess()">
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proId">Product Id:</label>
		<input type="text" class="form-control-sm" id="proId" name="proId" value="${existingProduct.proId}">
		</div>
		
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proName">Product Name:</label>
		<input type="text" class="form-control-sm" id="proName" name="proName" value="${existingProduct.proName}">
		</div>
				
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proPrice">Product Price:</label>
		<input type="number" class="form-control-sm" id="proPrice" name="proPrice" value="${existingProduct.proPrice}">
		</div>
		
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proBrand">Product Brand:</label>
		<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingProduct.proBrand}">
		</div>
		
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="madeIn">Made In:</label>
		<input type="text" class="form-control-sm" id="madeIn" name="madeIn" value="${existingProduct.proMadeIn}">
		</div>
		
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="mDate">Manufactured Date:</label>
		<input type="date" class="form-control-sm" id="mDate" name="mDate" value="${existingProduct.proMDate}">
		</div>
		
				
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="eDate">Expiry Date:</label>
		<input type="date" class="form-control-sm" id="eDate" name="eDate" value="${existingProduct.proEDate}">
		</div>
		
		
		    <!-- Display the current product image -->
        <div class="form-group">
		<label class="font-italic font-weight-bold" for="proImage">Image:</label>
		<a:if test="${existingProduct != null}">
    	<img id="currentImage" src="data:image/jpeg;base64, ${Base64.getEncoder().encodeToString(existingProduct.proImage)}" alt="Current Product Image" style="max-width: 100px; max-height:100px;"/>
		<input type="hidden" id="existingImage" name="existingImage" value="${Base64.getEncoder().encodeToString(existingProduct.proImage)}"/>
		</a:if>
		</div>
		
		
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="proImage">New Product Image:</label>
			<input type="file" class="form-control-sm" id="newProImage" name="newProImage" accept="image/*">
			</div>
		<div>
		  <input type="submit" class="btn btn-success" value="Update Product"/>
		  
		</div>
</body>
</html>