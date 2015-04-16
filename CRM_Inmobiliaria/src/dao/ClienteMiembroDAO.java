package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ClienteMiembro;
import domain.Conexion;

public class ClienteMiembroDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public List<ClienteMiembro> listarClientesMiembros(String FecIni, String FecFin) {
		String SELECT_CATMIE = "SELECT TR.PER_ID, TR.MEMBER_ID, "
				+ "TO_CHAR(TR.LAST_UPD,'YYYYMMDD')LAST_UPD "
				+ "FROM SIEBEL811.S_LOY_MEM_CON TR, "
				+ "SIEBEL811.S_CONTACT TC, SIEBEL811.S_LOY_MEMBER TM "
				+ "WHERE TR.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.ROW_ID = TR.PER_ID "
				+ "AND TM.ROW_ID = TR.MEMBER_ID";
		List<ClienteMiembro> clientesmiembros = new ArrayList<ClienteMiembro>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATMIE);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clientesmiembros.add(new ClienteMiembro(rs.getString(1), rs
						.getString(2), rs.getString(3)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clientesmiembros;
	}
}