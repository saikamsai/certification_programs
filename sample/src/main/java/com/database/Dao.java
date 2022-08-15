package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.simplilearn.workshop.util.StringUtil;

public class Dao {
	public Connection con = null;
	public Statement st = null;

	public Dao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/flyaway", "root", "23@Swetha");
		System.out.println("connection established with database");
		st = con.createStatement();
	}

	public List<String[]> getAvailableFlights(String from, String to, String datef) {

		List<String[]> flights = new ArrayList<>();
		String query = "SELECT * FROM flights where fromf='" + from + "' and tof='" + to + "' and datef='" + datef
				+ "'";
		try {
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				String[] flight = new String[11];
				flight[0] = rs.getString("name");
				flight[1] = rs.getString("code");
				flight[2] = rs.getString("fleetsize");
				flight[3] = rs.getString("hub");
				flight[4] = rs.getString("type");
				flight[5] = rs.getString("fromf");
				flight[6] = rs.getString("tof");
				flight[7] = rs.getString("datef");
				flight[8] = rs.getString("timef");
				flight[9] = rs.getString("price");
				flights.add(flight);
				return flights;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public HashMap<String, String> checkUser(String email, String password) {

		HashMap<String, String> user = null;
		String query = "select * from user where email='" + email + "' and password='" + password + "'";
		try {
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				user = new HashMap<>();
				user.put("name", rs.getString("name"));
				user.put("email", rs.getString("email"));
				user.put("phno", rs.getString("phno"));
				user.put("adno", rs.getString("adno"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public boolean insertUser(HashMap<String, String> user) {

		String query = "INSERT INTO user (email, password, name, phno, adno) values('" + user.get("email") + "','"
				+ user.get("password") + "','" + user.get("name") + "','" + user.get("phno") + "','" + user.get("adno")
				+ "')";

		try {
			st.execute(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkAdmin(String email, String password) {

		try {
			ResultSet rs = st
					.executeQuery("select * from admin where email='" + email + "' and password='" + password + "'");
			if (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeAdminPassword(String email, String password) {

		try {
			ResultSet rs = st.executeQuery("select * from admin where email='" + email + "'");
			if (!rs.next()) {
				return false;
			}
			st.execute("update admin set password='" + password + "' where email='" + email + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertFlight(HashMap<String, String> flight) throws SQLException {
		String query1 = "INSERT INTO flights (name,code,fleetsize,hub,type, fromf, tof, datef, timef, price) VALUES"
				+ " ('" + StringUtil.fixSqlFieldValue(flight.get("name")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("code")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("fleetsize")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("hub")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("type")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("from")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("to")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("date")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("time")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("price")) + "')";

		System.out.println(flight.get("date"));
		System.out.println(flight.get("time"));
		try {
			// stm.execute();
			st.execute(query1);
			return true;
		} catch (SQLException e) {
			System.out.print("error");
			e.printStackTrace();
		}
		return false;
	}

}
