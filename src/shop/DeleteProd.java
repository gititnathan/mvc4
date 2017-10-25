package shop;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProd implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String pimage = req.getParameter("pimage");


		String msg = null, url = null;
		if (pnum==null || pnum.trim().equals("")) {
			msg = "메인페이지로 이동합니다.";
			url = "list_prod.shop";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}

		ProductBean dao = new ProductBean();
		int res = 0;
		try {
			res = dao.deleteProduct(Integer.parseInt(pnum));
		}catch(SQLException e) {
			e.printStackTrace();
		}

		msg = null;
		url = "list_prod.shop";

		if (res>0){
			File file = new File
					(req.getServletContext().getRealPath("/WEB-INF/shop/image"), pimage);
			if (file.exists()){
				file.delete();
				msg = "상품삭제 성공!! 상품목록으로 이동합니다.";
			}else {
				msg = "상품삭제 성공(이미지는 삭제는 실패)!!"
						+" 상품목록으로 이동합니다.";
			}
		}else {
			msg = "상품삭제 실패!! 상품목록으로 이동합니다.";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";

	}

}
