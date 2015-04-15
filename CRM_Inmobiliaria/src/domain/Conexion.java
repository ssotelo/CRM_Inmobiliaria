package domain;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	/*
	private static String JDBC_DRIVER ="oracle.jdbc.OracleDriver";
	private static String JDBC_URL="jdbc:oracle:thin:@//172.16.204.189:1522/SIEBTST";
	private static String JDBC_USER="sadmin";
	private static String JDBC_PASS="Sadmin123";
	private static Driver driver = null;
	*/
	/*Datos para Sieb desarrollo*/

	private static String JDBC_DRIVER ="oracle.jdbc.OracleDriver";
	private static String JDBC_URL="jdbc:oracle:thin:@//172.16.204.59:1521/SIEBDEV";
	private static String JDBC_USER="DCHAVEZ";
	private static String JDBC_PASS="DCHAVEZ_";
	private static Driver driver = null;

	public static synchronized Connection getConnection() throws SQLException{
		if(driver==null){
			try{
				Class<?> jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			}
			catch(Exception e){
				System.out.println("Falló carga del JDBC");
				e.printStackTrace();
			}
		}
		return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
	}
	
	public static void Close(ResultSet rs){
		try{
			if(rs!= null)	rs.close();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
	
	public static void Close(PreparedStatement stmt){
		try{
			if(stmt!=null)	stmt.close();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
	
	public static void Close(Connection conn){
		try{
			if(conn != null) conn.close();
		}catch(SQLException sqle){sqle.printStackTrace();}
	}
}