package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Conexion;
import domain.Direccion;

public class DireccionDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public List<Direccion> listarDirecciones(String FecIni, String FecFin, String cfg) {
		String DBO = "SIEBEL811";
		String SELECT_CATDIR = "SELECT DISTINCT X_DES_CITY, CITY, "
				+ "X_DES_STA, STATE, COUNTRY "
				+ "FROM " + DBO + ".S_ADDR_PER "
				+ "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD')";
		List<Direccion> dirs = new ArrayList<Direccion>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection(cfg);
			stmt = conn.prepareStatement(SELECT_CATDIR);
			rs = stmt.executeQuery();
			while (rs.next()) {
				dirs.add(new Direccion(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return dirs;
	}
}