package board;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDataBean {
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
	
	public ArrayList<BoardDBBean> listBoard() throws SQLException{
		String sql = "select * from mvc_board order by re_group desc, re_step asc";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<BoardDBBean> list = makeArrayList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	protected ArrayList<BoardDBBean> makeArrayList(ResultSet rs) throws SQLException{
		ArrayList<BoardDBBean> list = new ArrayList<>();
		while(rs.next()) {
			BoardDBBean dto = new BoardDBBean();
			dto.setNum(rs.getInt("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setEmail(rs.getString("email"));
			dto.setSubject(rs.getString("subject"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setContent(rs.getString("content"));
			dto.setIp(rs.getString("ip"));
			dto.setRe_group(rs.getInt("re_group"));
			dto.setRe_step(rs.getInt("re_step"));
			dto.setRe_level(rs.getInt("re_level"));
			list.add(dto);
		}
		return list;
	}
	
	public int insertBoard(BoardDBBean dto) throws SQLException{
		String sql = null;
		if (dto.getNum() == 0) {
			sql = "select max(num) from mvc_board";
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			dto.setRe_group(rs.getInt(1) + 1);
		}else {
			sql = "update mvc_board set re_step = re_step + 1 where re_group=? and re_step>?";
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getRe_group());
			ps.setInt(2, dto.getRe_step());
			ps.executeUpdate();
			dto.setRe_step(dto.getRe_step() + 1);
			dto.setRe_level(dto.getRe_level() + 1);
		}
		try {
			sql ="insert into mvc_board values (mvc_board_seq.nextval, ?,?,?,?,sysdate,0,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getPasswd());
			ps.setString(5, dto.getContent());
			ps.setString(6, dto.getIp());
			ps.setInt(7, dto.getRe_group());
			ps.setInt(8, dto.getRe_step());
			ps.setInt(9, dto.getRe_level());
			return ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public void plusReadcount(int num) throws SQLException{
		String sql = "update mvc_board set readcount = readcount + 1 "
																			+ "where num = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public BoardDBBean getBoard(int num) throws SQLException{
		String sql = "select * from mvc_board where num = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			ArrayList<BoardDBBean> list = makeArrayList(rs);
			return list.get(0);
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	protected boolean isPassword(int num, String passwd) throws SQLException{
		String sql = "select passwd from mvc_board where num = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if (rs.next()) {
				String dbPass = rs.getString(1);
				if (dbPass.equals(passwd)) {
					return true;
				}
			}
			return false;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int deleteBoard(int num, String passwd) throws SQLException{
		boolean isPass = isPassword(num, passwd);
		if (isPass) {
			try {
				String sql = "delete from mvc_board where num = ?";
				con = ds.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);
				return ps.executeUpdate();
			}finally {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}
		}else {
			return -1;
		}
	}
	
	public int updateBoard(BoardDBBean dto) throws SQLException{
		boolean isPass = isPassword(dto.getNum(), dto.getPasswd());
		if (isPass) {
			try {
				String sql = "update mvc_board set writer=?, subject=?, "
											+ "email=?, content=? where num = ?";
				con = ds.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getWriter());
				ps.setString(2, dto.getSubject());
				ps.setString(3, dto.getEmail());
				ps.setString(4, dto.getContent());
				ps.setInt(5, dto.getNum());
				return ps.executeUpdate();
			}finally {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}
		}else {
			return -1;
		}
	}
	
	public int getCount() throws SQLException{
		String sql = "select count(*) from mvc_board";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			return count;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}















