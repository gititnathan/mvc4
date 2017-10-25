<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, baseball.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>선수목록</title>
</head>
<body>
<%
		ArrayList<TeamDTO> list = (ArrayList)request.getAttribute("teamList");
		if (list==null || list.size()==0){%>
		<script type="text/javascript">
			alert("팀을 먼저 등록해 주세요!! DB에서 하시길")
			location.href="main.base"
		</script>	
<%		return;
		}%>
<div align="center">
	<form name="f" action="list_byteam.base" method="post">
												
		<table border="1" width="600" class="outline">
			<caption>구단별 선수 목록</caption>
			<tr>
				<th width="20%" class="m2">소속팀</th>
				<td align="left">
					<select name="team_no">
<%				for(TeamDTO dto : list){ %>					
						<option value="<%=dto.getNo()%>">
						<%=dto.getName()%>[<%=dto.getNo()%>]
						</option>
<%				}%>
					</select>
				<input type="submit" value="검색">
			</tr>
		</table>
	</form>
</div>		

</body>
</html>