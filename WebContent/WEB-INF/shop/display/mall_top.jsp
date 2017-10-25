<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, shop.*"%>

<%
		ArrayList<CategoryDTO> list = (ArrayList)session.getAttribute("listCate");
%>
<html>
<head>
	<title>쇼핑몰</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript">
		function cgProList(cname, code){
			document.pList.code.value = code
			document.pList.cname.value = cname
			document.pList.submit()
		}
	</script>
</head>
<body>
	<div align="center">
	<table border="1" width="800" height="600">
		<tr height="50">
			<td colspan="2" align="center">
				HOME | 관리자홈 | 쇼핑몰홈 | 장바구니 | 회사소개
			</td>
		</tr>
		<tr>
			<td valign="top" align="center" width="20%">
				tree/view
				<table border="1" width="100%">
<%			for(CategoryDTO dto : list){ %>
				<tr>
					<td>
						<a href="javascript:cgProList('<%=dto.getCname()%>','<%=dto.getCode()%>')">
						<%=dto.getCname()%>[<%=dto.getCode()%>]
						</a>
					</td>
				</tr>	
<%			} %>				
				</table>
				<form name="pList" action="cgProdList.mall" method="post">
					<input type="hidden" name="code">
					<input type="hidden" name="cname">
				</form>
			</td>
			<td align="center">
			
			
			
			
			
			
			
			
			
			
			