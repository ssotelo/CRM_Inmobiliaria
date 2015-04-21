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

import domain.Plan;

public class PlanDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<Plan> listarPlanes(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATPLN = "SELECT TC.ROW_ID, TC.PLAN_TYPE_CD, TC.NAME, "
				+ "TC.EXEC_APPR_STAT_CD, "
				+ "REPLACE(REPLACE(TC.OBJECTIVE,CHR(13),''),CHR(10),'') OBJECTIVE, "
				+ "TR.NAME, "
				+ "TO_CHAR(TC.PROG_START_DT,'YYYYMMDD')PROG_START_DT, "
				+ "TO_CHAR(TC.PROG_END_DT,'YYYYMMDD')PROG_END_DT ,"
				+ "TO_CHAR(TRUNC(TC.LAST_UPD),'YYYYMMDD')LAST_UPD, TC.SRC_NUM, "
				+ "TC.X_OWNER_BU "
				+ "FROM "+ DBO + ".S_SRC TC "
				+ "LEFT OUTER JOIN " + DBO + ".S_REGION TR "
				+ "ON TR.ROW_ID=TC.REGION_ID "
				+ "WHERE TC.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Marketing Plan' ";
		List<Plan> pln = new ArrayList<Plan>();
		try {
			stmt = conn.prepareStatement(SELECT_CATPLN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				pln.add(new Plan(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9), rs.getString(10), rs.getString(11)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return pln;
	}
	
	public List<Plan> listarPlanesCtl(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_PLNCTL = "SELECT "
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "COUNT(TRUNC(LAST_UPD)) AS TOTAL "
				+ "FROM " + DBO + ".S_SRC "
				+ "WHERE LAST_UPD  "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND CAMP_TYPE_CD='Marketing Plan' "
				+ "GROUP BY TRUNC(LAST_UPD) "
				+ "ORDER BY LAST_UPD";
		List<Plan> pln = new ArrayList<Plan>();
		try {
			stmt = conn.prepareStatement(SELECT_PLNCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				pln.add(new Plan(rs.getString(1), rs.getString(2), rs
						.getString(3)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return pln;
	}
}