package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Conexion;
import domain.RespuestaCampanna;

public class RespuestaCampannaDAO {

	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATRCAM = "SELECT TR.SRC_ID, TT.MKTG_OFFR_ID,"
			+ "TT.MEDIA_TYPE_CD, TR.PR_CON_ID, TR.CALL_LST_ID,"
			+ " TR.OUTCOME_CD,TR.COMM_METHOD, TR.MEET_LOC, TO_CHAR(TR.LAST_UPD,'YYYYMMDD')"
			+ "LAST_UPD FROM SIEBEL.S_COMMUNICATION TR, SIEBEL.S_DMND_CRTN_PRG TT, "
			+ "SIEBEL.S_SRC TC WHERE TC.ROW_ID=TR.SRC_ID "
			+ "AND TT.ROW_ID=TR.DCP_ID AND TC.SUB_TYPE ='MARKETING_CAMPAIGN'"
			+ " AND TC.CAMP_TYPE_CD='Campaign' AND TC.MKTG_TMPL_FLG='N'";

	public List<RespuestaCampanna> listarRespuestasCampannas() {
		List<RespuestaCampanna> respuestascampannas = new ArrayList<RespuestaCampanna>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion
					.getConnection();
			stmt = conn.prepareStatement(SELECT_CATRCAM);
			rs = stmt.executeQuery();
			while (rs.next()) {
				respuestascampannas.add(new RespuestaCampanna(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4), rs
								.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return respuestascampannas;
	}
}