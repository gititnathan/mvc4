package member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertOkMember implements CommandIf { // �긦 ���ؼ� ����°� ������!)

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		dto.setName(req.getParameter("name"));
		dto.setId(req.getParameter("id"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setSsn1(req.getParameter("ssn1"));
		dto.setSsn2(req.getParameter("ssn2"));
		dto.setEmail(req.getParameter("email"));
		dto.setHp1(req.getParameter("hp1"));
		dto.setHp2(req.getParameter("hp2"));
		dto.setHp3(req.getParameter("hp3"));
		
		String msg = null, url = null;
		if (dto.getName()==null || dto.getName().trim().equals("")) {
			msg = "ȸ�������������� �̵��մϴ�.";
			url = "join.member";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
		
		MemberDAO dao = new MemberDAO();
		int res = 0;
		try {
			res = dao.insertMember(dto);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (res>0){
			msg = "ȸ����ϼ���!! ȸ�������������� �̵��մϴ�."; 
			url = "index.member";
		}else {
			msg = "ȸ����Ͻ���!! ȸ�������������� �̵��մϴ�.";
			url = "join.member";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}








