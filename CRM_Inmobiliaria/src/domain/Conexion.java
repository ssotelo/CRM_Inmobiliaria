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
	/*
	private static String JDBC_DRIVER ="oracle.jdbc.OracleDriver";
	private static String JDBC_URL="jdbc:oracle:thin:@//172.16.204.189:1522/SIEBTST";
	private static String JDBC_USER="sadmin";
	private static String JDBC_PASS="Sadmin123";
	private static Driver driver = null;
	*/
	/*Datos para Sieb desarrollo*/
	
	private static String JDBC_DRIVER ="oracle.jdbc.OracleDriver" ;
	private static String JDBC_URL = null;
	private static String JDBC_USER = null;
	private static String JDBC_PASS = null;
	private static Driver driver = null;
	public static synchronized Connection getConnection() throws SQLException{
		     	
    	Properties prop = new Properties();
    	InputStream configFile = null;
		try {
			configFile = new FileInputStream("config.cfg"); //	configFile = new FileInputStream(args[0]);	
			prop.load(configFile);
			String URL = prop.getProperty("URL_BD");
			System.out.println("Conexion: " + URL);
			JDBC_USER = prop.getProperty("USER_BD");
			System.out.println("Usuario: " + JDBC_USER);
			JDBC_PASS = prop.getProperty("PWD_BD");
			System.out.println("Contraseña: " + JDBC_PASS);
			JDBC_URL = "jdbc:oracle:thin:@//"+ URL;         
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		if(driver==null){
			try{
				Class<?> jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			}
			catch(Exception e){
				System.out.println("Fallo carga del JDBC");
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