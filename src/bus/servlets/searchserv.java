package bus.servlets;






import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


public class searchserv extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
	    String src=req.getParameter("src");
		String des=req.getParameter("des");
		String date=req.getParameter("date");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","root");
		Statement stmt=con.createStatement();
		out.println("con");
		ResultSet rs=stmt.executeQuery("select * from searchbus");
		while(rs.next())
		{
		String busno=rs.getString(1);
		String src1=rs.getString(2);
		String des1=rs.getString(3);
		String srct=rs.getString(4);
		String dest=rs.getString(5);
		String date1=rs.getString(6);
		String seat=rs.getString(7);
		if((src==src1)&&(des==des1)&&(date==date1))
		{
			out.println("<html><body>");
			out.println("<table><tr><td>Bus No<\td><td>"+busno+"</td></tr>" +
					"<tr><td>Source</td><td>"+src1+"</td></tr>" +
					"<tr><td>Destination</td><td>"+des1+"</td></tr>" +
					"<tr><td>Source Time</td><td>"+srct+"</td></tr>" +
					"<tr><td>Destination Time</td><td>"+dest+"</td></tr>" +
					"<tr><td>Date of Journey</td><td>"+date1+"</td></tr>" +
					"<tr><td>No of Seats available</td><td>"+seat+"</td></tr></table>");
			        
		}
		}
		}
		catch (Exception e) {
						e.printStackTrace();
		}
	}
}
