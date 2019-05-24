<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="receiveform" modelAttribute="registerform">
EmailAddress<sform:input path="email"/>
Password<sform:input path="password" type="password"/>
Username<sform:input path="username"/>
MobileNumber<sform:input path="mobileno"/>
Address<sform:input path="address"/>
<input type="submit" value="Go"/>


</sform:form>

</body>
</html>