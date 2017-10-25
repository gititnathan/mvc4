package shop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProd implements CommandIf {

	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String pnum = req.getParameter("pnum");
		
		String msg = null, url = null;
		if (pnum ==null || pnum.trim().equals("")) {
			msg = "목록 페이지로 이동합니다.";
			url = "list_prod.shop";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
		
		ProductBean dao = new ProductBean();
		ProductDTO dto = null;
		try {
			dto = dao.getProduct(Integer.parseInt(pnum));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("getProduct", dto);
		return "WEB-INF/shop/admin/prod_update.jsp";
	}

}
