package de.finnsdevecke.mainclasses;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
	static java.sql.Connection conn = null;

	public static void connectToBank() {

		String hostname = "localhost";
		String port = "3306";
		String dbname = "bankdb";
		String user = "root";
		String password = "";

		String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;
		try {
			System.out.println("*Treiber laden");
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			System.out.println(Class.forName("org.gjt.mm.mysql.Driver"));
			System.out.println(Class.forName("org.gjt.mm.mysql.Driver")
					.newInstance());
		} catch (Exception e) {
			System.err.println("Unable to load driver");
			e.printStackTrace();
		}

		try {
			System.out.println("* Verbindung aufbauen");
			conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();

		} catch (SQLException sqle) {

			System.out.println("SQLException: " + sqle.getMessage());
			System.out.println("SQLState: " + sqle.getSQLState());
			System.out.println("VendorError: " + sqle.getErrorCode());
			sqle.printStackTrace();
		}
	}

	public static void connectToUsers() {
		String hostname2 = "localhost";
		String port2 = "3306";
		String dbname2 = "userdb";
		String user2 = "root";
		String password2 = "";

		String url = "jdbc:mysql://" + hostname2 + ":" + port2 + "/" + dbname2;

		java.sql.Connection conn = null;

		try {
			System.out.println("*Treiber laden");
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			System.out.println(Class.forName("org.gjt.mm.mysql.Driver"));
			System.out.println(Class.forName("org.gjt.mm.mysql.Driver")
					.newInstance());
		} catch (Exception e) {
			System.err.println("Unable to load driver");
			e.printStackTrace();
		}

		try {
			System.out.println("* Verbindung aufbauen");
			conn = DriverManager.getConnection(url, user2, password2);
			Statement stmt = conn.createStatement();
		} catch (SQLException sqle) {

			System.out.println("SQLException: " + sqle.getMessage());
			System.out.println("SQLState: " + sqle.getSQLState());
			System.out.println("VendorError: " + sqle.getErrorCode());
			sqle.printStackTrace();
		}
	}
}
