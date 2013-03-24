package bus.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*; //import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Assign1
 */
public class UserValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserValidationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		HttpSession session=req.getSession();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/reg", "root", "root");
			Statement st = con.createStatement();
			String name = req.getParameter("username");
			String pass = req.getParameter("password");
			//pw.println(name);
			//pw.println(pass);
			ResultSet rs = st
					.executeQuery("select * from register where username='"
							+ name + "' and password='" + pass+"'");
			System.out.println("testing servlet");
			if (rs.next()) {
				session.setAttribute("username", name);
				
				RequestDispatcher ds = req.getRequestDispatcher("search.jsp");
				ds.forward(req, res);
				//pw.println("password matched");
			} else {
				pw.println("Incorrect Login! Please Re-Enter");
				RequestDispatcher ds = req.getRequestDispatcher("login.html");
				ds.include(req, res);
			}

		} catch (Exception e) {

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
