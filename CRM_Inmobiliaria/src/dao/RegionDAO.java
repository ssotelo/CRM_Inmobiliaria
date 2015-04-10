package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Conexion;
import domain.Region;

public class RegionDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATREG = "SELECT ROW_ID, NAME FROM SIEBEL.S_REGION";

	public List<Region> listarRegiones() {
		List<Region> regiones = new ArrayList<Region>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATREG);
			rs = stmt.executeQuery();
			while (rs.next()) {
				regiones.add(new Region(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return regiones;
	}
}
