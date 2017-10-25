package shop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteCate implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cnum = req.getParameter("cnum");
		
		String msg = null, url = null;
		if (cnum==null || cnum.trim().equals("")) {
			msg = "������������ �̵��մϴ�.";
			url = "list.shop";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
		
		CategoryBean dao = new CategoryBean();
		int res = 0;
		try {
			res = dao.deleteCategory(Integer.parseInt(cnum));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		if (res>0){
			msg = "��������!! ����������� �̵��մϴ�."; 
			url = "list.shop";
		}else {
			msg = "ī�װ� ��������!! ����������� �̵��մϴ�.";
			url = "list.shop";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
