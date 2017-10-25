package shop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertOkCate implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDTO dto = new CategoryDTO();
		dto.setCname(req.getParameter("cname"));
		dto.setCode(req.getParameter("code"));
		
		String msg = null, url = null;
		if (dto.getCname()==null || dto.getCname().trim().equals("")) {
			msg = "ī�װ� ��� �������� �̵��մϴ�.";
			url = "input.shop";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
		
		CategoryBean dao = new CategoryBean();
		int res = 0;
		try {
			res = dao.insertCategory(dto);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (res>0){
			msg = "ī�װ� ��� ����!! ������ �������� �̵��մϴ�."; 
			url = "admin.shop";
		}else {
			msg = "ī�װ� ��Ͻ���!! ī�װ� ��� �������� �̵��մϴ�.";
			url = "input.shop";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
