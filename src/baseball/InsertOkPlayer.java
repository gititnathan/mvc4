package baseball;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertOkPlayer implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PlayerDTO dto = new PlayerDTO();
		TeamDTO tdto = new TeamDTO();
		dto.setName(req.getParameter("name"));
		tdto.setNo(Integer.parseInt(req.getParameter("team_no")));
		int teamNum = tdto.getNo();
		dto.setTeam_no(teamNum);
		dto.setSalary(Integer.parseInt(req.getParameter("salary")));
		dto.setGrand(req.getParameter("grand"));
		dto.setContent(req.getParameter("content"));
		
		String msg = null, url = null;
		if (dto.getTeam_no()==0 || dto.getName().trim().equals("")) {
			msg = "팀명을 불러 올 수 없습니다. 메인 페이지로 이동합니다.";
			url = "main.base";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
		
		PlayerBean dao = new PlayerBean();
		int res = 0;
		try {
			res = dao.insertPlayer(dto);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (res>0){
			msg = "선수 등록 성공!! 전체 선수 리스트 페이지로 이동합니다."; 
			url = "list.base";
		}else {
			msg = "선수 등록실패!! 선수 등록 페이지로 이동합니다.";
			url = "input.base";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
