package board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProBoard implements CommandIf {

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
		BoardDBBean dto = new BoardDBBean();
		dto.setNum(Integer.parseInt("num"));
		dto.setWriter(req.getParameter("writer"));
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setContent(req.getParameter("content"));
		dto.setPasswd(req.getParameter("passwd"));
		
		BoardDataBean dao = new BoardDataBean();
		int res = 0;
		try {
			res = dao.updateBoard(dto);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (res>0){
			msg = "게시글수정성공!! 글목록페이지로 이동합니다."; 
			url = "list.board";
		}else if (res==0){
			msg = "게시글수정실패!! 글상세보기페이지로 이동합니다.";
			url = "content.board?num="+num;
		}else {
			msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요";
			url = "updateForm.board?num="+num;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}











