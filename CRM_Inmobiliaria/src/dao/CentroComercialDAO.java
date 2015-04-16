package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CentroComercial;
import domain.Conexion;

public class CentroComercialDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public List<CentroComercial> listarCentrosComerciales(String FecIni, String FecFin, String cfg) {
		String DBO = "SIEBEL811";
		String SELECT_CENCOM = "SELECT "
				+ "TC.DEPT_NUM, TC.NAME, TD.COUNTY, "
				+ "TD.COUNTRY, TD.STATE, TD.PROVINCE, "
				+ "TD.COUNTRY, "
				+ "TO_CHAR(TC.CREATED,'YYYYMMDD')CREATED, "
				+ "TC.X_ID_FB,TC.X_ID_TWITTER "
				+ "FROM " + DBO + ".S_ORG_EXT TC, "
				+ DBO +".S_ADDR_PER TD, "
				+ DBO +".S_CON_ADDR TR "
				+ "WHERE TC.LAST_UPD "
				+ "BETWEEN TO_DATE('"+FecIni+"','YYYYMMDD') "
				+ "AND TO_DATE('"+FecFin+"','YYYYMMDD') "
				+ "AND TC.ROW_ID=TR.ACCNT_ID "
				+ "AND TR.ADDR_PER_ID=TD.ROW_ID ";
		List<CentroComercial> centroscomerciales = new ArrayList<CentroComercial>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection(cfg);
			stmt = conn.prepareStatement(SELECT_CENCOM);
			rs = stmt.executeQuery();
			while (rs.next()) {
				centroscomerciales.add(new CentroComercial(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5), rs.getString(6), rs.getString(7), rs.
						getString(8), rs.getString(9), rs.getString(10)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return centroscomerciales;
	}
}
