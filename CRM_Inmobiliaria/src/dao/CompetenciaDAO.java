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

import domain.Competencia;

public class CompetenciaDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<Competencia> listarCompetencias(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_COMP = "SELECT PP.DEPT_NUM, PP.NAME AS TIENDA,"
				+ "TH.NAME AS COMPETENCIA, TH.X_ID_FB, TH.X_ID_TWITTER "
				+ "FROM " + DBO + ".S_ORG_EXT PP, "
				+ DBO + ".S_ORG_EXT TH, " + DBO + ".S_PARTY_REL TR "
				+ "WHERE PP.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD')"
				+ "AND TR.REL_PARTY_ID=PP.ROW_ID "
				+ "AND TR.PARTY_ID=TH.ROW_ID  "
				+ "AND TR.REL_TYPE_CD='Competencia' "
				+ "AND PP.OU_TYPE_CD='Comercial' "
				+ "ORDER BY PP.NAME";
		List<Competencia> competencias = new ArrayList<Competencia>();
		try {
			stmt = conn.prepareStatement(SELECT_COMP);
			rs = stmt.executeQuery();
			while (rs.next()) {
				competencias.add(new Competencia(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return competencias;
	}
}