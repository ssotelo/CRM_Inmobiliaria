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

import domain.ClienteMiembro;

public class ClienteMiembroDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<ClienteMiembro> listarClientesMiembros(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATMIE = "SELECT TR.PER_ID, TR.MEMBER_ID, "
				+ "TO_CHAR(TR.LAST_UPD,'YYYYMMDD')LAST_UPD "
				+ "FROM " + DBO + ".S_LOY_MEM_CON TR, "
				+ DBO + ".S_CONTACT TC, " + DBO + ".S_LOY_MEMBER TM "
				+ "WHERE TR.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.ROW_ID = TR.PER_ID "
				+ "AND TM.ROW_ID = TR.MEMBER_ID";
		List<ClienteMiembro> clientesmiembros = new ArrayList<ClienteMiembro>();
		try {
			stmt = conn.prepareStatement(SELECT_CATMIE);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clientesmiembros.add(new ClienteMiembro(rs.getString(1), rs
						.getString(2), rs.getString(3)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clientesmiembros;
	}
}