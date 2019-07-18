<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Location</title>
</head>
<body>
${location.type}
${location.type=='URBAN'?'URBAN':''}
<form action ="updateLoc" method="POST" />
<pre>
Id :<input type="text" name="id" value="${location.id}" readonly/>
code :<input type="text" name="code" value="${location.code}"/>
name :<input type="text" name="name" value="${location.name}"/>
Type :Urban<input type="radio" name="type" value="URBAN" ${location.type=='URBAN'?'URBAN':''}/>
      Rural<input type="radio" name="type" value="RURAL" ${location.type=='RURAL'?'RURAL':''}/>
 <input type="submit" value="Save">    
 </pre> 
 ${msg}
</form>

<a href="displayLocations">View All</a>
</body>
</html>