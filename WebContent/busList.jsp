<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bus.beans.*"%>
<%@ page import="bus.impl.*"%>
<%@ page import="java.util.List"%>

<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function radioCheck() {
		var i=0;
		
		for(var j=0;j<document.getElementsByName("bus").length;j++){
			if(document.getElementsByName("bus")[j].checked)
				i++;
		}
		if(i==0){
			alert("Please select a bus");
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
<%
	out.println("<h3 align='right'>Welcome "
			+ session.getAttribute("username") + "</h3>");
%>

<center>
<table>
	<tr>
		<td align="left"><img src="images/logo.jpg" alt="Logo"
			height="70px" width="150px" /></td>
		<td style="font-size: 20px;">Bus Reservation Project</td>
	</tr>
</table>
<form action="selectSeat.jsp" method="post">
<table border="1">
	<tr>
		<th>BUS NO</th>
		<th>SOURCE</th>
		<th>DESTINATION</th>
		<th>SOURCE TIME</th>
		<th>DESTINATION TIME</th>
		<th>DATE</th>
		<th>SEATS</th>
	</tr>
	<%
		String src = request.getParameter("src");
		String des = request.getParameter("destination");
		String date = request.getParameter("date");

		List<BusBean> buses = new ArrayList<BusBean>();
		BusReservation busReserv = new BusReservation();
		buses = busReserv.getBuses(src, des);
		out.println("<input type='hidden' name='date' value='" + date
				+ "'/>");
		for (BusBean bus : buses) {
	%>
	<tr>
		<td><input type="radio" name="bus" 
			value=<%=bus.getBusno()%> />
		<%
			out.println(bus.getBusno());
		%>
		</td>
		<td>
		<%
			out.println(bus.getSource());
		%>
		</td>
		<td>
		<%
			out.println(bus.getDest());
		%>
		</td>
		<td>
		<%
			out.println(bus.getSrctime());
		%>
		</td>
		<td>
		<%
			out.println(bus.getDesttime());
		%>
		</td>
		<td>
		<%
			out.println(bus.getDate());
		%>
		</td>
		<td>
		<%
			out.println(bus.getSeatno());
		%>
		</td>

	</tr>
	<%
		}
	%>
	<tr><td colspan="7" align="right"><input type="submit" value="Continue" align="right"
	onfocus="radioCheck()" style="border: none; background-color: maroon; color: white; font-size: 15px; border-radius: 5px; height: 25px; font-size: 16px;"/>
	</td></tr>
</table>
</center>
</form>
</body>
</html>