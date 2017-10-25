package baseball;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class TeamBean {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	static DataSource ds;//javax.sql.*
	static{
		try{
			Context init = new InitialContext();//javax.naming.*
			ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
		}catch(NamingException e){
			System.out.println("lookup½ÇÆÐ : " + e.getMessage());
		}
	}
	
	public ArrayList<TeamDTO> listTeam() throws SQLException{
		String sql = "select * from mvc_team";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<TeamDTO> list = new ArrayList<>();
			while(rs.next()) {
				TeamDTO dto = new TeamDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				list.add(dto);
			}
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}
