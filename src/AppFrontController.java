import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppFrontController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
																	throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html; charset=EUC-KR");
		
		String uri = req.getRequestURI();		//전체주소 가져오기
		String path = req.getContextPath();	//프로젝트(루트) 가져오기
		String cmd = uri.substring(path.length());
		
		String nextPage = null;
		if (cmd.equals("/index.app")) {
			nextPage = "index.jsp";
		}else if (cmd.equals("/member.app")) {
			nextPage = "index.member";
		}else if (cmd.equals("/board.app")) {
			nextPage = "list.board";
		}else if (cmd.equals("/shop.app")) {
			nextPage = "admin.shop";
		}else if (cmd.equals("/base.app")) {
			nextPage = "main.base";
		}
		
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}
	
}
















