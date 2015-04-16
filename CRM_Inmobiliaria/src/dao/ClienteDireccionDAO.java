package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import domain.ClienteDireccion;
import domain.Conexion;

public class ClienteDireccionDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;	
	private ResultSet rs = null;
	SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");

	public List<ClienteDireccion> listarClientesDirecciones(String FecIni, String FecFin) {
		String SELECT_CATDIR = "SELECT TC.ROW_ID, TD.ROW_ID, "
				+ "TD.ADDR, TD.ADDR_NUM, "
				+ "TD.ADDR_LINE_5, TD.ADDR_LINE_3, "
				+ "TD.ZIPCODE, TD.PROVINCE, TD.CITY, "
				+ "TD.STATE, TD.COUNTRY, "
				+ "TO_CHAR(TD.LAST_UPD,'YYYYMMDD')LAST_UPD "
				+ "FROM SIEBEL811.S_CONTACT TC, "
				+ "SIEBEL811.S_ADDR_PER TD, SIEBEL811.S_CON_ADDR TR "
				+ "WHERE TD.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.ROW_ID=TR.CONTACT_ID " 
				+ "AND TR.ADDR_PER_ID=TD.ROW_ID";
		List<ClienteDireccion> clientesdirecciones = new ArrayList<ClienteDireccion>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATDIR);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clientesdirecciones.add(new ClienteDireccion(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4), rs
								.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs
								.getString(10), rs.getString(11), rs
								.getString(12)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clientesdirecciones;
	}
}