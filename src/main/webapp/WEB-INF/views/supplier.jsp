<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@ page isELIgnored="false" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
   <%@include file="home.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
 margin: 0;
 padding: 0;
 background-color: #17a2b8;
 height: 100vh;
}
#login .container #login-row #login-column #login-box {
 margin-top: 120px;
 max-width: 600px;
 height: 320px;
 border: 1px solid #9C9C9C;
 background-color: #EAEAEA;
}
#login .container #login-row #login-column #login-box #login-form {
 padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
 margin-top: -85px;
}
</style>
</head>
<body>
<sform:form action="addsup" method="Post" modelAttribute="sup">
   <div id="Supplier">
       <h3 class="text-center text-white pt-5">Supplier form</h3>
       <div class="container">
           <div id="Supplier-row" class="row justify-content-center align-items-center">
               <div id="Supplier-column" class="col-md-6">
                   <div id="Supplier-box" class="col-md-12">
                       <form id="Supplier-form" class="form" action="" method="post">
                           <h3 class="text-center text-info">Supplier</h3>
                           <div class="form-group">
                               <label for="supplierName" class="text-info">supplierName</label><br>
                               <sform:input path="supplierName" />
                           </div>
                           <div class="form-group">
                               <label for="supplierDescription" class="text-info">supplierDiscription</label><br>
                               <sform:input path="supplierDescription" />
                           </div>
                          <sform:input path="supplierId"  type="hidden"/>
                             <input type="submit"  value="${bname}" />
                             
                            

   </sform:form>
</body>
</html>