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
	private String SELECT_CATCAMLISCAN = "SELECT TC.ROW_ID, TL.ROW_ID, TT.ROW_ID, "
			+ "TO_CHAR(TRL.CREATED,'YYYYMMDD')CREATED, "
			+ "TO_CHAR(TRL.LAST_UPD,'YYYYMMDD')LAST_UPD, "
			+ "TT.X_ID_TREAT, TT.NAME "
			+ "FROM SIEBEL811.S_SRC TC, SIEBEL811.S_DMND_CRTN_PRG TT, "
			+ "SIEBEL811.S_CALL_LST TL, SIEBEL811.S_SRC_DCP TRT, SIEBEL811.S_CAMP_CALL_LST TRL "
			+ "WHERE TC.ROW_ID=TRT.SRC_ID AND TT.ROW_ID=TRT.DCP_ID "
			+ "AND TC.ROW_ID=TRL.SRC_ID AND TL.ROW_ID=TRL.CALL_LST_ID "
			+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
			+ "AND TC.CAMP_TYPE_CD='Campaign' AND TC.MKTG_TMPL_FLG='N'";

	public List<CampannaListaCanal> listarCampannasListasCanales() {
		List<CampannaListaCanal> clc = new ArrayList<CampannaListaCanal>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATCAMLISCAN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clc.add(new CampannaListaCanal(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4), rs
								.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clc;
	}

}
