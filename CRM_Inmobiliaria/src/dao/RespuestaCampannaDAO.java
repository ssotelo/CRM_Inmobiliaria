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

import domain.RespuestaCampanna;

public class RespuestaCampannaDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<RespuestaCampanna> listarRespuestasCampannas(String FecIni, String FecFin, String cfg, Connection conn) {		
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATRCAM = "SELECT TR.SRC_ID, TT.MKTG_OFFR_ID,"
				+ "TT.MEDIA_TYPE_CD, TR.PR_CON_ID, TR.CALL_LST_ID,"
				+ " TR.OUTCOME_CD,TR.COMM_METHOD, "
				+ "TR.MEET_LOC, TO_CHAR(TR.LAST_UPD,'YYYYMMDD')"
				+ "LAST_UPD "
				+ "FROM "+ DBO +".S_COMMUNICATION TR, "
				+ ""+DBO+".S_DMND_CRTN_PRG TT, "
				+ ""+DBO+".S_SRC TC "
				+ "WHERE TR.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.ROW_ID=TR.SRC_ID "
				+ "AND TT.ROW_ID=TR.DCP_ID "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' AND TC.MKTG_TMPL_FLG='N'";

		List<RespuestaCampanna> respuestascampannas = new ArrayList<RespuestaCampanna>();
		try {
			stmt = conn.prepareStatement(SELECT_CATRCAM);
			rs = stmt.executeQuery();
			while (rs.next()) {
				respuestascampannas.add(new RespuestaCampanna(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4), rs
								.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return respuestascampannas;
	}
	
	public List<RespuestaCampanna> listarRespuestasCampannasCtl(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATRCAMCTL = "SELECT "
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(TR.LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "COUNT(TRUNC(TR.LAST_UPD)) AS TOTAL "
				+ "FROM " + DBO + ".S_COMMUNICATION TR, "
				+ DBO +".S_DMND_CRTN_PRG TT, "
				+ DBO +".S_SRC TC "
				+ "WHERE TR.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND  TC.ROW_ID=TR.SRC_ID "
				+ "AND TT.ROW_ID=TR.DCP_ID "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' "
				+ "GROUP BY TRUNC(TR.LAST_UPD) "
				+ "ORDER BY LAST_UPD";
		List<RespuestaCampanna> respuestascampannas = new ArrayList<RespuestaCampanna>();
		try {
			stmt = conn.prepareStatement(SELECT_CATRCAMCTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				respuestascampannas.add(new RespuestaCampanna(rs.getString(1),
						rs.getString(2), rs.getString(3)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return respuestascampannas;
	}
}