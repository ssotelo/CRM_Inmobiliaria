package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Conexion;
import domain.Contacto;

public class ContactoDAO {
	private Connection userConn=null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATCON = "SELECT ROW_ID, SOC_SECURITY_NUM, X_ATTRIB_18, X_ATTRIB_19,"
			+ " X_ATTRIB_20, X_ATTRIB_23, X_ATTRIB_24, X_ATTRIB_10, X_ATTRIB_01, X_ATTRIB_02, "
			+ "X_ATTRIB_36,X_ATTRIB_37, X_ATTRIB_38, X_ATTRIB_39,X_ATTRIB_03, X_ATTRIB_04, "
			+ "X_ATTRIB_05, X_ATTRIB_11, X_ATTRIB_09, SUPPRESS_CALL_FLG, "
			+ "SUPPRESS_EMAIL_FLG, SUPPRESS_MAIL_FLG, "
			+ "TO_CHAR(LAST_UPD,'YYYYMMDD')LAST_UPD FROM SIEBEL811.S_CONTACT";
	

	public List<Contacto> listarContactos() {
		List<Contacto> contactos = new ArrayList<Contacto>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
			stmt = conn.prepareStatement(SELECT_CATCON);
			rs = stmt.executeQuery();
			while (rs.next()) {
				contactos.add(new Contacto(rs.getString(1), rs.getString(2),
						rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),
						rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),
						rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),
						rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),
						rs.getString(23)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return contactos;
	}
}
