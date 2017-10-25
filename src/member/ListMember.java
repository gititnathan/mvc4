package member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListMember implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = null;
		try {
			list = dao.listMember();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("memberList", list);
		return "WEB-INF/member/memberAll.jsp";
	}

}
