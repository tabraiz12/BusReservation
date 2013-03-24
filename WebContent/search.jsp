<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Date"%>
<%@ page import="bus.utility.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus Reservation</title>
</head>
<body>
<%
	out.println("<h3 align='right'>Welcome "
			+ session.getAttribute("username") + "</h3>");
%>
<%
	long time = System.currentTimeMillis();
	long oneDay = 24 * 60 * 60 * 1000;
%>
<center>

<form method="GET" action="busList.jsp">
<table>
	<tr>
		<td align="left"><img src="images/logo.jpg" alt="Logo" /></td>
		<td style="font-size: 20px;">Bus Reservation Project</td>
	</tr>
</table>
<table>
	<tr>
		<td align="left" style="color: grey;">From</td>
		<td align="left" style="color: grey;">To</td>
	</tr>
	<tr>
		<td><input type="text" name="src" /></td>
		<td><input type="text" name="destination" /></td>
	</tr>
	<tr>
		<td align="left" style="color: grey;">Date of journey</td>
	</tr>
	<tr>
		<td align="left"><select name="date">
			<option value=<%=UtilClass.dateConvert(new Date(time))%>><%=UtilClass.dateConvert(new Date(time))%></option>
			<option value=<%=UtilClass.dateConvert(new Date(time + oneDay))%>>
			<%=UtilClass.dateConvert(new Date(time + oneDay))%></option>
			<option value=<%=UtilClass.dateConvert(new Date(time + 2 * oneDay))%>>
			<%=UtilClass.dateConvert(new Date(time + 2 * oneDay))%></option>
			<option value=<%=UtilClass.dateConvert(new Date(time + 3 * oneDay))%>>
			<%=UtilClass.dateConvert(new Date(time + 3 * oneDay))%></option>
			<option value=<%=UtilClass.dateConvert(new Date(time + 4 * oneDay))%>>
			<%=UtilClass.dateConvert(new Date(time + 4 * oneDay))%></option>
		</select></td>
		<td align="right"><input type="submit" value="Search Buses"
			style="border: none; background-color: maroon; color: white; font-size: 15px; border-radius: 5px; height: 25px; font-size: 16px;"></td>
	</tr>
</table>
</form>
</center>
</body>
</html>