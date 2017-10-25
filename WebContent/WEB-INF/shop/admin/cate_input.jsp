<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>카테고리 등록</title>
</head>
<body onload="f.name.focus()">
		<form name="f" method="POST" action="inputOk.shop" align = "center">
			<table border = "1" width="550" align="center" class="outline">
  				<tr>
					<td colspan="2" align=center class="m2">카테고리 등록</td>
 				</tr>
				<tr>
				<th>카테고리 코드</th>
				<td><input type="text" name="code" class="box"></td>
			</tr>
			<tr>
				<th>카테고리 이름</th>
				<td><input type="text" name="cname" class="box" >  
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">
					<input type="reset" value="취소">
				</td>
			</tr>
  			</table>
		</form>
	</body>
</html>