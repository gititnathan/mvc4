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
		// teamList�� �޾ƿ԰� �� teamlist���� getNo���� ������ ��ȣ�� ������ �̸��̶� ���Ѵ����� ���� ArrayList�� �ִ� �ֵ��� �����ٰ� �˻����ָ� ���ݾ�.
		// �ƴϸ� teamlist �޾Ƽ� / no�̶� team_no�� ���ؼ� /team_no�� �ش��ϴ� �ֵ��� ����Ʈ�� �ҷ����� �ؾ���.
		
		tdto.setNo(Integer.parseInt(req.getParameter("team_no")));
		int team_no = tdto.getNo();
		
		PlayerBean pdao = new PlayerBean();
		ArrayList<PlayerDTO> plist = null;
		try {
			plist = pdao.listByTeam(team_no);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		// ��ȣ���� ���ܸ� ���̴°� �����ߵ�!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		req.setAttribute("playerList", plist);
		
		
		return "WEB-INF/baseball/player_list.jsp";
	}
}
