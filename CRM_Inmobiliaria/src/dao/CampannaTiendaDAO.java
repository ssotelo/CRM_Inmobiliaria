package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CampannaTienda;
import domain.Conexion;

public class CampannaTiendaDAO {

	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CAMTI = "SELECT TRCT.SRC_ID, TRCT.PGROUP_ID, TT.NAME,"
			+ " TO_CHAR(TRCT.CREATED,'YYYYMMDD')CREATED ,TO_CHAR(TRCT.LAST_UPD,'YYYYMMDD')"
			+ " LAST_UPD FROM SIEBEL811.S_SRC_PGROUP TRCT, SIEBEL811.S_SRC TC,"
			+ " SIEBEL811.S_PGROUP TT "
			+ "WHERE TRCT.SRC_ID=TC.ROW_ID AND TRCT.PGROUP_ID=TT.ROW_ID "
			+ " AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
			+ "AND TC.CAMP_TYPE_CD='Campaign'AND TC.MKTG_TMPL_FLG='N'";

	private String SELECT_CAMTICTL = "SELECT "
			+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY,"
			+ "TO_CHAR(TRUNC(TRCT.LAST_UPD),'YYYYMMDD')LAST_UPD, "
			+ "COUNT(TRUNC(TRCT.LAST_UPD)) AS TOTAL "
			+ "FROM SIEBEL811.S_SRC_PGROUP TRCT, "
			+ "SIEBEL811.S_SRC TC,"
			+ "SIEBEL811.S_PGROUP TT "
			+ "WHERE TRCT.LAST_UPD "
			+ "BETWEEN TO_DATE('20140101','YYYYMMDD')  "
			+ "AND TO_DATE('20151231','YYYYMMDD') "
			+ "AND TRCT.SRC_ID=TC.ROW_ID "
			+ "AND TRCT.PGROUP_ID=TT.ROW_ID "
			+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
			+ "AND TC.CAMP_TYPE_CD='Campaign' "
			+ "AND TC.MKTG_TMPL_FLG='N' "
			+ "GROUP BY TRUNC(TRCT.LAST_UPD) "
			+ "ORDER BY LAST_UPD";
	
	public List<CampannaTienda> listarCampannasTiendas() {
		List<CampannaTienda> campannastiendas = new ArrayList<CampannaTienda>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CAMTI);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campannastiendas.add(new CampannaTienda(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4),"", 
						rs.getString(5)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campannastiendas;
	}

	public List<CampannaTienda> listarCampannasTiendasCtl() {
		List<CampannaTienda> campannastiendas = new ArrayList<CampannaTienda>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CAMTICTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campannastiendas.add(new CampannaTienda(rs.getString(1), rs
						.getString(2), rs.getString(3)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campannastiendas;
	}
}