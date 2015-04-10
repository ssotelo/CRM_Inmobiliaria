package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CampannaOferta;
import domain.Conexion;

public class CampannaOfertaDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATGEN = "SELECT TC.ROW_ID, TOF.ROW_ID, TOF.X_ATTRIB_05, TOF.X_ATTRIB_04, "
			+ "TOF.X_ATTRIB_03, TOF.X_ATTRIB_02, TOF.X_ATTRIB_01, TOF.X_ATTRIB_10, TOF.X_ATTRIB_09,"
			+ "TOF.X_ATTRIB_08, TOF.X_ATTRIB_07,TOF.X_ATTRIB_06, "
			+ "TO_CHAR(TOF.START_DT,'YYYYMMDD')START_DT, TO_CHAR(TR.LAST_UPD,'YYYYMMDD')LAST_UPD,"
			+ "TT.X_ID_TREAT, TT.NAME, TT.OFFER_NUM "
			+ "FROM SIEBEL.S_SRC TC, SIEBEL.S_SRC_DCP TR, "
			+ "SIEBEL.S_MKTG_OFFR TOF, SIEBEL.S_DMND_CRTN_PRG TT "
			+ "WHERE TC.ROW_ID=TR.SRC_ID AND TT.MKTG_OFFR_ID=TOF.ROW_ID "
			+ "AND TT.ROW_ID=TR.DCP_ID AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
			+ "AND TC.CAMP_TYPE_CD='Campaign' AND TC.MKTG_TMPL_FLG='N'";

	public List<CampannaOferta> listarCampannasOfertas() {
		List<CampannaOferta> campoffr = new ArrayList<CampannaOferta>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATGEN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campoffr.add(new CampannaOferta(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5), rs.getString(6), rs.getString(7), rs
						.getString(8), rs.getString(9), rs.getString(10), rs
						.getString(11), rs.getString(12), rs.getString(13), rs
						.getString(14), rs.getString(15), rs.getString(16), rs
						.getString(17)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campoffr;
	}
}
