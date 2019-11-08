package com.harshad.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("page");
		if (param.equals("login")) {
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		} else if (param.equals("signup")) {
			getServletContext().getRequestDispatcher("/SignUp.jsp").forward(request, response);
		} else if (param.equals("about")) {
			getServletContext().getRequestDispatcher("/About.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/InvalidURL.jsp").forward(request, response);
		}
	}
}
