<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, board.*"%>
<html>
<head>
	<title>mvc게시판</title>
</head>
<body>
<div align="center">
	<b>글 목 록</b>
	<table border="0" width="600">
		<tr bgcolor="yellow">
			<td align="right"><a href="writeForm.board">글쓰기</a></td>
		</tr>
	</table>
	<table border="1" width="600">
		<tr bgcolor="green">
			<th>번호</th>
			<th width="30%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회</th>
			<th>IP</th>
		</tr>
<% 	ArrayList<BoardDBBean> list = (ArrayList)request.getAttribute("boardList");
		if (list==null || list.size()==0){%>
		<tr>
			<td colspan="6">등록된 게시글이 없습니다.</td>
		</tr>
<%	}else { 
			for(BoardDBBean dto : list){%>
		<tr>
			<td><%=dto.getNum()%></td>
			<td>
<%		if (dto.getRe_level()>0){ %>
				<img src="img/level.gif" width="<%=dto.getRe_level()*10%>">
				<img src="img/re.gif">			
<%		} %>
				<a href="content.board?num=<%=dto.getNum()%>">
					<%=dto.getSubject()%>
				</a>
<%		if (dto.getReadcount()>10){ %>
				<img src="img/hot.gif">
<%		} %>				
			</td>
			<td><%=dto.getWriter()%></td>
			<td><%=dto.getReg_date()%></td>
			<td><%=dto.getReadcount()%></td>
			<td><%=dto.getIp()%></td>
		</tr>
<%		}
		}%>		
	</table>
</div>
</body>
</html>




