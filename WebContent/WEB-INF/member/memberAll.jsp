<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, member.*"%>
<!-- memberAll.jsp -->
<html>
<head>
	<title>mvc멤버</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>	
	<div align="center">
		<hr color="green" width="300">
		<h2>회 원 목 록 보 기</h2>
		<hr color="green" width="300">
		<table width="100%" class="outline">
			<tr>
				<th class="m3">번호</th>
				<th class="m3">이름</th>
				<th class="m3">아이디</th>
				<th class="m3">이메일</th>
				<th class="m3">전화번호</th>
				<th class="m3">가입일</th>
				<th class="m3">수정 | 삭제</th>
			</tr>
<%		ArrayList<MemberDTO> list = (ArrayList)request.getAttribute("memberList");
			if (list==null || list.size()==0){%>
			<tr>
				<td colspan="7">등록된 회원이 없습니다.</td>
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
				<a href="edit.member?no=<%=dto.getNo()%>">수정</a> | 
				<a href="delete.member?no=<%=dto.getNo()%>">삭제</a></td>
			</tr>	
<%			} %>
<%		} %>
		</table>
	</div>
</body>
</html>














