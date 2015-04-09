package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Conexion;
import domain.Miembro;

public class MiembroDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_MEMBER = "SELECT TM.ROW_ID, TM.PROGRAM_ID, TR.PER_ID, "
			+ "TM.ACCRUAL_TYPE_CD, TC.X_BNN_SOURCE, TM.START_DT, TM.EXPIRY_DT, TM.LAST_TXN_PROCED_DT,"
			+ "TM.MEM_NUM, TM.MEM_TYPE_CD, TM.STATUS_CD, TM.MEMSHIP_SCHEME_ID, TM.VAL_SCORE, "
			+ "TM.POINT_TYPE_A_VAL, TM.POINT_TYPE_B_VAL,"
			+ "TM.POINT_TYPE_C_VAL, TM.POINT_TYPE_D_VAL, TC.X_GALLERY, TM.LAST_UPD "
			+ "FROM SIEBEL811.S_LOY_MEM_CON TR, SIEBEL811.S_CONTACT TC, SIEBEL811.S_LOY_MEMBER TM "
			+ "WHERE TC.ROW_ID = TR.PER_ID " + "AND TM.ROW_ID = TR.MEMBER_ID";

	public List<Miembro> listarMiembros() {
		List<Miembro> miembros = new ArrayList<Miembro>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_MEMBER);
			rs = stmt.executeQuery();
			while (rs.next()) {
				miembros.add(new Miembro(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9), rs.getString(10), rs.getString(11), rs
						.getDouble(12), rs.getDouble(13), rs.getDouble(14), rs
						.getDouble(15), rs.getDouble(16), rs.getString(17), rs
						.getString(18)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return miembros;
	}
}
