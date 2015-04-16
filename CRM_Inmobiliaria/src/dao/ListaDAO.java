package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Conexion;
import domain.Lista;

public class ListaDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public List<Lista> listarListas(String FecIni, String FecFin, String cfg) {
		String DBO = "SIEBEL811";
		String SELECT_CATLIS = "SELECT TLS.ROW_ID, NAME, TLS.DESC_TEXT, "
				+ "TLS.X_SUBTYPE_NUM, TLS.STATUS_CD, TLS.CALL_LST_NUM, TLS.FILE_NAME, "
				+ "TU.LOGIN, TO_CHAR(TRUNC(TLS.LAST_UPD),'YYYYMMDD')LAST_UPD "
				+ "FROM " + DBO + ".S_CALL_LST TLS "
				+ "LEFT OUTER JOIN " + DBO + ".S_USER TU "
				+ "ON TLS.LAST_UPD_BY=TU.ROW_ID "
				+ "WHERE TLS.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD')";
		List<Lista> listas = new ArrayList<Lista>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection(cfg);
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
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return listas;
	}
	
	public List<Lista> listarListasCtl(String FecIni, String FecFin, String cfg) {
		String DBO = "SIEBEL811";
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
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection(cfg);
			stmt = conn.prepareStatement(SELECT_LISCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				listas.add(new Lista(rs.getString(1), rs.getString(2), rs
						.getString(3)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return listas;
	}
}