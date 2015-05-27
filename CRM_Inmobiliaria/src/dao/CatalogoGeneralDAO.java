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
	
	public List<CatalogoGeneral> listarCatalogosGenerales(String cfg, Connection conn) {
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
				+ "VAL,TYPE ,SUB_TYPE, ORDER_BY, REPLACE(REPLACE(DESC_TEXT,CHR(13),''),CHR(10),'') DESC_TEXT "
				+ "FROM "+ DBO +".S_LST_OF_VAL "
				+ "WHERE ACTIVE_FLG='Y' ORDER BY TYPE ";
		List<CatalogoGeneral> catalogosgenerales = new ArrayList<CatalogoGeneral>();
		try {
			stmt = conn.prepareStatement(SELECT_CATGEN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				catalogosgenerales.add(new CatalogoGeneral(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5), rs.getString(7), rs.getInt(6)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return catalogosgenerales;
	}
}