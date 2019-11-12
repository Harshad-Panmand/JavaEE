package com.harshad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().print("Name :" + request.getParameter("name") + "<br/>");
		response.getWriter().print("Gender :" + request.getParameter("gender") + "<br/>");
		response.getWriter().print("Known Languages :" + "<br/>");
		PrintWriter out = response.getWriter();
		String[] languages = request.getParameterValues("language");
		if (languages != null) {
			response.getWriter().print(String.join("<br/>", languages));
		} else {
			out.print("Nothing is selected");
		}

		response.getWriter().print("<br/>" + "Country :" + request.getParameter("country"));
	}
}
