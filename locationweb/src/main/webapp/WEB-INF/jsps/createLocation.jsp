<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Location</title>
</head>
<body>

<form action ="saveLoc" method="POST" />
<pre>
Id :<input type="text" name="id"/>
code :<input type="text" name="code"/>
name :<input type="text" name="name"/>
Type :Urban<input type="radio" name="type" value="URBAN"/>
      Rural<input type="radio" name="type" value="RURAL"/>
 <input type="submit" value="Save">    
 </pre> 
 ${msg}
</form>

<a href="displayLocations">View All</a>
</body>
</html>