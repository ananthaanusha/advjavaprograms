function validateForm(){
	var proId=Document.getElementById("proId").value;
	var proName=Document.getElementById("proName").value;
	var proPrice=Document.getElementById("proPrice").value;
	var proBrand=Document.getElementById("proBrand").value;
	var madeIn=Document.getElementById("madeIn").value;
	
	if(proId.trim() ==="" || proName.trim() ==="" || proPrice.trim() ==="" || proBrand.trim() ==="" || madeIn.trim() ==="")
	{
	alert("All Fields Must Be Filled Out");
	return false;
	}
	if(parseFloat(proPrice)<0){
		alert("price must not be negative ");
		return false;
	}
	if(proName.length >50 || proBrand.length>50){
		alert("Product Name and Brand length should not exceed 50 characters");
		return false;
	}
	var promfgdt=document.getElementById("mDate").value;
	var proexpdt=document.getElementById("eDate").value;
	var manufacturedDate = new Date(promfgdt);
	var expiryDate=new Date(proexpdt);
	if(manufacturedDate > expiryDate)
	{
		alert("manufactured date cannot be greater than expiry date");
		return false;
	}
	return true;
}