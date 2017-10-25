<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import = "member.*"%>
    
<%
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		
		String no = request.getParameter("no");
		if (no==null || no.trim().equals("")){
			response.sendRedirect("memberAll.jsp");
			return;
		}
		
		dto = dao.getMember(Integer.parseInt(no)); 
%>

<script type="text/javascript">
	function check(){
		if (f.passwd.value==""){
			alert("비밀번호를 입력하세요")
			f.passwd.focus()
			return
		}
		document.f.submit()
	}
</script>


<html>
<head>
	<title>회원수정 </title>
	<link rel="stylesheet" type="text/css" href="style.css">	
</head>
	<body onload="f.name.focus()">
		<form name="f" method="POST" action="editOk.member">
			<input type="hidden" name="no" value="<%=dto.getNo()%>">
			<table width="550" align="center" class="outline">
  				<tr>
					<td colspan="2" align=center class="m2">회원수정</td>
 				</tr>
				<tr>
					<td width="150" class="m3">이름</td>
					<td class="m3">
						<input type="text" name="name" class="box"
							value="<%=dto.getName()%>" disabled>
						<input type="hidden" name="name" value="<%=dto.getName()%>"/>	
					</td>
				</tr>
				<tr>
					<td width="150" class="m3">아이디</td>
					<td class="m3">
						<input type="text" name="id" class="box"
							value="<%=dto.getId()%>" readOnly>
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">비밀번호</td>
					<td class="m3">
						<input type="password" name="passwd" 
							value="<%=dto.getPasswd()%>" class="box">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">주민번호</td>
					<td class="m3">
						<input type="text" name="ssn1" class="box"
							value="<%=dto.getSsn1()%>" readOnly> -
						<input type="password" name="ssn2" class="box"
							value="<%=dto.getSsn2()%>" readOnly>
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">이메일</td>
					<td class="m3">
						<input type="text" name="email" class="box"
							value="<%=dto.getEmail()%>">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">연락처</td>
					<td class="m3">
						<input type="text" name="hp1" class="box" 
							size="3" maxlength="3" value="<%=dto.getHp1()%>"> -
						<input type="text" name="hp2" class="box" 
							size="4" maxlength="4" value="<%=dto.getHp2()%>"> -
						<input type="text" name="hp3" class="box" 
							size="4" maxlength="4" value="<%=dto.getHp3()%>">
					</td>
  				</tr>
  				<tr>
					<td colspan="2" align="center">
						<a href="javascript:check()">[수정]</a>
						<a href="#">[취소]</a>
					</td>
  				</tr>
  			</table>
		</form>
	</body>
</html>
