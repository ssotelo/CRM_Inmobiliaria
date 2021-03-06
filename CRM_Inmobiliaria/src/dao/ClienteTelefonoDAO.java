package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ClienteTelefono;
import domain.Conexion;

public class ClienteTelefonoDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATTEL = "SELECT DISTINCT TC.ROW_ID, TN.ADDR, TN.COMM_USE_TYPE_CD,"
			+ "TN.X_EXTENSION, TO_CHAR(TN.LAST_UPD,'YYYYMMDD')LAST_UPD "
			+ "FROM SIEBEL811.S_CONTACT TC, SIEBEL811.S_PER_COMM_ADDR TN "
			+ "WHERE TC.ROW_ID=TN.PER_ID "
			+ "AND TN.COMM_MEDIUM_CD='Phone' ";

	public List<ClienteTelefono> listarClientestelefonos() {
		List<ClienteTelefono> clientestelefonos = new ArrayList<ClienteTelefono>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATTEL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clientestelefonos.add(new ClienteTelefono(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clientestelefonos;
	}
}
