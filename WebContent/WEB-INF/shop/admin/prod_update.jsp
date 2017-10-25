<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, shop.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���θ� ��ǰ ����</title>
<%
		String pnum = request.getParameter("pnum");
		if (pnum==null || pnum.trim().equals("")){
			response.sendRedirect("prod_list.shop");
			return;
		}
		
		ProductDTO dto = (ProductDTO)request.getAttribute("getProduct"); 
		String upPath = config.getServletContext().getRealPath("/WEB-INF/shop/image");
		String spec[] = new String[]{"normal", "hit", "new", "best"};
%>
</head>
<body>
<div align="center">
	<form name="f" action="prod_update_ok.shop" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pnum" value="<%=pnum%>">											
		<table width="600" class="outline">
			<caption>��ǰ����</caption>
			<tr>
				<th width="20%" class="m2">ī�װ�</th>
				<td align="left"><input type="text" name="pcategory_fk" value="<%=dto.getPcategory_fk()%>" disabled></td>
			</tr>
			<tr>
				<th class="m2">��ǰ��ȣ</th>
				<td><%=dto.getPnum()%></td>
			</tr>
			<tr>
				<th class="m2">��ǰ��</th>
				<td><input type="text" name="pname" class="box" value="<%=dto.getPname()%>"></td>
			</tr>
			<tr>
				<th class="m2">������</th>
				<td><input type="text" name="pcompany" class="box" value="<%=dto.getPcompany()%>"></td>
			</tr>
			<tr>
				<th class="m2">��ǰ�̹���</th>
				<td>
					<img src="<%=upPath%>/<%=dto.getPimage()%>" width="60" height="60">
					<input type="file" name="pimage">
					<input type="hidden" name="pimage2" value="<%=dto.getPimage()%>">
				</td>
			</tr>
			<tr>
				<th class="m2">��ǰ����</th>
				<td><input type="text" name="pqty" class="box" value="<%=dto.getPqty()%>"></td>
			</tr>
			<tr>
				<th class="m2">��ǰ����</th>
				<td><input type="text" name="price" class="box" value="<%=dto.getPrice()%>"></td>
			</tr>
			<tr>
				<th class="m2">��ǰ����</th>
				<td>
					<select name="pspec">
<%				for(int i=0; i<spec.length; ++i){ 
						if (dto.getPspec().equals(spec[i])){%>
						<option value="<%=spec[i]%>" selected><%=spec[i]%></option>
<%					}else {%>
						<option value="<%=spec[i]%>"><%=spec[i]%></option>												
<%					}
					} %>						
					</select>
				</td>
			</tr>
			<tr>
				<th class="m2">��ǰ�Ұ�</th>
				<td>
					<textarea name="pcontents" rows="3" cols="50"><%=dto.getPcontents()%></textarea>
				</td>
			</tr>
			<tr>
				<th class="m2">��ǰ����Ʈ</th>
				<td><input type="text" name="point" class="box" value="<%=dto.getPoint()%>"></td>
			</tr>
			<tr>
				<td class="m1" colspan="2">
					<input type="submit" value="��ǰ����">
					<input type="reset" value="���">			
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>