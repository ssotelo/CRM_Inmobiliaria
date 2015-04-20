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

import domain.CampannaListaCanal;

public class CampannaListaCanalDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<CampannaListaCanal> listarCampannasListasCanales(String FecIni, String FecFin, String cfg, Connection conn) {

		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATCAMLISCAN = "SELECT TC.ROW_ID, TL.ROW_ID, TT.MEDIA_TYPE_CD, "
				+ "TO_CHAR(TRL.CREATED,'YYYYMMDD')CREATED, "
				+ "TO_CHAR(TRL.LAST_UPD,'YYYYMMDD')LAST_UPD, "
				+ "TT.X_ID_TREAT, TT.NAME "
				+ "FROM " + DBO + ".S_SRC TC, " 
				+ DBO + ".S_DMND_CRTN_PRG TT, "
				+ DBO + ".S_CALL_LST TL, " 
				+ DBO + ".S_SRC_DCP TRT, "
				+ DBO + ".S_CAMP_CALL_LST TRL "
				+ "WHERE TRL.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.ROW_ID=TRT.SRC_ID AND TT.ROW_ID=TRT.DCP_ID "
				+ "AND TC.ROW_ID=TRL.SRC_ID AND TL.ROW_ID=TRL.CALL_LST_ID "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' AND TC.MKTG_TMPL_FLG='N'";
		List<CampannaListaCanal> clc = new ArrayList<CampannaListaCanal>();
		try {
			stmt = conn.prepareStatement(SELECT_CATCAMLISCAN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clc.add(new CampannaListaCanal(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4)
						,"", rs.getString(5),
						rs.getString(6), rs.getString(7)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clc; 
	}

	public List<CampannaListaCanal> listarCampannasListasCanalesCtl(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATCAMLISCANCTL = "SELECT "
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(TRL.LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "COUNT(TRUNC(TRL.LAST_UPD)) AS TOTAL "
				+ "FROM " + DBO + ".S_SRC TC, " + DBO + ".S_DMND_CRTN_PRG TT, "
				+ DBO + ".S_CALL_LST TL, "
				+ DBO + ".S_SRC_DCP TRT, " + DBO + ".S_CAMP_CALL_LST TRL "
				+ "WHERE TRL.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.ROW_ID=TRT.SRC_ID AND TT.ROW_ID=TRT.DCP_ID "
				+ "AND TC.ROW_ID=TRL.SRC_ID AND TL.ROW_ID=TRL.CALL_LST_ID "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' AND TC.MKTG_TMPL_FLG='N' "
				+ "GROUP BY TRUNC(TRL.LAST_UPD) "
				+ "ORDER BY LAST_UPD";
		List<CampannaListaCanal> clc = new ArrayList<CampannaListaCanal>();
		try {
			stmt = conn.prepareStatement(SELECT_CATCAMLISCANCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clc.add(new CampannaListaCanal(rs.getString(1),
						rs.getString(2), rs.getString(3)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clc;
	}
}