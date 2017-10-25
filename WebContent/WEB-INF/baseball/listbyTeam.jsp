<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, baseball.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<table border = "1" class="outline" width="100%">
		<caption>선수목록</caption>
		<tr>
			<th class="m2" width = "8%">선수번호</th>
			<th class="m2">선수이름</th>
			<th class="m2">구단</th>
			<th class="m2">연봉</th>
			<th class="m2">등급</th>
			<th class="m2" width = "50%">설명</th>
		</tr>
<%
		ArrayList<PlayerDTO> list = (ArrayList)request.getAttribute("playerList"); 
		if (list==null || list.size()==0){%>
		<tr>
			<td colspan="8">등록된 선수가 없습니다.</td>
		</tr>
<%	}else { 
			String upPath = config.getServletContext().getRealPath("/WEB-INF/shop/image");
			for(PlayerDTO dto : list){%>
		<tr>
			<td align="right"><%=dto.getNo()%></td>
			<td align="center"><%=dto.getName()%></td>
			<td align="center"><%=dto.getTeam_no()%></td>
			<td align="right"><%=dto.getSalary()%></td>
			<td align="center"><%=dto.getGrand()%></td>
			<td align="left"><%=dto.getContent()%></td>
			
		</tr>	
<%		}
		}	%>		
		
	</table>
</div>
		<form>
		<input type="button" value="돌아가기" onclick="window.location='searchTeam.base'">		
		</form>
</body>
</html>