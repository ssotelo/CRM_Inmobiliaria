package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Campanna;
import domain.Conexion;

public class CampannaDAO {

	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public List<Campanna> listarCampannas(){
		String SELECT_CAMP = "SELECT TC.ROW_ID,TC.NAME,TC.OBJECTIVE,TC.CAMP_TYPE_CD,"
				+ "TC.CAMP_CAT_CD,TC.X_PRIORITY_NUM,TC.PAR_SRC_ID,TC.STATUS_CD, TC.X_EXEC_APPR_STAT_NUM,"
				+ "TC.MKTG_PLAN_ID,TO_CHAR(TC.PROG_START_DT,'YYYYMMDD')PROG_START_DT,"
				+ "TO_CHAR(TC.PROG_END_DT,'YYYYMMDD')PROG_END_DT, TC.BDGT_AMT, TU.LOGIN , "
				+ "TO_CHAR(TC.LAST_UPD,'YYYYMMDD')LAST_UPD, TC.SRC_NUM, TC.X_ID_CAMP "
				+ "FROM SIEBEL811.S_SRC TC, SIEBEL811.S_USER TU "
				+ "WHERE TC.LAST_UPD "
				+ "BETWEEN TO_DATE('20150101','YYYYMMDD') "
				+ "AND TO_DATE('20151231','YYYYMMDD') "
				+ "AND TC.LAST_UPD_BY = TU.ROW_ID(+) AND "
				+ "TC.SUB_TYPE ='MARKETING_CAMPAIGN' AND TC.CAMP_TYPE_CD='Campaign' "
				+ "AND TC.MKTG_TMPL_FLG='N'";
		List<Campanna> campannas = new ArrayList<Campanna>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
			stmt = conn.prepareStatement(SELECT_CAMP);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campannas.add(new Campanna(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9),rs.getString(10),"",
						rs.getString(11),rs.getString(12), rs.getString(13),rs.getString(14),rs.getString(15)
						,rs.getString(16),rs.getString(17)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campannas;
	}
	
	public List<Campanna> listarCampannasCtl(){
		String SELECT_CAMPCTL = "SELECT  "
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "COUNT(ROW_ID) "
				+ "FROM SIEBEL811.S_SRC "
				+ "WHERE LAST_UPD  "
				+ "BETWEEN TO_DATE('20141231','YYYYMMDD') "
				+ "AND TO_DATE('20151231','YYYYMMDD') "
				+ "AND SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND CAMP_TYPE_CD='Campaign'  "
				+ "AND MKTG_TMPL_FLG='N' "
				+ "GROUP BY TRUNC(LAST_UPD) "
				+ "ORDER BY LAST_UPD";
		List<Campanna> campannas = new ArrayList<Campanna>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
			stmt = conn.prepareStatement(SELECT_CAMPCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campannas.add(new Campanna(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campannas;
	}
}