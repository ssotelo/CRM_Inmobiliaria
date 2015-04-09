package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ClienteDireccionVirtual;
import domain.Conexion;

public class ClienteDireccionVirtualDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATDIRV = "SELECT DISTINCT PER_ID, COMM_MEDIUM_CD, ADDR, "
			+ "TO_CHAR(LAST_UPD,'YYYYMMDD')LAST_UPD "
			+ "FROM SIEBEL811.S_PER_COMM_ADDR "
			+ "UNION "
			+ "SELECT DISTINCT ROW_ID,'Twitter',X_ID_TWITTER, "
			+ "TO_CHAR(LAST_UPD,'YYYYMMDD')LAST_UPD "
			+ "FROM SIEBEL811.S_CONTACT "
			+ "UNION "
			+ "SELECT DISTINCT ROW_ID,'Facebook',X_ID_TWITTER, "
			+ "TO_CHAR(LAST_UPD,'YYYYMMDD')LAST_UPD "
			+ "FROM SIEBEL811.S_CONTACT";

	public List<ClienteDireccionVirtual> listarClientesDireccionesVirtuales() {
		List<ClienteDireccionVirtual> clientesdireccionesvirtuales = new ArrayList<ClienteDireccionVirtual>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATDIRV);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clientesdireccionesvirtuales.add(new ClienteDireccionVirtual(rs
						.getString(1), rs.getString(2), rs.getString(3), rs
						.getString(4)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clientesdireccionesvirtuales;
	}
}
