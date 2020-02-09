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

@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");

		page = page.toLowerCase();

		switch (page) {
		case "listactors":
			listActors(request, response);
			break;

		case "addactors":
			addActorFormLoader(request, response);
			break;

		case "updateactors":
			updateActorFormLoader(request, response);
			break;
		default:
			errorPage(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();

		switch (operation) {
		case "addactoroperation":
			Actor newActor = new Actor(request.getParameter("firstname"), request.getParameter("lastname"));
			addActorOperation(newActor);
			listActors(request, response);
			break;

		case "updateactoroperation":
			Actor updateActor = new Actor(Integer.parseInt(request.getParameter("actorId")),request.getParameter("firstname"), request.getParameter("lastname"));
			updateActorOperation(updateActor);
			listActors(request, response);
			break;
		default:
			errorPage(request, response);
		}

	}

	private void updateActorOperation(Actor updateActor) {
		new ActorsModel().updateActor(dataSource, updateActor);
	}

	private void addActorOperation(Actor newActor) {
		new ActorsModel().addActor(dataSource, newActor);
	}

	public void listActors(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Actor> listActors = new ArrayList<>();
		listActors = new ActorsModel().listActors(dataSource);
		request.setAttribute("listActors", listActors);
		request.setAttribute("title", "List Actors Page");
		request.getRequestDispatcher("listActors.jsp").forward(request, response);
	}

	public void addActorFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("title", "Add Actors Page");
		request.getRequestDispatcher("addActors.jsp").forward(request, response);
	}
	
	public void updateActorFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("title", "Update Actors Page");
		request.getRequestDispatcher("updateActors.jsp").forward(request, response);
	}

	public void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("title", "Error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
}
