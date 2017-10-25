package member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteMember implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String no = req.getParameter("no");
		
		String msg = null, url = null;
		if (no==null || no.trim().equals("")) {
			msg = "회원관리페이지로 이동합니다.";
			url = "index.member";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
		
		MemberDAO dao = new MemberDAO();
		int res = 0;
		try {
			res = dao.deleteMember(Integer.parseInt(no));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		if (res>0){
			msg = "회원삭제성공!! 회원관리페이지로 이동합니다."; 
			url = "index.member";
		}else {
			msg = "회원삭제실패!! 회원가입페이지로 이동합니다.";
			url = "join.member";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
