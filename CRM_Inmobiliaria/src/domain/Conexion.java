package domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	private static String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
	private static String JDBC_URL = null;
	private static String JDBC_USER = null;
	private static String JDBC_PASS = null;
	private static Driver driver = null;

	public static synchronized Connection getConnection(String cfg)
			throws SQLException {

		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);

			prop.load(configFile);
			String URL = prop.getProperty("URL_BD");
			JDBC_USER = prop.getProperty("USER_BD");
			JDBC_PASS = prop.getProperty("PWD_BD");
			JDBC_URL = "jdbc:oracle:thin:@//" + URL;
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		if (driver == null) {
			try {
				Class<?> jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			} catch (Exception e) {
				System.out.println("Fallo carga del JDBC");
				e.printStackTrace();
			}
		}
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}

	public static void Close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void Close(PreparedStatement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void Close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}