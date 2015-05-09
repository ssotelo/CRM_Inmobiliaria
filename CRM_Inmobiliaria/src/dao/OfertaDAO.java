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

import domain.Oferta;

public class OfertaDAO {
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String DBO = null;
	
	public List<Oferta> listarOfertas(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_CATOFE = "SELECT ROW_ID, X_TYPE_NUM, NAME,"
				+ "REPLACE(REPLACE(COMMENTS,CHR(13),''),CHR(10),'')COMMENTS, "
				+ "APPR_STAT_CD,"
				+ "TO_CHAR(START_DT,'YYYYMMDD')START_DT, TO_CHAR(END_DT,'YYYYMMDD')END_DT, "
				+ "TO_CHAR(TRUNC(LAST_UPD),'YYYYMMDD')LAST_UPD, X_ID_OFFER "
				+ "FROM " + DBO + ".S_MKTG_OFFR "
				+ "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD')";

		List<Oferta> ofertas = new ArrayList<Oferta>();
		try {
			stmt = conn.prepareStatement(SELECT_CATOFE);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ofertas.add(new Oferta(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return ofertas;
	}

	public List<Oferta> listarOfertasCtl(String FecIni, String FecFin, String cfg, Connection conn) {
		Properties prop = new Properties();
		InputStream configFile = null;
		try {
			configFile = new FileInputStream(cfg);
			prop.load(configFile);
			DBO = prop.getProperty("DBO_BD");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String SELECT_OFECTL = "SELECT "
				+ "TO_CHAR(SYSDATE,'YYYYMMDD')HOY, "
				+ "TO_CHAR(TRUNC(LAST_UPD),'YYYYMMDD')LAST_UPD, "
				+ "COUNT(TRUNC(LAST_UPD)) AS TOTAL "
				+ "FROM " + DBO + ".S_MKTG_OFFR " + "WHERE LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "GROUP BY TRUNC(LAST_UPD) " + "ORDER BY LAST_UPD";
		List<Oferta> ofertas = new ArrayList<Oferta>();
		try {
			stmt = conn.prepareStatement(SELECT_OFECTL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ofertas.add(new Oferta(rs.getString(1), rs.getString(2), rs
						.getString(3)));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return ofertas;
	}
}