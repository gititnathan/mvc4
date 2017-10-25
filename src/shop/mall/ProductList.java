package shop.mall;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import shop.ProductDTO;

import java.sql.*;

public class ProductList {
	public static Hashtable<String, Vector<ProductDTO>> ht;
	Vector<ProductDTO> p_list, p_list2;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	static DataSource ds;
	static{
		try{
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
		}catch(NamingException e){
			System.out.println("lookup½ÇÆÐ : " + e.getMessage());
		}
		ht = new Hashtable<>();
	}

	public ProductList() {
		
		p_list = new Vector<>(5,3);
		p_list2 = new Vector<>(5,3);
	}
	
	public void selectBySpec(String pspec) throws SQLException{
		String sql = "select * from product where pspec=?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pspec);
			rs = ps.executeQuery();
			p_list = makeVector(rs);
			ht.put(pspec, p_list);
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public Vector<ProductDTO> makeVector(ResultSet rs) throws SQLException{
		Vector<ProductDTO> list = new Vector<>();
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setPnum(rs.getInt("pnum"));
			dto.setPname(rs.getString("pname"));
			dto.setPcategory_fk(rs.getString("pcategory_fk"));
			dto.setPcompany(rs.getString("pcompany"));
			dto.setPimage(rs.getString("pimage"));
			dto.setPqty(rs.getInt("pqty"));
			dto.setPrice(rs.getInt("price"));
			dto.setPspec(rs.getString("pspec"));
			dto.setPcontents(rs.getString("pcontents"));
			dto.setPoint(rs.getInt("point"));
			dto.setPinputdate(rs.getString("pinputdate"));
			list.add(dto);
		}
		return list;
	}
	
	public void selectByCode(String code) throws SQLException{
		String sql = "select * from product where pcategory_fk like ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, code+"%");
			rs = ps.executeQuery();
			p_list = makeVector(rs);
			ht.put(code, p_list);
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public ProductDTO getProduct(int pnum, String select) {
		p_list2 = ht.get(select);
		for(ProductDTO dto : p_list2) {
			if (dto.getPnum() == pnum) {
				return dto;
			}
		}
		return null;
	}
}










