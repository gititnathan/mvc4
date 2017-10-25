package board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteProBoard implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDBBean dto = new BoardDBBean();
		dto.setWriter(req.getParameter("writer"));
		
		String msg = null, url = null;
		if (dto.getWriter()==null || dto.getWriter().trim().equals("")) {
			msg = "�۸���������� �̵��մϴ�.";
			url = "list.board";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
		
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		dto.setRe_group(Integer.parseInt(req.getParameter("re_group")));
		dto.setRe_step(Integer.parseInt(req.getParameter("re_step")));
		dto.setRe_level(Integer.parseInt(req.getParameter("re_level")));
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setContent(req.getParameter("content"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setIp(req.getRemoteAddr());
		BoardDataBean dao = new BoardDataBean();
		int res = 0;
		try {
			res = dao.insertBoard(dto);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (res>0){
			msg = "�Խñ۵�ϼ���!! �۸���������� �̵��մϴ�."; 
			url = "list.board";
		}else {
			msg = "�Խñ۵�Ͻ���!! �Խñ۵���������� �̵��մϴ�.";
			url = "writeForm.board";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
		
	
	}

}










