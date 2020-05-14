package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String name = request.getParameter("userName");
			out.print("Welcome" + name);

			HttpSession session = request.getSession();
			session.setAttribute("uname", name);
			
			String servletURL = response.encodeUrl("servlet2");
			out.print("<a href=\""+servletURL+"\">Next</a>");
			
			out.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
