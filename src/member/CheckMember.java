package member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckMember implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String ssn1 = req.getParameter("ssn1");
		String ssn2 = req.getParameter("ssn2");
		
		String msg = null, url = null;
		if (name==null || ssn1==null || ssn2==null || name.trim().equals("") || 
				ssn1.trim().equals("") || ssn2.trim().equals("")) {
			msg = "이름과 주민번호를 모두 입력해 주세요";
			url = "join.member";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
		
		MemberDAO dao = new MemberDAO();
		boolean isMember = false;
		try {
			isMember = dao.checkMember(name, ssn1, ssn2);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (isMember) {
			msg = "저희 회원이십니다. 로그인을 해 주세요!!";
			url = "index.app";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}else {
			msg = "회원가입페이지로 이동합니다.";
			url = "insert.member";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message2.jsp";
		}
	}
}

















