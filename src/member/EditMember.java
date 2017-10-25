package member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditMember implements CommandIf {

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
		
		MemberDTO dto = null;
		MemberDAO dao = new MemberDAO();
		try {
			dto = dao.getMember(Integer.parseInt(no));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("getMember", dto);
		return "WEB-INF/member/member_edit.jsp";
	}

}







