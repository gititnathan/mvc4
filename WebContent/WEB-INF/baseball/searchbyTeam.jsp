<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, baseball.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������</title>
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
	<form name="f" action="list_byteam.base" method="post">
												
		<table border="1" width="600" class="outline">
			<caption>���ܺ� ���� ���</caption>
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
				<input type="submit" value="�˻�">
			</tr>
		</table>
	</form>
</div>		

</body>
</html>