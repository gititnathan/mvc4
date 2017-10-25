package shop;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class InsertOkProduct implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MultipartRequest mr = null;
		String upPath = 
				req.getServletContext().getRealPath("/WEB-INF/shop/image");
		int len = 10*1024*1024;
		try{
			mr = new MultipartRequest(req, upPath, len, "EUC-KR");
		}catch(IOException e){		
			e.printStackTrace();	
			req.setAttribute("msg", "��ǰ��� ���ҷ�?");
			req.setAttribute("url", "prod_input.shop");
			return "message.jsp";
		}
		
		String msg = null, url = null;
		
		
		ProductBean dao = new ProductBean();
		int res = 0;
		try {
			res = dao.insertProduct(mr);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if (res>0){
			msg = "��ǰ ��� ����!! ������ �������� �̵��մϴ�."; 
			url = "list_prod.shop";
		}else {
			msg = "ī�װ� ��Ͻ���!! ī�װ� ��� �������� �̵��մϴ�.";
			url = "input_prod.shop";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
