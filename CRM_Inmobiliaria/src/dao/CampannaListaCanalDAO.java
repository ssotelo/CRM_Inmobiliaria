package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CampannaListaCanal;
import domain.Conexion;

public class CampannaListaCanalDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATCAMLISCAN = "SELECT TC.ROW_ID, TL.ROW_ID, TT.MEDIA_TYPE_CD, "
			+ "TO_CHAR(TRL.CREATED,'YYYYMMDD')CREATED, "
			+ "TO_CHAR(TRL.LAST_UPD,'YYYYMMDD')LAST_UPD, "
			+ "TT.X_ID_TREAT, TT.NAME "
			+ "FROM SIEBEL811.S_SRC TC, SIEBEL811.S_DMND_CRTN_PRG TT, "
			+ "SIEBEL811.S_CALL_LST TL, SIEBEL811.S_SRC_DCP TRT, SIEBEL811.S_CAMP_CALL_LST TRL "
			+ "WHERE TC.ROW_ID=TRT.SRC_ID AND TT.ROW_ID=TRT.DCP_ID "
			+ "AND TC.ROW_ID=TRL.SRC_ID AND TL.ROW_ID=TRL.CALL_LST_ID "
			+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
			+ "AND TC.CAMP_TYPE_CD='Campaign' AND TC.MKTG_TMPL_FLG='N'";

	private String SELECT_CATCAMLISCANCTL = "SELECT "
			+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
			+ "TO_CHAR(TRUNC(TRCT.LAST_UPD),'YYYYMMDD')LAST_UPD, "
			+ "COUNT(TRUNC(TRCT.LAST_UPD)) AS TOTAL "
			+ "FROM SIEBEL811.S_SRC_PGROUP TRCT, "
			+ "SIEBEL811.S_SRC TC, "
			+ "SIEBEL811.S_PGROUP TT "
			+ "WHERE TRCT.LAST_UPD "
			+ "BETWEEN TO_DATE('20140101','YYYYMMDD') "
			+ "AND TO_DATE('20151231','YYYYMMDD') "
			+ "AND TRCT.SRC_ID=TC.ROW_ID "
			+ "AND TRCT.PGROUP_ID=TT.ROW_ID "
			+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
			+ "AND TC.CAMP_TYPE_CD='Campaign' "
			+ "AND TC.MKTG_TMPL_FLG='N' "
			+ "GROUP BY TRUNC(TRCT.LAST_UPD) "
			+ "ORDER BY LAST_UPD";
	
	public List<CampannaListaCanal> listarCampannasListasCanales() {
		List<CampannaListaCanal> clc = new ArrayList<CampannaListaCanal>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATCAMLISCAN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clc.add(new CampannaListaCanal(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4)
						,"", rs.getString(5),
						rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clc;
	}

	public List<CampannaListaCanal> listarCampannasListasCanalesCtl() {
		List<CampannaListaCanal> clc = new ArrayList<CampannaListaCanal>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATCAMLISCANCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clc.add(new CampannaListaCanal(rs.getString(1),
						rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clc;
	}
}
