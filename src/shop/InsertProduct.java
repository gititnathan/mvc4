package shop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertProduct implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryBean dao = new CategoryBean();
		ArrayList<CategoryDTO> list = null;
		try {
			list = dao.listCategory();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("categoryList", list);
		return "WEB-INF/shop/admin/prod_input.jsp";
	}

}
