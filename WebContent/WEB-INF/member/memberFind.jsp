<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, member.*"%>
<!-- member_find.jsp -->
<html>
<head>
	<title>mvc���</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>	
	<div align="center">
		<hr color="green" width="300">
		<h2>ȸ �� ã ��</h2>
		<form name="f" method="post" action="find.member">
			<select name="search">
				<option value="id">���̵�</option>
				<option value="name">�̸�</option>
			</select>
			<input type="text" name="searchString" class="box">
			<input type="submit" value="�˻�">
		</form>
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
<%		ArrayList<MemberDTO> list = (ArrayList)request.getAttribute("memberFind");
			if (list==null || list.size()==0){%>
			<tr>
				<td colspan="7">ã���ô� ȸ���� �����ϴ�.</td>
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
		<br>
		<a href="index.member">ȸ�������������� �̵�</a>
	</div>
</body>
</html>