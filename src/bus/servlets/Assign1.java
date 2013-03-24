package bus.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Assign1
 */
public class Assign1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assign1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();

		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","root");
		Statement st=con.createStatement();
		String name=req.getParameter("username");
		String pass=req.getParameter("password");
		pw.println(name);
		pw.println(pass);
		ResultSet rs=st.executeQuery("select * from register");
		while(rs.next())
		{
		String user_name=rs.getString("username");
		String pass_word=rs.getString("password");
		if(name.equals(user_name) && pass.equals(pass_word))
		{
		RequestDispatcher ds=req.getRequestDispatcher("search.html");
		ds.forward(req,res);
		pw.println("password matched");
		}
		else

		pw.println("enter correct username and password");
		}
		}
		catch(Exception e)
		{

		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
