<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, shop.*"%>
<html>
<head>
<title>상품 입력</title>
</head>
<body>
<%
		ArrayList<CategoryDTO> list = (ArrayList)request.getAttribute("categoryList");
		if (list==null || list.size()==0){%>
		<script type="text/javascript">
			alert("카테고리를 먼저 등록해 주세요!!")
			location.href="admin.shop"
		</script>	
<%		return;
		}%>
<div align="center">
	<form name="f" action="input_ok_prod.shop" method="post" enctype="multipart/form-data">
												
		<table width="600" class="outline">
			<caption>상품등록카테고리</caption>
			<tr>
				<th width="20%" class="m2">카테고리</th>
				<td align="left">
					<select name="pcategory_fk">
<%				for(CategoryDTO dto : list){ %>					
						<option value="<%=dto.getCode()%>">
						<%=dto.getCname()%>[<%=dto.getCode()%>]
						</option>
<%				}%>
					</select>
			</tr>
			<tr>
				<th class="m2">상품명</th>
				<td><input type="text" name="pname" class="box"></td>
			</tr>
			<tr>
				<th class="m2">상품코드</th>
				<td><input type="text" name="pcode" class="box"></td>
			</tr>
			<tr>
				<th class="m2">제조사</th>
				<td><input type="text" name="pcompany" class="box"></td>
			</tr>
			<tr>
				<th class="m2">상품이미지</th>
				<td><input type="file" name="pimage"></td>
			</tr>
			<tr>
				<th class="m2">상품수량</th>
				<td><input type="text" name="pqty" class="box"></td>
			</tr>
			<tr>
				<th class="m2">상품가격</th>
				<td><input type="text" name="price" class="box"></td>
			</tr>
			<tr>
				<th class="m2">상품스펙</th>
				<td>
					<select name="pspec">
						<option value="normal">::NORMAL::</option>
						<option value="hit">HIT</option>
						<option value="new">NEW</option>
						<option value="best">BEST</option>
					</select>
				</td>
			</tr>
			<tr>
				<th class="m2">상품소개</th>
				<td>
					<textarea name="pcontents" rows="3" cols="50"></textarea>
				</td>
			</tr>
			<tr>
				<th class="m2">상품포인트</th>
				<td><input type="text" name="point" class="box"></td>
			</tr>
			<tr>
				<td class="m1" colspan="2">
					<input type="submit" value="등록">
					<input type="reset" value="취소">			
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>