package shop.mall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartDelMall implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		
		HttpSession session = req.getSession();
		CartBean cart = (CartBean)session.getAttribute("cart");
		
		cart.deleteCart(Integer.parseInt(pnum));
		
		session.setAttribute("cart", cart);
		
		return "WEB-INF/shop/display/mall_cartList.jsp";
	}

}
