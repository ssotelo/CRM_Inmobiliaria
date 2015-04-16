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

import domain.CampannaLista;
import domain.Conexion;

public class CampannaListaDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<CampannaLista> listarCampannasListas(String FecIni, String FecFin, String cfg) {
		
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATCAMLIS = "SELECT TL.SRC_ID, TL.CALL_LST_ID, "
				+ "TO_CHAR(TL.CREATED,'YYYYMMDD')CREATED,"
				+ "TO_CHAR(TL.LAST_UPD,'YYYYMMDD')LAST_UPD "
				+ "FROM " + DBO + ".S_CAMP_CALL_LST TL, " + DBO + ".S_SRC TC "
				+ "WHERE TL.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TL.SRC_ID=TC.ROW_ID "
				+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
				+ "AND TC.CAMP_TYPE_CD='Campaign' " + "AND TC.MKTG_TMPL_FLG='N'";
		List<CampannaLista> clc = new ArrayList<CampannaLista>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection(cfg);
			stmt = conn.prepareStatement(SELECT_CATCAMLIS);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clc.add(new CampannaLista(rs.getString(1), rs.getString(2), rs
						.getString(3), "", rs.getString(4)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clc;
	}
}