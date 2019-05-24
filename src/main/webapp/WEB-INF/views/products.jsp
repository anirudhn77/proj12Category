
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@ page isELIgnored="false" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
<sform:form action="addpro" method="Post" modelAttribute="pro" enctype="multipart/form-data" >
   <div id="Products">
       <h3 class="text-center text-white pt-5">Products form</h3>
       <div class="container">
           <div id="Products-row" class="row justify-content-center align-items-center">
               <div id="Products-column" class="col-md-6">
                   <div id="Products-box" class="col-md-12">
                      >
                           <h3 class="text-center text-info">Products</h3>
                           <div class="form-group">
                               <label for="productName" class="text-info">productName</label><br>
                               <sform:input path="productName" />
                           </div>
                           <div class="form-group">
                               <label for="productDescription" class="text-info">productDiscription</label><br>
                               <sform:input path="productDescription" />
                           </div>
                           <div class="form-group">
                               <label for="productPrice" class="text-info">productPrice</label><br>
                               <sform:input path="productPrice" />
                           </div>
                           
                               <label for="productCategory" class="text-info">productCategory</label><br>
                               <sform:select path="productCategory" >
                              <c:forEach var="cat" items="${catlist}">
          
                               <sform:option value="${cat.categoryName}">${cat.categoryName}</sform:option>
                               </c:forEach>
                               </sform:select>
                          
                            <div class="form-group">
                               <label for="productSupplier" class="text-info">productSupplier</label><br>
                               <sform:select path="productSupplier" >
                              <c:forEach var="sup" items="${suplist}">
          
                               <sform:option value="${sup.supplierName}">${sup.supplierName}</sform:option>
                               
                               </c:forEach>
                              </sform:select>
                             </div>
                             </div>
                             </div>
                             </div>
                             </div>
                    
                           </div>
                      
                           
                                    ProductImage
                           <sform:input type="file" path="proimage"/>
                          <sform:input path="productID"  type="hidden"/>
                             <input type="submit"  value="${bname}" />
                             
                             
                            

   </sform:form>
</body>
</html>