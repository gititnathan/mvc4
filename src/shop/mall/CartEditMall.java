package shop.mall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartEditMall implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String qty = req.getParameter("qty");
		
		HttpSession session = req.getSession();
		CartBean cart = (CartBean)session.getAttribute("cart");
		cart.updateCart(Integer.parseInt(pnum), Integer.parseInt(qty));
		
		session.setAttribute("cart", cart);
		
		return "WEB-INF/shop/display/mall_cartList.jsp";
	}

}
