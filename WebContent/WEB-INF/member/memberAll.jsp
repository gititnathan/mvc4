<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, member.*"%>
<!-- memberAll.jsp -->
<html>
<head>
	<title>mvc���</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>	
	<div align="center">
		<hr color="green" width="300">
		<h2>ȸ �� �� �� �� ��</h2>
		<hr color="green" width="300">
		<table width="100%" class="outline">
			<tr>
				<th class="m3">��ȣ</th>
				<th class="m3">�̸�</th>
				<th class="m3">���̵�</th>
				<th class="m3">�̸���</th>
				<th class="m3">��ȭ��ȣ</th>
				<th class="m3">������</th>
				<th class="m3">���� | ����</th>
			</tr>
<%		ArrayList<MemberDTO> list = (ArrayList)request.getAttribute("memberList");
			if (list==null || list.size()==0){%>
			<tr>
				<td colspan="7">��ϵ� ȸ���� �����ϴ�.</td>
			</tr>
<%		}else {
				for(MemberDTO dto : list){%>						
			<tr>
				<td><%=dto.getNo()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getEmail()%></td>
				<td><%=dto.getAllHp()%></td>
				<td><%=dto.getJoindate()%></td>
				<td>
				<a href="edit.member?no=<%=dto.getNo()%>">����</a> | 
				<a href="delete.member?no=<%=dto.getNo()%>">����</a></td>
			</tr>	
<%			} %>
<%		} %>
		</table>
	</div>
</body>
</html>














