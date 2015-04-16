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

	public List<CampannaOfertaCanal> listarCampannasOfertasCanales(String FecIni, String FecFin, String cfg) {
		String DBO = "SIEBEL811";
		String SELECT_CATCAMPOFFRCAN = "SELECT TOF.ROW_ID, TT.MEDIA_TYPE_CD, "
				+ "TC.ROW_ID, TOF.APPR_STAT_CD, TT.COST, "
				+ "TO_CHAR(TT.START_DT,'YYYYMMDD')START_DT, "
				+ "TO_CHAR(TT.END_DT,'YYYYMMDD')END_DT, "
				+ "TO_CHAR(TC.LAST_UPD,'YYYYMMDD')LAST_UPD, "
				+ "TT.X_ID_TREAT, TT.NAME FROM " + DBO + ".S_SRC TC,"
				+ DBO + ".S_MKTG_OFFR TOF, "+ DBO +".S_SRC_DCP TRT, "
				+ DBO +".S_DMND_CRTN_PRG TT WHERE TC.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TRT.SRC_ID=TC.ROW_ID(+) "
				+ "AND TRT.DCP_ID=TT.ROW_ID AND TT.MKTG_OFFR_ID=TOF.ROW_ID "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' AND TC.MKTG_TMPL_FLG='N'";
		List<CampannaOfertaCanal> campoofertac = new ArrayList<CampannaOfertaCanal>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection(cfg);
			stmt = conn.prepareStatement(SELECT_CATCAMPOFFRCAN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campoofertac.add(new CampannaOfertaCanal(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5), rs.getString(6), rs.getString(7), rs
						.getString(8), rs.getString(9), rs.getString(10)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campoofertac;
	}

	public List<CampannaOfertaCanal> listarCampannasOfertasCanalesCtl(String FecIni, String FecFin, String cfg) {
		String DBO = "SIEBEL811";
		String SELECT_CATCAMPOFFRCANCTL = "SELECT "
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(TR.LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "COUNT(TRUNC(TR.LAST_UPD)) AS TOTAL "
				+ "FROM " + DBO + ".S_SRC TC, " + DBO + ".S_MKTG_OFFR TOF, "
				+ DBO + ".S_SRC_DCP TR, " + DBO + ".S_DMND_CRTN_PRG TT "
				+ "WHERE TR.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' "
				+ "AND TR.SRC_ID=TC.ROW_ID(+) "
				+ "AND TR.DCP_ID=TT.ROW_ID "
				+ "AND TT.MKTG_OFFR_ID=TOF.ROW_ID "
				+ "GROUP BY TRUNC(TR.LAST_UPD) "
				+ "ORDER BY LAST_UPD";
		List<CampannaOfertaCanal> campoofertac = new ArrayList<CampannaOfertaCanal>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection(cfg);
			stmt = conn.prepareStatement(SELECT_CATCAMPOFFRCANCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campoofertac.add(new CampannaOfertaCanal(rs.getString(1), rs
						.getString(2), rs.getString(3)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campoofertac;
	}
}