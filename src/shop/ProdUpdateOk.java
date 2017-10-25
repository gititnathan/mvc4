package shop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class ProdUpdateOk implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MultipartRequest mr = null;
		String upPath = req.getServletContext().getRealPath("/WEB-INF/shop/image");
		int len = 10*1024*1024;
		try{
			mr = new MultipartRequest(req, upPath, len, "EUC-KR");//생성자에 4개의 매개변수 입력!!
		}//이때 발생하는 예외는??
		catch(IOException e){
			System.out.println("오류 발생!");
			req.setAttribute("msg", "상품 수정 오류");
			req.setAttribute("url", "update_prod.shop?pnum=" + mr.getParameter("pnum"));
			e.printStackTrace();//오류체크해보기...
		}

		ProductBean dao = new ProductBean();

		//mr객체를 DAO에 넘겨서 수정 처리하기
		int res = 0;
		try {
			res = dao.updateProduct(mr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (res>0){
			req.setAttribute("msg","상품 수정 성공!! 상품목록페이지로 이동합니다.");
			req.setAttribute("url", "list_prod.shop");
		}else { 	
			req.setAttribute("msg","상품 수정 실패!! 상품수정페이지로 이동합니다.");
			req.setAttribute("url", "update_prod.shop?pnum=" + mr.getParameter("pnum"));
		}
		return "message.jsp";
	}
}