<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
	<title>mvc�Խ���</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript">
		function check(){
			if (f.writer.value==""){
				alert("�̸��� �Է��� �ּ���!!")
				f.writer.focus()
				return false
			}
			if (f.subject.value==""){
				alert("������ �Է��� �ּ���!!")
				f.subject.focus()
				return false
			}
			if (f.content.value==""){
				alert("������ �Է��� �ּ���!!")
				f.content.focus()
				return false
			}
			if (f.passwd.value==""){
				alert("��й�ȣ�� �Է��� �ּ���!!")
				f.passwd.focus()
				return false
			}
			return true
		}
	</script>
</head>	
<body>
<%
 //		int num=0, re_group=0, re_step=0, re_level=0;
 //		if (request.getParameter("num") != null){
 //			num = Integer.parseInt(request.getParameter("num"));
 //			re_group = Integer.parseInt(request.getParameter("re_group"));
 //		re_step = Integer.parseInt(request.getParameter("re_step"));
 //	re_level = Integer.parseInt(request.getParameter("re_level"));
	//	}
%>
<div align="center">
	<form name="f" action="writePro.board" method="post" onsubmit="return check()">
	<input type="hidden" name="num" value="${param.num}"/>
	<input type="hidden" name="re_group" value="${param.re_group}"/>
	<input type="hidden" name="re_step" value="${param.re_step}"/>
	<input type="hidden" name="re_level" value="${param.re_level}"/>
	<table border="1" width="500">
		<tr bgcolor="yellow">
			<th colspan="2">�� �� ��</th>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">�� ��</th>
			<td><input type="text" name="writer" class="box"></td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">�� ��</th>
			<td><input type="text" name="subject" class="box" size="50"></td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">Email</th>
			<td><input type="text" name="email" class="box" size="50"></td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">�� ��</th>
			<td><textarea name="content" rows="13" cols="50" class="box"></textarea></td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">��й�ȣ</th>
			<td><input type="password" name="passwd" class="box"></td>
		</tr>
		<tr bgcolor="yellow">
			<td colspan="2" align="center">
				<input type="submit" value="�۾���">
				<input type="reset" value="�ٽ��ۼ�">
				<input type="button" value="��Ϻ���" 	onclick="window.location='list.board'">
			</td>	
		</tr>
	</table>
	</form>
</div>
</body>
</html>











