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
	private String SELECT_CENCOM = "SELECT TC.ROW_ID, TC.NAME, TC.CREATED, TC.X_ID_FB, TC.X_ID_TWITTER "
			+ "FROM SIEBEL811.S_ORG_EXT TC WHERE CMPT_FLG = 'N' AND ACCNT_TYPE_CD='Galerias' ";

	public List<CentroComercial> listarCentrosComerciales() {
		List<CentroComercial> centroscomerciales = new ArrayList<CentroComercial>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CENCOM);
			rs = stmt.executeQuery();
			while (rs.next()) {
				centroscomerciales.add(new CentroComercial(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return centroscomerciales;
	}
}
