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

import domain.ClienteDireccionVirtual;

public class ClienteDireccionVirtualDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<ClienteDireccionVirtual> listarClientesDireccionesVirtuales(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATDIRV = "SELECT DISTINCT PER_ID, COMM_MEDIUM_CD, "
				+ "REPLACE(REPLACE(ADDR,CHR(13),''),CHR(10),'') ADDR, "
				+ "TO_CHAR(LAST_UPD,'YYYYMMDD')LAST_UPD "
				+ "FROM " + DBO +".S_PER_COMM_ADDR "
				+ "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD')"
				+ "UNION "
				+ "SELECT DISTINCT ROW_ID,'Twitter',X_ID_TWITTER, "
				+ "TO_CHAR(LAST_UPD,'YYYYMMDD')LAST_UPD "
				+ "FROM " + DBO + ".S_CONTACT "
				+ "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND X_ID_TWITTER IS NOT NULL "
				+ "UNION "
				+ "SELECT DISTINCT ROW_ID,'Facebook',X_ID_FB, "
				+ "TO_CHAR(LAST_UPD,'YYYYMMDD')LAST_UPD "
				+ "FROM " + DBO + ".S_CONTACT "
				+ "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND X_ID_FB IS NOT NULL";
		List<ClienteDireccionVirtual> clientesdireccionesvirtuales = new ArrayList<ClienteDireccionVirtual>();
		try {
			stmt = conn.prepareStatement(SELECT_CATDIRV);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clientesdireccionesvirtuales.add(new ClienteDireccionVirtual(rs
						.getString(1), rs.getString(2), rs.getString(3), rs
						.getString(4)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clientesdireccionesvirtuales;
	}
}