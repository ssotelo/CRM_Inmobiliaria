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

import domain.CampannaOferta;

public class CampannaOfertaDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<CampannaOferta> listarCampannasOfertas(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CAMPOFFR = "SELECT TC.ROW_ID, TOF.ROW_ID, "
				+ "TOF.X_ATTRIB_05, TOF.X_ATTRIB_04, "
				+ "TOF.X_ATTRIB_03, TOF.X_ATTRIB_02, "
				+ "REPLACE(REPLACE(TOF.X_ATTRIB_01,CHR(13),''),CHR(10),'')X_ATTRIB_01, "
				+ "TOF.X_ATTRIB_10, TOF.X_ATTRIB_09,"
				+ "TOF.X_ATTRIB_08, TOF.X_ATTRIB_07,TOF.X_ATTRIB_06, "
				+ "TO_CHAR(TOF.START_DT,'YYYYMMDD')START_DT, "
				+ "TO_CHAR(TR.LAST_UPD,'YYYYMMDD')LAST_UPD,"
				+ "TT.X_ID_TREAT, TT.NAME, TT.OFFER_NUM "
				+ "FROM " + DBO + ".S_SRC TC, " + DBO + ".S_SRC_DCP TR, "
				+ DBO + ".S_MKTG_OFFR TOF, " + DBO + ".S_DMND_CRTN_PRG TT "
				+ "WHERE TR.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.ROW_ID=TR.SRC_ID AND TT.MKTG_OFFR_ID=TOF.ROW_ID "
				+ "AND TT.ROW_ID=TR.DCP_ID AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' AND TC.MKTG_TMPL_FLG='N'";
		List<CampannaOferta> campoffr = new ArrayList<CampannaOferta>();
		try {
			stmt = conn.prepareStatement(SELECT_CAMPOFFR);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campoffr.add(new CampannaOferta(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5), rs.getString(6), rs.getString(7), rs
						.getString(8), rs.getString(9), rs.getString(10), rs
						.getString(11), rs.getString(12), rs.getString(13), rs
						.getString(14), rs.getString(15), rs.getString(16), rs
						.getString(17)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campoffr;
	}
	
	public List<CampannaOferta> listarCampannasOfertasCtl(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CAMPOFFRCTL = "SELECT "
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(TR.LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "TC.X_OWNER_BU, "
				+ "COUNT(TC.ROW_ID) AS TOTAL "
				+ "FROM " + DBO + ".S_SRC TC, " + DBO + ".S_SRC_DCP TR, "
				+ DBO + ".S_MKTG_OFFR TOF, "
				+ DBO + ".S_DMND_CRTN_PRG TT "
				+ "WHERE TR.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' "
				+ "AND TC.ROW_ID=TR.SRC_ID "
				+ "AND TT.MKTG_OFFR_ID=TOF.ROW_ID "
				+ "AND TT.ROW_ID=TR.DCP_ID "
				+ "GROUP BY TRUNC(TR.LAST_UPD), X_OWNER_BU "
				+ "ORDER BY LAST_UPD";
		List<CampannaOferta> campoffr = new ArrayList<CampannaOferta>();
		try {
			stmt = conn.prepareStatement(SELECT_CAMPOFFRCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				campoffr.add(new CampannaOferta(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.
						getString(4)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return campoffr;
	}
}