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
			mr = new MultipartRequest(req, upPath, len, "EUC-KR");//�����ڿ� 4���� �Ű����� �Է�!!
		}//�̶� �߻��ϴ� ���ܴ�??
		catch(IOException e){
			System.out.println("���� �߻�!");
			req.setAttribute("msg", "��ǰ ���� ����");
			req.setAttribute("url", "update_prod.shop?pnum=" + mr.getParameter("pnum"));
			e.printStackTrace();//����üũ�غ���...
		}

		ProductBean dao = new ProductBean();

		//mr��ü�� DAO�� �Ѱܼ� ���� ó���ϱ�
		int res = 0;
		try {
			res = dao.updateProduct(mr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (res>0){
			req.setAttribute("msg","��ǰ ���� ����!! ��ǰ����������� �̵��մϴ�.");
			req.setAttribute("url", "list_prod.shop");
		}else { 	
			req.setAttribute("msg","��ǰ ���� ����!! ��ǰ������������ �̵��մϴ�.");
			req.setAttribute("url", "update_prod.shop?pnum=" + mr.getParameter("pnum"));
		}
		return "message.jsp";
	}
}