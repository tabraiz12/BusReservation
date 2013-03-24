package bus.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class regiseterser extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/reg", "root", "root");
			Statement stmt = con.createStatement();
			String name = req.getParameter("Name");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String address = req.getParameter("address");
			String dob = req.getParameter("dob");
			// String DOB=1990-09-24;
			int acc_no = Integer.parseInt(req.getParameter("acc_no"));
			String email_id = req.getParameter("email_id");
			int ph_no = Integer.parseInt(req.getParameter("ph_no"));
			String str = "insert into register values('" + name + "','"
					+ username + "','" + password + "','" + address + "','"
					+ dob + "','" + acc_no + "','" + email_id + "','" + ph_no
					+ "')";

			stmt.executeUpdate(str);
		    RequestDispatcher rd= req.getRequestDispatcher("login.html");
		    rd.forward(req,res);
		} catch (Exception e) {
			pw.println(e);
		}
	}
}
