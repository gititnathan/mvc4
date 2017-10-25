package board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListBoard implements CommandIf {

	@Override
	public Object precessCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		BoardDataBean dao = new BoardDataBean();
		ArrayList<BoardDBBean> list = null;
		try {
			list = dao.listBoard();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("boardList", list);
		return "WEB-INF/board/list.jsp";
	}
}














