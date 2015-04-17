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

import domain.CatalogoGeneral;

public class CatalogoGeneralDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<CatalogoGeneral> listarCatalogosGenerales(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATGEN = "SELECT ROW_ID, PAR_ROW_ID,"
				+ "TYPE,SUB_TYPE, VAL, NAME, DESC_TEXT, ORDER_BY "
				+ "FROM "+ DBO +".S_LST_OF_VAL "
				+ "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND ACTIVE_FLG='Y' ORDER BY TYPE ";
		List<CatalogoGeneral> catalogosgenerales = new ArrayList<CatalogoGeneral>();
		try {
			stmt = conn.prepareStatement(SELECT_CATGEN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				catalogosgenerales.add(new CatalogoGeneral(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5), rs.getString(6), rs.getString(7), rs
						.getInt(8)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return catalogosgenerales;
	}
}