package member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditOkMember implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		dto.setPasswd(req.getParameter("passwd"));
		
		String msg = null, url = null;
		if (dto.getPasswd()==null || dto.getPasswd().trim().equals("")) {
			msg = "회원목록페이지로 이동합니다.";
			url = "list.member";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
		
		dto.setEmail(req.getParameter("email"));
		dto.setHp1(req.getParameter("hp1"));
		dto.setHp2(req.getParameter("hp2"));
		dto.setHp3(req.getParameter("hp3"));
		dto.setNo(Integer.parseInt(req.getParameter("no")));
		
		MemberDAO dao = new MemberDAO();
		int res = 0;
		try {
			res = dao.updateMember(dto);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		if (res>0){
			msg = "회원수정성공!! 회원보기페이지로 이동합니다."; 
			url = "list.member";
		}else {
			msg = "회원수정실패!! 회원보기페이지로 이동합니다.";
			url = "list.member";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}















