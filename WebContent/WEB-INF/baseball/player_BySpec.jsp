<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, baseball.*"%>
<!-- member_find.jsp -->
<html>
<head>
	<title>mvc���</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>	
	<div align="center">
		<hr color="green" width="300">
		<h2>�� �� ���Ǻ� �� ��</h2>
		<form name="f" method="post" action="find.baseball">
			<input type="radio" name="search" value="team_no">���ܹ�ȣ
    		<input type="radio" name="search" value="salary">�۾���
			<input type="radio" name="search" value="grand">������
			<select name="searchString">
				<option value="team_no">���� ��ȣ</option>
				<option value="salary">����</option>
				<option value="grand">���</option>
			</select>
			<input type="submit" value="�˻�">
		</form>
		<hr color="green" width="300">
		<table width="100%" class="outline">
			<tr>
				<th class="m3">��ȣ</th>
				<th class="m3">�̸�</th>
				<th class="m3">����</th>
				<th class="m3">����</th>
				<th class="m3">���</th>
				<th class="m3">����</th>
			</tr>
<%		ArrayList<PlayerDTO> list = (ArrayList)request.getAttribute("playerFind");
			if (list==null || list.size()==0){%>
			<tr>
				<td colspan="7">ã���ô� ȸ���� �����ϴ�.</td>
			</tr>
<%		}else {
				for(PlayerDTO dto : list){%>						
			<tr>
				<td><%=dto.getNo()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getTeam_no()%></td>
				<td><%=dto.getSalary()%></td>
				<td><%=dto.getGrand()%></td>
				<td><%=dto.getContent()%></td>
				<td>
				<a href="edit.member?no=<%=dto.getNo()%>">����</a> | 
				<a href="delete.member?no=<%=dto.getNo()%>">����</a></td>
			</tr>	
<%			} %>
<%		} %>
		</table>
		<br>
		<a href="index.member">ȸ�������������� �̵�</a>
	</div>
</body>
</html>