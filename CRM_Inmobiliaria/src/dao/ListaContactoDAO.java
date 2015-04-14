package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Conexion;
import domain.ListaContacto;

public class ListaContactoDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATLISCON = "SELECT CON_PER_ID, CALL_LST_ID,"
			+ "	TO_CHAR(CREATED,'YYYYMMDD')CREATED,"
			+ "TO_CHAR(LAST_UPD,'YYYYMMDD')LAST_UPD FROM SIEBEL811.S_CALL_LST_CON";
	
	private String SELECT_CATLISCONCTL = "SELECT "
			+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
			+ "TO_CHAR(TRUNC(LAST_UPD),'YYYYMMDD')LAST_UPD, "
			+ "COUNT(TRUNC(LAST_UPD)) AS TOTAL "
			+ "FROM SIEBEL811.S_CALL_LST_CON "
			+ "WHERE LAST_UPD "
			+ "BETWEEN TO_DATE('20140101','YYYYMMDD') "
			+ "AND TO_DATE('20151231','YYYYMMDD') "
			+ "GROUP BY TRUNC(LAST_UPD) "
			+ "ORDER BY LAST_UPD";	

	public List<ListaContacto> listarListasContactos() {
		List<ListaContacto> listarlistascontactos = new ArrayList<ListaContacto>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATLISCON);
			rs = stmt.executeQuery();
			while (rs.next()) {
				listarlistascontactos.add(new ListaContacto(rs.getString(1), rs
						.getString(2), rs.getString(3),"", rs
						.getString(4)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return listarlistascontactos;
	}
	
	public List<ListaContacto> listarListasContactosCtl() {
		List<ListaContacto> listarlistascontactos = new ArrayList<ListaContacto>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATLISCONCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				listarlistascontactos.add(new ListaContacto(rs.getString(1), rs
						.getString(2), rs.getString(3)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return listarlistascontactos;
	}
}