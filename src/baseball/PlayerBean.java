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


public class PlayerBean {
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
	
	public int insertPlayer(PlayerDTO dto) throws SQLException{
		String sql = "insert into mvc_player values(mvc_player_seq.nextval, ?,?,?,?,?)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getTeam_no());
			ps.setInt(3, dto.getSalary());
			ps.setString(4, dto.getGrand());
			ps.setString(5, dto.getContent());
			int res = ps.executeUpdate();
			return res;
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public ArrayList<PlayerDTO> listPlayer() throws SQLException{
		String sql = "select * from mvc_player";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<PlayerDTO> list = new ArrayList<>();
			while(rs.next()) {
				PlayerDTO dto = new PlayerDTO();
				dto.setNo(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setTeam_no(rs.getInt("team_no"));
				dto.setSalary(rs.getInt("salary"));
				dto.setGrand(rs.getString("grand"));
				dto.setContent(rs.getString("content"));
				list.add(dto);
			}
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public ArrayList<PlayerDTO> listByTeam(int team_no) throws SQLException{
		String sql = "select * from mvc_player where team_no = ? ";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, team_no);
			rs = ps.executeQuery();
			ArrayList<PlayerDTO> list = new ArrayList<>();
			while(rs.next()) {
				PlayerDTO dto = new PlayerDTO();
				dto.setNo(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setTeam_no(rs.getInt("team_no"));
				dto.setSalary(rs.getInt("salary"));
				dto.setGrand(rs.getString("grand"));
				dto.setContent(rs.getString("content"));
				list.add(dto);
			}
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int deletePlayer(int no) throws SQLException {
		String sql = "delete from mvc_player where num = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			int res = ps.executeUpdate();
			return res;
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}	
