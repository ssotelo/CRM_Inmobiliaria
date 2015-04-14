package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Conexion;
import domain.Oferta;

public class OfertaDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATOFE = "SELECT TC.ROW_ID, TOF.ROW_ID, TOF.X_ATTRIB_05,"
			+ " TOF.X_ATTRIB_04, TOF.X_ATTRIB_03, TOF.X_ATTRIB_02, TOF.X_ATTRIB_01, "
			+ "TOF.X_ATTRIB_10, TOF.X_ATTRIB_09,TOF.X_ATTRIB_08, TOF.X_ATTRIB_07,"
			+ "TOF.X_ATTRIB_06, TO_CHAR(TOF.START_DT,'YYYYMMDD')START_DT, "
			+ "TO_CHAR(TR.LAST_UPD,'YYYYMMDD')LAST_UPD FROM SIEBEL.S_SRC TC,"
			+ " SIEBEL.S_SRC_DCP TR, SIEBEL.S_MKTG_OFFR TOF,"
			+ " SIEBEL.S_DMND_CRTN_PRG TT WHERE TC.ROW_ID=TR.SRC_ID "
			+ "AND TT.MKTG_OFFR_ID=TOF.ROW_ID AND TT.ROW_ID=TR.DCP_ID "
			+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN'"
			+ " AND TC.CAMP_TYPE_CD='Campaign' AND TC.MKTG_TMPL_FLG='N'";

	private String SELECT_OFECTL = "SELECT "
			+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
			+ "TO_CHAR(TRUNC(LAST_UPD),'YYYYMMDD')LAST_UPD, "
			+ "COUNT(TRUNC(LAST_UPD)) AS TOTAL "
			+ "FROM SIEBEL811.S_MKTG_OFFR "
			+ "WHERE LAST_UPD "
			+ "BETWEEN TO_DATE('20140101','YYYYMMDD') "
			+ "AND TO_DATE('20151231','YYYYMMDD') "
			+ "GROUP BY TRUNC(LAST_UPD) "
			+ "ORDER BY LAST_UPD";

	public List<Oferta> listarOfertas() {
		List<Oferta> ofertas = new ArrayList<Oferta>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATOFE);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ofertas.add(new Oferta(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return ofertas;
	}

	public List<Oferta> listarOfertasCtl() {
		List<Oferta> ofertas = new ArrayList<Oferta>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_OFECTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ofertas.add(new Oferta(rs.getString(1), rs.getString(2), rs
						.getString(3)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return ofertas;
	}

}
