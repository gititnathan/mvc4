package shop.mall;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.CategoryBean;
import shop.CategoryDTO;
import shop.ProductDTO;

public class CartListMall implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			HttpSession session = req.getSession();
			if (session.getAttribute("listCart") == null) {
				CartBean dao = new CartBean();
				Hashtable<Integer, ProductDTO> list = null;

				list = dao.listCart();
		
			
			if (list==null || list.size()==0) {
				String msg = "쇼핑몰 페이지로 이동합니다.";
				String url = "admin.shop";
				req.setAttribute("msg", msg);
				req.setAttribute("url", url);
				return "message.jsp";
			}
			session.setAttribute("listCart", list);
		}
		

		return "WEB-INF/shop/display/mall_cartList.jsp";
	}

}
