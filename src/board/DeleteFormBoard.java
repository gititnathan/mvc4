package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormBoard implements CommandIf {

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
		
		return "WEB-INF/board/deleteForm.jsp";
	}

}
