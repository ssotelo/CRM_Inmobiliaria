package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CampannaLista;
import domain.Conexion;

public class CampannaListaDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATCAMLIS = "SELECT TL.SRC_ID, TL.CALL_LST_ID, "
			+ "TO_CHAR(TL.CREATED,'YYYYMMDD')CREATED,"
			+ "TO_CHAR(TL.LAST_UPD,'YYYYMMDD')LAST_UPD "
			+ "FROM SIEBEL.S_CAMP_CALL_LST TL, SIEBEL.S_SRC TC "
			+ "WHERE TL.SRC_ID=TC.ROW_ID "
			+ "AND TC.SUB_TYPE ='MARKETING_CAMPAIGN' "
			+ "AND TC.CAMP_TYPE_CD='Campaign' " + "AND TC.MKTG_TMPL_FLG='N'";

	public List<CampannaLista> listarCampannasListas() {
		List<CampannaLista> clc = new ArrayList<CampannaLista>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATCAMLIS);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clc.add(new CampannaLista(rs.getString(1), rs.getString(2), rs
						.getString(3), "", rs.getString(4)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clc;
	}
}
