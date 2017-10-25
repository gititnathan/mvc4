<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.*"%>
<html>
<head>
	<title>mvc게시판</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
		BoardDBBean dto = (BoardDBBean)request.getAttribute("getBoard");
%>
<div align="center">
	<b>글내용 보기</b>
	<table border="1" width="500">
		<tr>
			<th bgcolor="yellow" width="15%">글번호</th>
			<td align="center" width="35%"><%=dto.getNum()%></td>
			<th bgcolor="yellow" width="15%">조회수</th>
			<td align="center" width="35%"><%=dto.getReadcount()%></td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="15%">작성자</th>
			<td align="center" width="35%"><%=dto.getWriter()%></td>
			<th bgcolor="yellow" width="15%">작성일</th>
			<td align="center" width="35%"><%=dto.getReg_date()%></td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="15%">글제목</th>
			<td align="center" colspan="3"><%=dto.getSubject()%></td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="15%">글내용</th>
			<td colspan="3"><%=dto.getContent()%></td>
		</tr>
		<tr bgcolor="yellow">
			<td colspan="4" align="right">
				<input type="button" value="답글쓰기"
					onclick="window.location='writeForm.board?num=<%=dto.getNum()%>&re_group=<%=dto.getRe_group()%>&re_step=<%=dto.getRe_step()%>&re_level=<%=dto.getRe_level()%>'">
				<input type="button" value="글수정"
					onclick="window.location='updateForm.board?num=<%=dto.getNum()%>'">
				<input type="button" value="글삭제"
					onclick="window.location='deleteForm.board?num=<%=dto.getNum()%>'">
				<input type="button" value="글목록" 
					onclick="window.location='list.board'">
			</td>
		</tr>
	</table>
</div>
</body>
</html>



















