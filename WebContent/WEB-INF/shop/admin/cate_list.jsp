<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import = "java.util.*,shop.*"%>
<html>
<head>
<title>ī�װ� ���</title>
</head>
<body>
<div align="center">
		<h3> ī�װ� ���</h3>
		<hr color="green" width="600">
		<table border= "1" width="100%" class="outline">
			<tr>
				<th class="m3">��ȣ</th>
				<th class="m3">ī�װ�</th>
				<th class="m3">ī�װ���</th>
			
				<th class="m3">����</th>
			</tr>
	<%		ArrayList<CategoryDTO> list = (ArrayList)request.getAttribute("categoryList");
			if (list==null || list.size()==0){%>
			<tr>
				<td colspan="4">��ϵ� ī�װ��� �����ϴ�.</td>
			</tr>
<%		}else {
				for(CategoryDTO dto : list){%>						
			<tr>
				<td><%=dto.getCnum()%></td>
				<td><%=dto.getCode()%></td>
				<td><%=dto.getCname()%></td>
				<td>
				<a href="delete.shop?cnum=<%=dto.getCnum()%>">����</a></td> 
				<!--  ���⼭ ?cnum�̶�� �ϴ� ���� �ű⼭ � �༮�� ���� ��ü������ Ȯ���ϴ� ��. -->
			</tr>	
<%			} %>
<%		} %>
		</table>
	</div>
</body>
</html>