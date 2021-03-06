package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Competencia;
import domain.Conexion;

public class CompetenciaDAO {
	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_COMP = "SELECT PP.DEPT_NUM, PP.NAME AS TIENDA,TH.NAME AS COMPETENCIA, TH.X_ID_FB, TH.X_ID_TWITTER "
			+ "FROM SIEBEL811.S_ORG_EXT PP, SIEBEL811.S_ORG_EXT TH, SIEBEL811.S_PARTY_REL TR "
			+ "WHERE TR.REL_PARTY_ID=PP.ROW_ID AND TR.PARTY_ID=TH.ROW_ID  "
			+ "ORDER BY PP.NAME";

	public List<Competencia> listarCompetencias() {
		List<Competencia> competencias = new ArrayList<Competencia>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_COMP);
			rs = stmt.executeQuery();
			while (rs.next()) {
				competencias.add(new Competencia(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return competencias;
	}

}
