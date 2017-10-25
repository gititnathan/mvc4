package baseball;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListPlayer implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PlayerBean dao = new PlayerBean();
		ArrayList<PlayerDTO> list = null;
		try {
			list = dao.listPlayer();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		// ��ȣ���� ���ܸ� ���̴°� �����ߵ�!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		req.setAttribute("playerList", list);
		return "WEB-INF/baseball/player_list.jsp";
	}

}
