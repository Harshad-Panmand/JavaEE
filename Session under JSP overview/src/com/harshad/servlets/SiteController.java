package com.harshad.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SiteController() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");

		if (userName.equals("Harshad") && userPassword.equals("harshad@123")) {
			request.getSession().invalidate();
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(100);
			response.sendRedirect("AfterLogin.jsp");
		} else {
			response.sendRedirect("Login.jsp");
		}
	}
}
