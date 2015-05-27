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

import domain.Lista;

public class ListaDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<Lista> listarListas(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATLIS = "SELECT TLS.ROW_ID, NAME, TLS.DESC_TEXT, "
				+ "TLS.SUBTYPE_CD, TLS.STATUS_CD, TLS.CALL_LST_NUM, TLS.FILE_NAME, "
				+ "TU.LOGIN, TO_CHAR(TRUNC(TLS.LAST_UPD),'YYYYMMDD')LAST_UPD "
				+ "FROM SIEBEL.S_CALL_LST TLS "
				+ "LEFT OUTER JOIN SIEBEL.S_USER TU "
				+ "ON TLS.LAST_UPD_BY=TU.ROW_ID "
				+ "WHERE TLS.LAST_UPD "
				+ "BETWEEN TO_DATE('20150101','YYYYMMDD') "
				+ "AND TO_DATE('20151231','YYYYMMDD')";
		List<Lista> listas = new ArrayList<Lista>();
		try {
			stmt = conn.prepareStatement(SELECT_CATLIS);
			rs = stmt.executeQuery();
			while (rs.next()) {
				listas.add(new Lista(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return listas;
	}
	
	public List<Lista> listarListasCtl(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_LISCTL = "SELECT "
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "COUNT(TRUNC(LAST_UPD)) AS TOTAL "
				+ "FROM " + DBO + ".S_CALL_LST "
				+ "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "GROUP BY TRUNC(LAST_UPD) "
				+ "ORDER BY LAST_UPD";
		List<Lista> listas = new ArrayList<Lista>();
		try {
			stmt = conn.prepareStatement(SELECT_LISCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				listas.add(new Lista(rs.getString(1), rs.getString(2), rs
						.getString(3)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return listas;
	}
}