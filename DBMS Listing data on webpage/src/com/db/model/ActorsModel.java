package com.db.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.db.entity.Actor;

public class ActorsModel {

	public List<Actor> listActors(DataSource dataSource) {

		List<Actor> listActors = new ArrayList<>();

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
				listActors.add(new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getTimestamp("last_update")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listActors;
	}
}
