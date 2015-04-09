package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CanalComunicacion;
import domain.Conexion;

public class CanalComunicacionDAO {
	private Connection userConn=null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATCANCOM = "SELECT ORDER_BY, VAL "
			+ "FROM SIEBEL811.S_LST_OF_VAL "
			+ "WHERE ACTIVE_FLG='Y' AND TYPE='OFFER_MEDIA' "
			+ "ORDER BY ORDER_BY";
	

	public List<CanalComunicacion> listarCanalesComunicacion() {
		List<CanalComunicacion> cc = new ArrayList<CanalComunicacion>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
			stmt = conn.prepareStatement(SELECT_CATCANCOM);
			rs = stmt.executeQuery();
			while (rs.next()) {
				cc.add(new CanalComunicacion(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return cc;
	}
}
