package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.Conexion;
import domain.Contacto;

public class ContactoDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<Contacto> listarContactos(String FecIni, String FecFin, String cfg) {
		
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATCON = "SELECT ROW_ID, SOC_SECURITY_NUM, "
				+ "X_ATTRIB_18, X_ATTRIB_19,"
				+ " X_ATTRIB_20, X_ATTRIB_23, X_ATTRIB_24, "
				+ "X_ATTRIB_10, X_ATTRIB_01, X_ATTRIB_02, "
				+ "X_ATTRIB_36,X_ATTRIB_37, X_ATTRIB_38, X_ATTRIB_39, "
				+ "X_ATTRIB_03, X_ATTRIB_04, "
				+ "X_ATTRIB_05, X_ATTRIB_11, X_ATTRIB_09, SUPPRESS_CALL_FLG, "
				+ "SUPPRESS_EMAIL_FLG, SUPPRESS_MAIL_FLG, "
				+ "TO_CHAR(LAST_UPD,'YYYYMMDD')LAST_UPD FROM " + DBO + ".S_CONTACT "
				+ "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD')";
		List<Contacto> contactos = new ArrayList<Contacto>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection(cfg);
			stmt = conn.prepareStatement(SELECT_CATCON);
			rs = stmt.executeQuery();
			while (rs.next()) {
				contactos.add(new Contacto(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9), rs.getString(10), rs.getString(11), rs
						.getString(12), rs.getString(13), rs.getString(14), rs
						.getString(15), rs.getString(16), rs.getString(17), rs
						.getString(18), rs.getString(19), rs.getString(20), rs
						.getString(21), rs.getString(22), rs.getString(23)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return contactos;
	}
	
	public List<Contacto> listarContactosCtl(String FecIni, String FecFin, String cfg) {
		
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CONCTL = "SELECT "
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "COUNT(TRUNC(LAST_UPD)) AS TOTAL "
				+ "FROM " + DBO + ".S_CONTACT "
				+ "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "GROUP BY TRUNC(LAST_UPD) "
				+ "ORDER BY LAST_UPD";
		List<Contacto> contactos = new ArrayList<Contacto>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection(cfg);
			stmt = conn.prepareStatement(SELECT_CONCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				contactos.add(new Contacto(rs.getString(1), rs.getString(2), rs
						.getString(3)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return contactos;
	}
}