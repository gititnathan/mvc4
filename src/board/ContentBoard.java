package board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentBoard implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String num = req.getParameter("num");
		
		String msg = null, url = null;
		if (num ==null || num.trim().equals("")) {
			msg = "�۸���������� �̵��մϴ�.";
			url = "list.board";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
		
		BoardDataBean dao = new BoardDataBean();
		BoardDBBean dto = null;
		
		boolean isCheck = false; // boolean���� �޾Ƽ� Ȯ���ϰ�.
		Cookie cks[] = req.getCookies(); // 
		if (cks != null || cks.length != 0) {
			for(int i=0; i<cks.length; ++i) {
				if (cks[i].getName().equals(num)) {
					isCheck = true;
					break;
				}
			}
		}
		
		try {
			if (!isCheck) {
				dao.plusReadcount(Integer.parseInt(num));
				Cookie ck = new Cookie(num, "check");
				ck.setMaxAge(24*60*60);
				resp.addCookie(ck);
			}
			dto = dao.getBoard(Integer.parseInt(num));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("getBoard", dto);
		return "WEB-INF/board/content.jsp";
	}

}
















