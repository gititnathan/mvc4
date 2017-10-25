package board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFormBoard implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String num = req.getParameter("num");
		
		String msg = null, url = null;
		if (num ==null || num.trim().equals("")) {
			msg = "글목록페이지로 이동합니다.";
			url = "list.board";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
		
		BoardDataBean dao = new BoardDataBean();
		BoardDBBean dto = null;
		try {
			dto = dao.getBoard(Integer.parseInt(num));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("getBoard", dto);
		return "WEB-INF/board/updateForm.jsp";
	}

	
	
	
}







