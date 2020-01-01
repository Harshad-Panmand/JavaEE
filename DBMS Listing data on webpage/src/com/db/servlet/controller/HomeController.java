package com.db.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.db.entity.Actor;
import com.db.model.ActorsModel;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/project")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");

		page = page.toLowerCase();

		switch (page) {
		case "home":
			request.setAttribute("title", "Home Page");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;

		case "listactors":
			List<Actor> listActors = new ArrayList<>();
			listActors = new ActorsModel().listActors(dataSource);
			request.setAttribute("listActors", listActors);
			request.setAttribute("title", "List Actors Page");
			request.getRequestDispatcher("listActors.jsp").forward(request, response);
			break;

		default:
			request.setAttribute("title", "Error Page");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}
}
