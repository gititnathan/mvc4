<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, baseball.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������</title>
</head>
<body>
<script type="text/javascript">
	function checkDel(pnum, pimage){
		var isDel = confirm("������ �����Ͻðڽ��ϱ�?")
		if (isDel){
			location.href="delete_prod.shop?pnum="+pnum+"&pimage="+pimage
		}
	}
</script>

<%
// teamNo�� ����. teamNo�� dto.getTeamNo �� ������ ���. teamNo�� teamName�� �ش�.
int teamNo = 0;
String teamName = null;
if (teamNo==1){
	teamName = "���";
	}else if(teamNo == 2){
		teamName = "�λ�";
	}else if(teamNo == 3){
		teamName = "�Ե�";
	}else if(teamNo == 4){
		teamName = "NC";
	}else if(teamNo == 5){
		teamName = "SK";
	}else if(teamNo == 6){
		teamName = "�ؼ�";
	}else if(teamNo == 7){
		teamName = "LG";
	}else if(teamNo == 8){
		teamName = "��ȭ";
	}else if(teamNo == 9){
		teamName = "�Ｚ";
	}else if(teamNo == 10){
		teamName = "KT";
	}
	
	%>
<div align="center">
	<table border = "1" class="outline" width="100%">
		<caption>�������</caption>
		<tr>
			<th class="m2" width = "8%">������ȣ</th>
			<th class="m2">�����̸�</th>
			<th class="m2">����</th>
			<th class="m2">����</th>
			<th class="m2">���</th>
			<th class="m2" width = "50%">����</th>
		</tr>
<%
		ArrayList<PlayerDTO> list = (ArrayList)request.getAttribute("playerList"); 
		if (list==null || list.size()==0){%>
		<tr>
			<td colspan="8">��ϵ� ������ �����ϴ�.</td>
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