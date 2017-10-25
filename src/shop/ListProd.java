package shop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListProd implements CommandIf {
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ProductBean dao = new ProductBean();
		ArrayList<ProductDTO> list = null;
		try {
			list = dao.listProduct();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("productList", list);
		return "WEB-INF/shop/admin/prod_list.jsp";
	}

}