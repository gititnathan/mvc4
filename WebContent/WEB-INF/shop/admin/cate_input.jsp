<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>ī�װ� ���</title>
</head>
<body onload="f.name.focus()">
		<form name="f" method="POST" action="inputOk.shop" align = "center">
			<table border = "1" width="550" align="center" class="outline">
  				<tr>
					<td colspan="2" align=center class="m2">ī�װ� ���</td>
 				</tr>
				<tr>
				<th>ī�װ� �ڵ�</th>
				<td><input type="text" name="code" class="box"></td>
			</tr>
			<tr>
				<th>ī�װ� �̸�</th>
				<td><input type="text" name="cname" class="box" >  
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="���">
					<input type="reset" value="���">
				</td>
			</tr>
  			</table>
		</form>
	</body>
</html>