package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Cliente;
import domain.Conexion;

public class ClienteDAO {

	private Connection userConn = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String SELECT_CATCLI = "SELECT TC.ROW_ID, TC.FST_NAME, TC.LAST_NAME, TC.MID_NAME, "
			+ "TC.SOC_SECURITY_NUM, TC.SEX_MF, TC.MARITAL_STAT_CD, "
			+ "TO_CHAR(TC.BIRTH_DT,'YYYYMMDD')BIRTH_DT, TO_CHAR(TC.CREATED,'YYYYMMDD')CREATED, "
			+ "TO_CHAR(TC.LAST_UPD,'YYYYMMDD')LAST_UPD, TC.X_ID_CUST, TC.PERSON_UID, "
			+ "TC.ALIAS_NAME "
			+ "FROM SIEBEL811.S_CONTACT TC";

	public List<Cliente> listarClientes(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
			stmt = conn.prepareStatement(SELECT_CATCLI);
			rs = stmt.executeQuery();
			while (rs.next()) {
				clientes.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
						rs.getString(12),rs.getString(13)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return clientes;
	}
}