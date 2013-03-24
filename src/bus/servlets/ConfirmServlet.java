package bus.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bus.impl.BusReservation;
import bus.interfaces.Reservation;

/**
 * Servlet implementation class ConfirmServlet
 */
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		System.out.println("test null pointer");
		String busNo = request.getParameter("busNo");
		String date = request.getParameter("date");
		if (request.getParameterValues("seat") == null) {
			System.out.println("test null pointer 1");

			response.sendRedirect("selectSeat.jsp?date=" + date + "&bus="
					+ busNo + "&message=please enter");
		} else {
			String[] seats = request.getParameterValues("seat");
			System.out.println("test null pointer 1");
//			if(seats.length==2)
//				seats[2]="00";
//			if(seats.length==2){
//				seats[1]="00";
//				seats[2]="00";
//			}

			Reservation myBus = new BusReservation();
			
			String pnr = myBus.reserveSeat(busNo, seats, date);
			System.out.println(pnr);
			out.println("<html><body>");
			out.println("Your booking details:");
			out.println("<table><tr><td>Ticket No:</td><td>"+pnr+"</td></tr>");
			out.println("<tr><td>From:</td><td></td></tr>");
			out.println("<tr><td>To:</td><td></td></tr>");
			out.println("<tr><td>Date:</td><td>"+date+"</td></tr>");
			out.println("<tr><td>Booked By:</td><td>"+session.getAttribute("username")+"</td></tr>");
			out.println("</table>");
			out.println("</body></html>");
		}
		// RequestDispatcher rd=request.getRequestDispatcher("submit.jsp");
		// rd.forward(request, response);
	}

}
