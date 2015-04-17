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

import domain.ClienteTelefono;

public class ClienteTelefonoDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<ClienteTelefono> listarClientestelefonos(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATTEL = "SELECT DISTINCT TC.ROW_ID, TN.ADDR, TN.COMM_USE_TYPE_CD,"
				+ "TN.X_EXTENSION, TO_CHAR(TN.LAST_UPD,'YYYYMMDD')LAST_UPD "
				+ "FROM " + DBO + ".S_CONTACT TC, " + DBO + ".S_PER_COMM_ADDR TN "
				+ "WHERE TN.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.ROW_ID=TN.PER_ID " 
				+ "AND TN.COMM_MEDIUM_CD='Phone' ";
		List<ClienteTelefono> clientestelefonos = new ArrayList<ClienteTelefono>();
		try {
			stmt = conn.prepareStatement(SELECT_CATTEL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clientestelefonos.add(new ClienteTelefono(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clientestelefonos;
	}
}