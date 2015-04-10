package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CampannaOfertaCanal;
import domain.Conexion;

public class CampannaOfertaCanalDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATGEN = "SELECT TOF.ROW_ID, TT.MEDIA_TYPE_CD, TC.ROW_ID, TOF.APPR_STAT_CD,"
			+ "	TT.COST, TO_CHAR(TT.START_DT,'YYYYMMDD')START_DT, TO_CHAR(TT.END_DT,'YYYYMMDD')END_DT,"
			+ " TO_CHAR(TC.LAST_UPD,'YYYYMMDD')LAST_UPD, TT.X_ID_TREAT, TT.NAME FROM SIEBEL.S_SRC TC,"
			+ " SIEBEL.S_MKTG_OFFR TOF, SIEBEL.S_SRC_DCP TRT, SIEBEL.S_DMND_CRTN_PRG TT WHERE TRT.SRC_ID=TC.ROW_ID(+) "
			+ " AND TRT.DCP_ID=TT.ROW_ID AND TT.MKTG_OFFR_ID=TOF.ROW_ID AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
			+ "AND TC.CAMP_TYPE_CD='Campaign' AND TC.MKTG_TMPL_FLG='N'";

	public List<CampannaOfertaCanal> listarCampannasOfertasCanales() {
		List<CampannaOfertaCanal> campoofertac = new ArrayList<CampannaOfertaCanal>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATGEN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campoofertac.add(new CampannaOfertaCanal(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5), rs.getString(6), rs.getString(7), rs
						.getString(8), rs.getString(9), rs.getString(10)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campoofertac;
	}
}
