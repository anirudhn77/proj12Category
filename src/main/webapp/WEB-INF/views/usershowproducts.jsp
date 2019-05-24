
<%@page import="com.ani.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="Userhome.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




 <div class="container">
  <h1>Hello World!</h1>
  <div class="row">
<c:forEach items="${prolist}" var="pr">
<div class="col-sm-6" style="background-color:white;">
 <img alt="img" src="resources/images/${pr.productID}.jpg" height="100" width="100" /><br>
${pr.productName}<br>
${pr.productDescription}<br>
${pr.productPrice}<br>
${pr.productSupplier}<br>
${productCategory}<br>
<p><a href="vd?proid=${pr.productID}">ViewDetails</a></p>
 
     
    </div>
  
    

</c:forEach>

</div>
  </div>




</body>
</html>

    
    
    
    
    
   
   
 
  