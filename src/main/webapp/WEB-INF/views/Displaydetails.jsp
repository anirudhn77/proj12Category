
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
<table  border="4">
<tr>
<th>
Images
</th>
<th>
CartId
</th>
<th>
ProductName
</th>
<th>
ProductPrice
</th>
<th>
ProductSupplier
</th>
<th>
ProductQuantity
</th>
<th>
TotalPrice
</th>
</tr>
<c:forEach items="${cartlist}" var="ca">
<tr>
 <td><img src="resources/images/${ca.productId}.jpg" height="50" width="50" ></td>
<td>${ca.cartdId}</td>
<td>${ca.productName}</td>
<td>${ca.productprice}</td>
<td>${ca.productSuppllier}</td>
<td>${ca.productQuantity}</td>
<td>${ca.totalprice}</td>
</tr>



</c:forEach>
</table>





</body>
</html>
