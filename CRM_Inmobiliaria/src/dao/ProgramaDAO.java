package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Conexion;
import domain.Programa;

public class ProgramaDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public List<Programa> listarProgramas() {
		String SELECT_LOYPRO = "SELECT TP.ROW_ID, TP.NAME, TP.DESC_TEXT,"
				+ "TO_CHAR(TP.START_DT,'YYYYMMDD')START_DT, "
				+ "TO_CHAR(TP.END_DT,'YYYYMMDD')END_DT, "
				+ "TP.TXFR_STRT_MTH_CD, TP.PUR_STRT_MTH_CD, TP.REVRECG_PRD_TYP_CD, "
				+ "TP.POINT_EXP_LEVEL_CD,TP.APPLY_CD, TP.REVRECG_PERIOD_DUR, "
				+ "TP.ACTIVE_FLG, TP.PNT_TO_PAY_FLG,TP.PARTNER_FLG, TCC.NAME, TSP.NAME, "
				+ "TO_CHAR(TP.LAST_UPD,'YYYYMMDD')LAST_UPD "
				+ "FROM SIEBEL811.S_LOY_PROGRAM TP, "
				+ "SIEBEL811.S_ORG_EXT TCC, "
				+ "SIEBEL811.S_PARTY TSP "
				+ "WHERE TP.LAST_UPD "
				+ "BETWEEN TO_DATE('20150410','YYYYMMDD') "
				+ "AND TO_DATE('20151213','YYYYMMDD') "
				+ "AND TCC.ROW_ID=TP.HOST_ORG_ID "
				+ "AND TSP.ROW_ID=TP.BU_ID";
		List<Programa> cat_prog = new ArrayList<Programa>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_LOYPRO);
			rs = stmt.executeQuery();
			while (rs.next()) {
				cat_prog.add(new Programa(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9), rs.getString(10), rs.getString(11), rs
						.getString(12), rs.getString(13), rs.getString(14), rs
						.getString(15), rs.getString(16), rs.getString(17)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return cat_prog;
	}
}