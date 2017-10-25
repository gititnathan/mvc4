package member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindMember implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		
		dao.setSearch(req.getParameter("search"));
		dao.setSearchString(req.getParameter("searchString"));

		ArrayList<MemberDTO> find = null;
		try {
			find = dao.findMember();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("memberFind", find); // find�� �������ִ� ���̴�.
		return "WEB-INF/member/memberFind.jsp"; // ���ο� ������ (���� �� ���� ����� �������� ������ �� find�� ��� ����Ʈ�� �� ��)
	}
}
