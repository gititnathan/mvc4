<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, baseball.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>선수목록</title>
</head>
<body>
<script type="text/javascript">
	function checkDel(pnum, pimage){
		var isDel = confirm("정말로 삭제하시겠습니까?")
		if (isDel){
			location.href="delete_prod.shop?pnum="+pnum+"&pimage="+pimage
		}
	}
</script>

<%
// teamNo를 선언. teamNo와 dto.getTeamNo 가 동일할 경우. teamNo의 teamName을 준다.
int teamNo = 0;
String teamName = null;
if (teamNo==1){
	teamName = "기아";
	}else if(teamNo == 2){
		teamName = "두산";
	}else if(teamNo == 3){
		teamName = "롯데";
	}else if(teamNo == 4){
		teamName = "NC";
	}else if(teamNo == 5){
		teamName = "SK";
	}else if(teamNo == 6){
		teamName = "넥센";
	}else if(teamNo == 7){
		teamName = "LG";
	}else if(teamNo == 8){
		teamName = "한화";
	}else if(teamNo == 9){
		teamName = "삼성";
	}else if(teamNo == 10){
		teamName = "KT";
	}
	
	%>
<div align="center">
	<table border = "1" class="outline" width="100%">
		<caption>선수목록</caption>
		<tr>
			<th class="m2" width = "8%">선수번호</th>
			<th class="m2">선수이름</th>
			<th class="m2">구단</th>
			<th class="m2">연봉</th>
			<th class="m2">등급</th>
			<th class="m2" width = "50%">설명</th>
		</tr>
<%
		ArrayList<PlayerDTO> list = (ArrayList)request.getAttribute("playerList"); 
		if (list==null || list.size()==0){%>
		<tr>
			<td colspan="8">등록된 선수가 없습니다.</td>
		</tr>
<%	}else { 
			String upPath = config.getServletContext().getRealPath("/WEB-INF/shop/image");
			for(PlayerDTO dto : list){%>
		<tr>
			<td align="right"><%=dto.getNo()%></td>
			<td align="center"><%=dto.getName()%></td>
			<td align="center"><%=dto.getTeam_no()%></td>
			<td align="right"><%=dto.getSalary()%></td>
			<td align="center"><%=dto.getGrand()%></td>
			<td align="left"><%=dto.getContent()%></td>
			
		</tr>	
<%		}
		}	%>				
	</table>
</div>
</body>
</html>