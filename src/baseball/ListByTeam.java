package baseball;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListByTeam implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TeamBean dao = new TeamBean();
		TeamDTO tdto = new TeamDTO();

		ArrayList<TeamDTO> list = null;
		try {
			list = dao.listTeam();
		}catch(SQLException e) {
			e.getStackTrace();
		}
		req.setAttribute("teamList", list);
		// teamList를 받아왔고 그 teamlist에서 getNo으로 구단의 번호를 꺼내서 이름이랑 비교한다음에 같은 ArrayList에 있는 애들을 꺼내다가 검색해주면 되잖아.
		// 아니면 teamlist 받아서 / no이랑 team_no랑 비교해서 /team_no에 해당하는 애들을 리스트로 불러오게 해야지.
		
		tdto.setNo(Integer.parseInt(req.getParameter("team_no")));
		int team_no = tdto.getNo();
		
		PlayerBean pdao = new PlayerBean();
		ArrayList<PlayerDTO> plist = null;
		try {
			plist = pdao.listByTeam(team_no);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		// 번호마다 구단명 붙이는거 만들어야됨!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		req.setAttribute("playerList", plist);
		
		
		return "WEB-INF/baseball/player_list.jsp";
	}
}
