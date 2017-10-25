<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, baseball.*"%>
<!-- member_find.jsp -->
<html>
<head>
	<title>mvc멤버</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>	
	<div align="center">
		<hr color="green" width="300">
		<h2>선 수 조건별 보 기</h2>
		<form name="f" method="post" action="find.baseball">
			<input type="radio" name="search" value="team_no">구단번호
    		<input type="radio" name="search" value="salary">송아지
			<input type="radio" name="search" value="grand">망아지
			<select name="searchString">
				<option value="team_no">구단 번호</option>
				<option value="salary">연봉</option>
				<option value="grand">등급</option>
			</select>
			<input type="submit" value="검색">
		</form>
		<hr color="green" width="300">
		<table width="100%" class="outline">
			<tr>
				<th class="m3">번호</th>
				<th class="m3">이름</th>
				<th class="m3">구단</th>
				<th class="m3">연봉</th>
				<th class="m3">등급</th>
				<th class="m3">설명</th>
			</tr>
<%		ArrayList<PlayerDTO> list = (ArrayList)request.getAttribute("playerFind");
			if (list==null || list.size()==0){%>
			<tr>
				<td colspan="7">찾으시는 회원이 없습니다.</td>
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
				<a href="edit.member?no=<%=dto.getNo()%>">수정</a> | 
				<a href="delete.member?no=<%=dto.getNo()%>">삭제</a></td>
			</tr>	
<%			} %>
<%		} %>
		</table>
		<br>
		<a href="index.member">회원관리페이지로 이동</a>
	</div>
</body>
</html>