<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
	<title>mvc게시판</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%	String num = request.getParameter("num"); %>
<div align="center">
	<h3>글삭제</h3>
	<form name="f" action="deletePro.board" method="post">
		<input type="hidden" name="num" value="<%=num%>"/>
		<table border="1" width="300">
			<tr bgcolor="yellow">
				<th>비밀번호를 입력해 주세요</th>
			</tr>
			<tr>
				<td align="center">
					비밀번호 : <input type="password" name="passwd" class="box">
				</td>
			</tr>
			<tr bgcolor="yellow">
				<td align="center">
					<input type="submit" value="글삭제">
					<input type="button" value="글목록" onclick="window.location='list.board'">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>











