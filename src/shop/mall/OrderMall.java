package shop.mall;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.ProductDTO;

public class OrderMall implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("cart") == null) {
			CartBean dao = new CartBean();
			Hashtable<Integer, ProductDTO> list = null;

			list = dao.listCart();
	
		session.setAttribute("cart", list);
	}
	

	return "WEB-INF/shop/display/mall_order.jsp";
	}

}
