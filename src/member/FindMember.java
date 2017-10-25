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
		
		req.setAttribute("memberFind", find); // find를 저장해주는 것이다.
		return "WEB-INF/member/memberFind.jsp"; // 새로운 페이지 (내가 이 값을 들고가서 연결해줄 페이지 즉 find한 결과 리스트가 뜰 곳)
	}
}
