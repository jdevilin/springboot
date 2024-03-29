<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Flight</title>
</head>
<body>
<h2>Flight:</h2>
<table>
<tr><th>Airlines</th>
<th>Departure City</th>
<th>Departure Time</th>
</tr>

<c:forEach items="${flights}" var="flight">
<tr>
<td>${flight.operatingAirlines}</td>
<td>${flight.depatureCity}</td>
<td>${flight.arrivalCity}</td>
<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
</tr>

</c:forEach>

</table>
</body>
</html>