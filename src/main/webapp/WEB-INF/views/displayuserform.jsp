<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@page isELIgnored="false" %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
 <div class="row">
<c:forEach items="${userlist}" var="user">
<div class="col-sm-6" style="background-color:white;">
  
       <h1>USERDETAILS</h1>
       EMAILADDRESS=${user.email}<br>
     USERPASSWORD=${user.password}<br>
      USERNAME=${user.username}<br>
     MobileNo=${user.mobileno}<br>
    USERADDRESS=${user.address}<br>
</div>
</c:forEach>
</div>
</div>
</body>
</html>