<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shop.*"%>

<%
		ProductDTO pdto = (ProductDTO)request.getAttribute("getProduct"); 
		String upPath = application.getRealPath("WEB-INF/shop/image");
		String pnum = request.getParameter("pnum");
		String select = request.getParameter("select");
		
%>
<%@ include file="mall_top.jsp"%>
<script type="text/javascript">
	function goCart(){
		document.f.action = "cartAdd.mall"
		document.f.submit()
	}
	function goOrder(){
		document.f.action = "order.mall"
		document.f.submit()
	}
</script>
<table class="outline" width="100%">
	<tr>
		<td colspan="2" align="center" class="m1">
			<b>[<%=pdto.getPname()%>] ��ǰ����</b>
		</td>
	</tr>
	<tr>
		<td align="center" class="m3">
			<img src="<%=upPath%>/<%=pdto.getPimage()%>"
															width="200" height="200">
		</td>
		<td class="m3">
		<form name="f" method="post">
			��ǰ��ȣ : <%=pdto.getPnum()%><br>
			��ǰ�̸� : <%=pdto.getPname()%><br>
			��ǰ���� : <font color="red"><%=pdto.getPrice()%></font>��<br>
			��ǰ����Ʈ :<font color="red">[<%=pdto.getPoint()%>]</font>point<br>
			��ǰ���� : <input type="text" name="qty" size="3" value="1">��<br>
			<input type="hidden" name="pnum" value="<%=pnum%>">
			<input type="hidden" name="select" value="<%=select%>">
			<a href="javascript:goCart()">��ٱ���</a> | 
			<a href="javascript:goOrder()">��ñ���</a>			
		</form>	
		</td>
	</tr>
	<tr>
		<td colspan="2" align="left">
			<b>��ǰ �� ����</b><br>
			<%=pdto.getPcontents()%>
		</td>
	</tr>
</table>
<%@ include file="mall_bottom.jsp"%>














