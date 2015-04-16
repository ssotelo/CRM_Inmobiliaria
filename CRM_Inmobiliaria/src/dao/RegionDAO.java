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

import domain.Conexion;
import domain.Region;

public class RegionDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<Region> listarRegiones(String FecIni, String FecFin, String cfg) {
		
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATREG = "SELECT ROW_ID, NAME "
				+ "FROM "+DBO+".S_REGION "
				+ "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD')";
		List<Region> regiones = new ArrayList<Region>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection(cfg);
			stmt = conn.prepareStatement(SELECT_CATREG);
			rs = stmt.executeQuery();
			while (rs.next()) {
				regiones.add(new Region(rs.getString(1), rs.getString(2)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return regiones;
	}
}