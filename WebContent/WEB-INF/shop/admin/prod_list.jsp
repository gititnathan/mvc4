<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, shop.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	function checkDel(pnum, pimage){
		var isDel = confirm("������ �����Ͻðڽ��ϱ�?")
		if (isDel){
			location.href="delete_prod.shop?pnum="+pnum+"&pimage="+pimage
		}
	}
</script>
<div align="center">
	<table border = "1" class="outline" width="100%">
		<caption>��ǰ���</caption>
		<tr>
			<th class="m2">��ȣ</th>
			<th class="m2">��ǰ�ڵ�</th>
			<th class="m2">��ǰ��</th>
			<th class="m2">�̹���</th>
			<th class="m2">����</th>
			<th class="m2">������</th>
			<th class="m2">����</th>
			<th class="m2">����|����</th>
		</tr>
<%
		ArrayList<ProductDTO> list = (ArrayList)request.getAttribute("productList"); 
		if (list==null || list.size()==0){%>
		<tr>
			<td colspan="8">��ϵ� ��ǰ�� �����ϴ�.</td>
		</tr>
<%	}else { 
			String upPath = config.getServletContext().getRealPath("/WEB-INF/shop/image");
			for(ProductDTO dto : list){%>
		<tr>
			<td align="right"><%=dto.getPnum()%></td>
			<td align="center"><%=dto.getPcategory_fk()%></td>
			<td align="center"><%=dto.getPname()%></td>
			<td align="center">
			<a href="prod_view.shop?pnum=<%=dto.getPnum()%>">
				<img src="<%=upPath%>/<%=dto.getPimage()%>" 
														width="40" height="40">
			</a>														
			</td>
			<td align="right"><%=dto.getPrice()%></td>
			<td align="center"><%=dto.getPcompany()%></td>
			<td align="right"><%=dto.getPqty()%></td>
			<td>
				<a href="prod_update.shop?pnum=<%=dto.getPnum()%>">����</a> | 
				<a href="javascript:checkDel('<%=dto.getPnum()%>', '<%=dto.getPimage()%>')">����</a>
			</td>
		</tr>	
<%		}
		}	%>				
	</table>
</div>
</body>
</html>