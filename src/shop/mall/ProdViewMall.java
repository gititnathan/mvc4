package shop.mall;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.ProductDTO;


public class ProdViewMall implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String select = req.getParameter("select");
		ProductList plist = new ProductList();
		if (pnum==null || pnum.trim().equals("") || select==null || select.trim().equals("") ) {
			String msg = "값이 없다 멍청아ㅏㅏㅏㅏㅏㅏㅏㅏㅏ";
			String url = "admin.shop";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
		}
		
		try {
			plist.selectBySpec("hit");
			plist.selectBySpec("new");
			plist.selectBySpec("best");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		ProductDTO dto =  plist.getProduct(Integer.parseInt(pnum), select);
		
		req.setAttribute("getProduct", dto);
		return "WEB-INF/shop/display/mall_prodView.jsp";
	}

}
