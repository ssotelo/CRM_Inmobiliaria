package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.Campanna;

public class CampannaDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<Campanna> listarCampannas(String FecIni, String FecFin,
			String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CAMP = "SELECT "
				+ "TC.ROW_ID, TC.NAME,"
				+ "REPLACE(REPLACE(TC.OBJECTIVE,CHR(13),''),CHR(10),'')OBJECTIVE,TC.X_OWNER_BU, "
				+ "TC.CAMP_TYPE_CD,TC.X_CAMP_CAT_NUM,TC.X_PRIORITY_NUM, "
				+ "TC.PAR_SRC_ID,TC.STATUS_CD,TC.X_EXEC_APPR_STAT_NUM, "
				+ "TC.MKTG_PLAN_ID,TC.X_HASHTAG, "
				+ "TO_CHAR(TC.PROG_START_DT,'YYYYMMDD')PROG_START_DT,"
				+ "TO_CHAR(TC.PROG_END_DT,'YYYYMMDD')PROG_END_DT, "
				+ "TC.BDGT_AMT, TU.LOGIN , "
				+ "TO_CHAR(TC.LAST_UPD,'YYYYMMDD')LAST_UPD, "
				+ "TC.SRC_NUM, TC.X_ID_CAMP "
				+ "FROM " + DBO + ".S_SRC TC, " + DBO + ".S_USER TU "
				+ "WHERE TC.LAST_UPD_BY = TU.ROW_ID(+)  "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' "
				+ "AND TC.MKTG_TMPL_FLG='N'";
		List<Campanna> campannas = new ArrayList<Campanna>();
		try {
			stmt = conn.prepareStatement(SELECT_CAMP);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campannas.add(new Campanna(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17), 
						rs.getString(18), rs.getString(19)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campannas;
	}

	public List<Campanna> listarCampannasCtl(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CAMPCTL = "SELECT  " 
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "X_OWNER_BU,"
				+ "COUNT(ROW_ID) " 
				+ "FROM " + DBO + ".S_SRC "
				+ "WHERE LAST_UPD  " 
				+ "BETWEEN TO_DATE('" + FecIni +"','YYYYMMDD') " 
				+ "AND TO_DATE('" + FecFin + "','YYYYMMDD') " 
				+ "AND SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND CAMP_TYPE_CD='Campaign'  " 
				+ "AND MKTG_TMPL_FLG='N' "
				+ "GROUP BY TRUNC(LAST_UPD),X_OWNER_BU " 
				+ "ORDER BY LAST_UPD";
		List<Campanna> campannas = new ArrayList<Campanna>();
		try {
			stmt = conn.prepareStatement(SELECT_CAMPCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campannas.add(new Campanna(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campannas;
	}
}