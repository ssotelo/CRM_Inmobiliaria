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
	private String SELECT_CATLCNT = "SELECT CON_PER_ID, CALL_LST_ID,"
			+ "	TO_CHAR(CREATED,'YYYYMMDD')CREATED,"
			+ "TO_CHAR(LAST_UPD,'YYYYMMDD')LAST_UPD FROM SIEBEL.S_CALL_LST_CON";

	public List<ListaContacto> listarListasContactos() {
		List<ListaContacto> listarlistascontactos = new ArrayList<ListaContacto>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATLCNT);
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
}