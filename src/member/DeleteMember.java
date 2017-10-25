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
			msg = "ȸ�������������� �̵��մϴ�.";
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
			msg = "ȸ����������!! ȸ�������������� �̵��մϴ�."; 
			url = "index.member";
		}else {
			msg = "ȸ����������!! ȸ�������������� �̵��մϴ�.";
			url = "join.member";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
