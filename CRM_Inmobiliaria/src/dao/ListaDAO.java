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
	private String SELECT_CATGEN = "SELECT TLS.ROW_ID, NAME, TLS.DESC_TEXT, "
			+ "TLS.X_SUBTYPE_NUM, TLS.STATUS_CD, TLS.CALL_LST_NUM, TLS.FILE_NAME, "
			+ "TU.LOGIN, TO_CHAR(TLS.LAST_UPD,'YYYYMMDD')LAST_UPD "
			+ "FROM SIEBEL.S_CALL_LST TLS LEFT OUTER JOIN SIEBEL.S_USER TU "
			+ "ON TLS.LAST_UPD_BY=TU.ROW_ID";

	public List<Lista> listarListas() {
		List<Lista> listas = new ArrayList<Lista>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATGEN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				listas.add(new Lista(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return listas;
	}
}
