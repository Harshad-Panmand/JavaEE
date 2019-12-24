package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Demo
 */
@WebServlet(description = "Servlet used for database connection", urlPatterns = { "/Demo" })
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// Step 1 : Initialize connection object
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();

			// Step 2 : Create a SQL statement string
			String query = "select * from actor";
			stmt = conn.createStatement();

			// Step 3 : Execute SQL query
			rs = stmt.executeQuery(query);

			// Step 4 : Process the result set
			while (rs.next()) {
				out.print("<br>" + rs.getString("actor_id") + ", " + rs.getString("first_name") + ", "
						+ rs.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
