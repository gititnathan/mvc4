<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, baseball.*"%>
<html>
<head>
<title>���� �Է�</title>
</head>
<body>
<%
		ArrayList<TeamDTO> list = (ArrayList)request.getAttribute("teamList");
		if (list==null || list.size()==0){%>
		<script type="text/javascript">
			alert("���� ���� ����� �ּ���!! DB���� �Ͻñ�")
			location.href="main.base"
		</script>	
<%		return;
		}%>
		
<div align="center">
	<form name="f" action="input_ok_player.base" method="post">
												
		<table border="1" width="600" class="outline">
			<caption>���� ���</caption>
			<tr>
				<th width="20%" class="m2">�Ҽ���</th>
				<td align="left">
					<select name="team_no">
<%				for(TeamDTO dto : list){ %>					
						<option value="<%=dto.getNo()%>">
						<%=dto.getName()%>[<%=dto.getNo()%>]
						</option>
<%				}%>
					</select>
					
			</tr>
			<tr>
				<th class="m2">������</th>
				<td><input type="text" name="name" class="box"></td>
			</tr>
			<tr>
				<th class="m2">����</th>
				<td><input type="text" name="salary" class="box">����</td>
			</tr>
			<tr>
				<th class="m2">���</th>
				<td>
					<select name="grand">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
						<option value="F">F</option>
					</select>
				</td>
			</tr>
			<tr>
				<th class="m2">����</th>
				<td>
					<textarea name="content" rows="3" cols="50"></textarea>
				</td>
			</tr>
			<tr align = "center">
				<td class="m1" colspan="2">
					<input type="submit" value="���">
					<input type="reset" value="���">			
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>