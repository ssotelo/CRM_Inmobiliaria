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

import domain.CentroComercial;

public class CentroComercialDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<CentroComercial> listarCentrosComerciales(String FecIni, String FecFin, String cfg, Connection conn) {		
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CENCOM = "SELECT TC.DEPT_NUM, TC.NAME, TD.X_DES_PROV, "
				+ "TD.X_DES_CITY, TD.COUNTRY,  TD.X_DES_STA, "
				+ "TO_CHAR(TC.CREATED,'YYYYMMDD')CREATED, "
				+ "TC.X_ID_FB,TC.X_ID_TWITTER "
				+ "FROM " + DBO + ".S_ORG_EXT TC, " + DBO + ".S_ADDR_PER TD, " + DBO + ".S_CON_ADDR TR "
				+ "WHERE TC.LAST_UPD "
				+ "BETWEEN TO_DATE('" + FecIni + "','YYYYMMDD') "
				+ "AND TO_DATE('" + FecFin + "','YYYYMMDD') "
				+ "AND TC.ROW_ID=TR.ACCNT_ID(+)  "
				+ "AND TR.ADDR_PER_ID=TD.ROW_ID(+) "
				+ "AND TC.ACCNT_TYPE_CD='Galerias' "
				+ "AND TC.OU_TYPE_CD='Comercial'";

		
		List<CentroComercial> centroscomerciales = new ArrayList<CentroComercial>();
		try {
			stmt = conn.prepareStatement(SELECT_CENCOM);
			rs = stmt.executeQuery();
			while (rs.next()) {
				centroscomerciales.add(new CentroComercial(rs.getString(1), rs
						.getString(2), rs.getString(3), "",rs.getString(4), rs
						.getString(5), rs.getString(6), rs.getString(7), rs.
						getString(8), rs.getString(9)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return centroscomerciales;
	}
}