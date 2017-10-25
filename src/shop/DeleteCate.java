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
			msg = "메인페이지로 이동합니다.";
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
			msg = "삭제성공!! 목록페이지로 이동합니다."; 
			url = "list.shop";
		}else {
			msg = "카테고리 삭제실패!! 목록페이지로 이동합니다.";
			url = "list.shop";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
