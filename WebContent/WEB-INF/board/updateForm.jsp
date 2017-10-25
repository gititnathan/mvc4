<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.*"%>
<html>
<head>
	<title>mvc게시판</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript">
		function check(){
			if (f.writer.value==""){
				alert("이름을 입력해 주세요!!")
				f.writer.focus()
				return false
			}
			if (f.subject.value==""){
				alert("제목을 입력해 주세요!!")
				f.subject.focus()
				return false
			}
			if (f.content.value==""){
				alert("내용을 입력해 주세요!!")
				f.content.focus()
				return false
			}
			if (f.passwd.value==""){
				alert("비밀번호를 입력해 주세요!!")
				f.passwd.focus()
				return false
			}
			return true
		}
	</script>
</head>
<body>
<%-- <% --%>
// 		BoardDBBean dto = (BoardDBBean)request.getAttribute("getBoard"); 
<%-- %> --%>
<div align="center">
	<form name="f" action="updatePro.board" method="post" onsubmit="return check()">
	<h3>글수정</h3>
	<input type="hidden" name="num" value="${getBoard.num}"/>
	<table border="1" width="500">
		<tr>
			<th bgcolor="yellow" width="20%">이 름</th>
			<td><input type="text" name="writer" class="box" value="${getBoard.writer}"></td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">제 목</th>
			<td><input type="text" name="subject" class="box" size="50" value="${getBoard.subject}"></td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">Email</th>
			<td><input type="text" name="email" class="box" size="50" value="${getBoard.email}"></td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">내 용</th>
			<td><textarea name="content" rows="13" cols="50" class="box">${getBoard.content}%></textarea></td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">비밀번호</th>
			<td><input type="password" name="passwd" class="box"></td>
		</tr>
		<tr bgcolor="yellow">
			<td colspan="2" align="center">
				<input type="submit" value="글수정">
				<input type="reset" value="다시작성">
				<input type="button" value="목록보기" onclick="window.location='list.board'">
			</td>	
		</tr>
	</table>
	</form>
</div>
</body>
</html>












