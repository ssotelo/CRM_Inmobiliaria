package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Conexion;
import domain.Plan;

public class PlanDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public List<Plan> listarPlanes() {
		String SELECT_CATPLN = "SELECT TC.ROW_ID, TC.PLAN_TYPE_CD, TC.NAME, "
				+ "TC.EXEC_APPR_STAT_CD, TC.OBJECTIVE, TR.NAME, "
				+ "TO_CHAR(TC.PROG_START_DT,'YYYYMMDD')PROG_START_DT, "
				+ "TO_CHAR(TC.PROG_END_DT,'YYYYMMDD')PROG_END_DT ,"
				+ "TO_CHAR(TRUNC(TC.LAST_UPD),'YYYYMMDD')LAST_UPD, TC.SRC_NUM "
				+ "FROM SIEBEL811.S_SRC TC "
				+ "LEFT OUTER JOIN SIEBEL811.S_REGION TR "
				+ "ON TR.ROW_ID=TC.REGION_ID "
				+ "WHERE TC.LAST_UPD BETWEEN TO_DATE('20150101','YYYYMMDD') "
				+ "AND TO_DATE('20151231','YYYYMMDD') "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Marketing Plan' ";
		List<Plan> pln = new ArrayList<Plan>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATPLN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				pln.add(new Plan(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9), rs.getString(10)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return pln;
	}
	
	public List<Plan> listarPlanesCtl() {
		String SELECT_PLNCTL = "SELECT "
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "COUNT(TRUNC(LAST_UPD)) AS TOTAL "
				+ "FROM SIEBEL811.S_SRC "
				+ "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('20140101','YYYYMMDD') "
				+ "AND TO_DATE('20151231','YYYYMMDD') "
				+ "AND SUB_TYPE ='MARKETING_CAMPAIGN'  "
				+ "AND CAMP_TYPE_CD='Marketing Plan' "
				+ "GROUP BY TRUNC(LAST_UPD) "
				+ "ORDER BY LAST_UPD";
		List<Plan> pln = new ArrayList<Plan>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_PLNCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				pln.add(new Plan(rs.getString(1), rs.getString(2), rs
						.getString(3)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return pln;
	}
}