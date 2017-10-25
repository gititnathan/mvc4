package shop.mall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartAddMall implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String select = req.getParameter("select");
		String qty = req.getParameter("qty");
		
		HttpSession session = req.getSession();
		CartBean cart = (CartBean)session.getAttribute("cart");
		 
		if (cart==null) {
			cart = new CartBean();
			cart.setPlist(new ProductList());
		}
		
		cart.addCart(Integer.parseInt(pnum), Integer.parseInt(qty), select);
		
		session.setAttribute("cart", cart);
		
		return "WEB-INF/shop/display/mall_cartList.jsp";
	}

}
