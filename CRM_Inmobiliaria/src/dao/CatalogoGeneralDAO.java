package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CatalogoGeneral;
import domain.Conexion;

public class CatalogoGeneralDAO {

	private Connection userConn=null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATGEN = "SELECT ROW_ID, PAR_ROW_ID,TYPE,SUB_TYPE, VAL, NAME, DESC_TEXT, ORDER_BY "
			+ "FROM SIEBEL811.S_LST_OF_VAL "
			+ "WHERE ACTIVE_FLG='Y' ORDER BY TYPE";
	

	public List<CatalogoGeneral> listarCatalogosGenerales() {
		List<CatalogoGeneral> catalogosgenerales = new ArrayList<CatalogoGeneral>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
			stmt = conn.prepareStatement(SELECT_CATGEN);
			rs = stmt.executeQuery();
			while (rs.next()) {
				catalogosgenerales.add(new CatalogoGeneral(rs.getString(1), rs.getString(2),
						rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getInt(8)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return catalogosgenerales;
	}
}
