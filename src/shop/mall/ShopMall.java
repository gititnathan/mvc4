package shop.mall;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.CategoryBean;
import shop.CategoryDTO;

public class ShopMall implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if (session.getAttribute("listCate") == null) {
			CategoryBean dao = new CategoryBean();
			ArrayList<CategoryDTO> list = null;
			try {
				list = dao.listCategory();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			if (list==null || list.size()==0) {
				String msg = "쇼핑몰 페이지로 이동합니다.";
				String url = "admin.shop";
				req.setAttribute("msg", msg);
				req.setAttribute("url", url);
				return "message.jsp";
			}
			session.setAttribute("listCate", list);
		}
		
		ProductList plist = new ProductList();
		try {
			plist.selectBySpec("hit");
			plist.selectBySpec("new");
			plist.selectBySpec("best");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return "WEB-INF/shop/display/mall.jsp";
	}

}
















