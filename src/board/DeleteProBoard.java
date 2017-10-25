package board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProBoard implements CommandIf {

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
		String passwd = req.getParameter("passwd");
		BoardDataBean dao = new BoardDataBean();
		int res = 0;
		try {
			res = dao.deleteBoard(Integer.parseInt(num), passwd);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (res>0){
			msg = "게시글삭제성공!! 글목록페이지로 이동합니다."; 
			url = "list.board";
		}else if (res==0){
			msg = "게시글삭제실패!! 글상세보기페이지로 이동합니다.";
			url = "content.board?num="+num;
		}else {
			msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요";
			url = "deleteForm.board?num="+num;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}













