package baseball;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchTeam implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TeamBean dao = new TeamBean();
		ArrayList<TeamDTO> list = null;
		try {
			list = dao.listTeam();
		}catch(SQLException e) {
			e.getStackTrace();
		}
		req.setAttribute("teamList", list);
		return  "WEB-INF/baseball/searchbyTeam.jsp";
	}

}
