package shop.mall;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CgProdList implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String code = req.getParameter("code");
		ProductList plist = new ProductList();
		try {
			plist.selectByCode(code);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return "WEB-INF/shop/display/mall_cgProdList.jsp";
	}

}
