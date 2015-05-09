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

import domain.Tarjeta;

public class TarjetaDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<Tarjeta> listarTarjetas(String FecIni, String FecFin, String cfg, Connection conn) {	
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATTAR = "SELECT TC.ROW_ID, TT.TYPE_CD, TT.IDENTITY_DOC_NUM, "
				+ "TO_CHAR(TT.LAST_UPD,'YYYYMMDD')LAST_UPD "
				+ "FROM "+DBO+".S_CON_IDNTY_DOC TT, "+DBO+".S_CONTACT TC "
				+ "WHERE TT.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TT.CONTACT_ID=TC.ROW_ID(+) "
				+ "AND TC.ROW_ID IS NOT NULL";

		List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		try {
			stmt = conn.prepareStatement(SELECT_CATTAR);
			rs = stmt.executeQuery();
			while (rs.next()) {
				tarjetas.add(new Tarjeta(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return tarjetas;
	}
}