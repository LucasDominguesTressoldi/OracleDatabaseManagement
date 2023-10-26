package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static final String URL = "jdbc:oracle:thin:@oracle.YOUR_BD:1521:orcl";
	private static final String USER = "USER";
	private static final String PSWD = "PSSWD";

	public static Connection openConnection() {

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(URL, USER, PSWD);
			
			System.out.println("Connected!");
		} catch (ClassNotFoundException e) {
			System.err.println("Class Not Found!");
		} catch (SQLException e) {
			System.err.println("Connection Error!\nRead the error messagee below:\n");
			e.printStackTrace();
		}

		return conn;
	}

}
