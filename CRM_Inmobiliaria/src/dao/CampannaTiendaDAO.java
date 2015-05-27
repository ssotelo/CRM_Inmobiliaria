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

import domain.CampannaTienda;

public class CampannaTiendaDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<CampannaTienda> listarCampannasTiendas(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CAMTI = "SELECT TRCT.SRC_ID, TT.DESC_TEXT, TT.NAME,"
				+ "TO_CHAR(TRCT.CREATED,'YYYYMMDD')CREATED, "
				+ "TO_CHAR(TRCT.LAST_UPD,'YYYYMMDD')LAST_UPD "
				+ "FROM " + DBO + ".S_SRC_PGROUP TRCT, "
				+ DBO +".S_SRC TC,"
				+ DBO +".S_PGROUP TT "
				+ "WHERE TRCT.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TRCT.SRC_ID=TC.ROW_ID "
				+ "AND TRCT.PGROUP_ID=TT.ROW_ID "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' "
				+ "AND TC.MKTG_TMPL_FLG='N'";
		List<CampannaTienda> campannastiendas = new ArrayList<CampannaTienda>();
		try {
			stmt = conn.prepareStatement(SELECT_CAMTI);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campannastiendas.add(new CampannaTienda(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campannastiendas;
	}

	public List<CampannaTienda> listarCampannasTiendasCtl(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CAMTICTL = "SELECT "
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(TRCT.LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "TC.X_OWNER_BU, "
				+ "COUNT(TRUNC(TRCT.LAST_UPD)) AS TOTAL "
				+ "FROM " + DBO + ".S_SRC_PGROUP TRCT, "
				+ DBO + ".S_SRC TC, "
				+ DBO + ".S_PGROUP TT "
				+ "WHERE TRCT.LAST_UPD "
				+ "BETWEEN TO_DATE('" + FecIni + "','YYYYMMDD') "
				+ "AND TO_DATE('" + FecFin +"','YYYYMMDD') "
				+ "AND TRCT.SRC_ID=TC.ROW_ID  "
				+ "AND TRCT.PGROUP_ID=TT.ROW_ID "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' "
				+ "AND TC.MKTG_TMPL_FLG='N' "
				+ "GROUP BY TRUNC(TRCT.LAST_UPD), X_OWNER_BU "
				+ "ORDER BY LAST_UPD";
		List<CampannaTienda> campannastiendas = new ArrayList<CampannaTienda>();
		try {
			stmt = conn.prepareStatement(SELECT_CAMTICTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campannastiendas.add(new CampannaTienda(rs.getString(1), rs
						.getString(2), rs.getString(3),rs.getString(4)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campannastiendas;
	}
}