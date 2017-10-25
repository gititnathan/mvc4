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
			msg = "글목록페이지로 이동합니다.";
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
			msg = "게시글등록성공!! 글목록페이지로 이동합니다."; 
			url = "list.board";
		}else {
			msg = "게시글등록실패!! 게시글등록페이지로 이동합니다.";
			url = "writeForm.board";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
		
	
	}

}










