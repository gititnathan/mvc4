<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.text.*, shop.mall.*"%>
<%@ include file="mall_top.jsp"%>

<div align="center">
	<table border="1" width="100%">
		<tr height="40">
			<td colspan="6" align="center" class="m2">
				<b>��ٱ��� ����</b>
			</td>
		</tr>
		<tr>
			<th class="m1">��ȣ</th>
			<th class="m1">��ǰ��</th>
			<th class="m1">����</th>
			<th class="m1">�ܰ�</th>
			<th class="m1">�ݾ�</th>
			<th class="m1">����</th>
		</tr> 
<% 		CartBean cart = (CartBean)session.getAttribute("cart");
		Hashtable<Integer, ProductDTO> ht = cart.listCart();
		if (ht==null || ht.size()==0){%>
		<tr>
			<td colspan="6">��ٱ��ϰ� ������ϴ�.</td>
		</tr>
<%	}else {
			Enumeration<Integer> enu = ht.keys();
			String upPath = application.getRealPath("WEB-INF/shop/image");
			DecimalFormat df = new DecimalFormat("###,###");
			int allPrice = 0, allPoint = 0;
			while(enu.hasMoreElements()){
				ProductDTO dto = ht.get(enu.nextElement());
				allPrice += (dto.getPrice() * dto.getPqty());
				allPoint += (dto.getPoint() * dto.getPqty());
			%>
			<tr>
				<td align="center"><%=dto.getPnum()%></td>
				<td align="center" width="30%">
					<img src="<%=upPath%>/<%=dto.getPimage()%>" width="40" height="40">
					<br><b><%=dto.getPname()%></b>
				</td>
				<td align="center">
					<form name="f" action="cartEdit.mall" method="post">
						<input type="text" name="qty" value="<%=dto.getPqty()%>" size="2">��
						<input type="hidden" name="pnum" value="<%=dto.getPnum()%>">
						<br><input type="submit" value="����">
					</form>		
				</td>
				<td align="right">
					<b>
						<%=df.format(dto.getPrice())%>��<br>
						[<%=dto.getPoint()%>] point
					</b>	
				</td>
				<td align="right">
					<font color="red">
						<%=df.format(dto.getPrice()*dto.getPqty())%>��<br>
						[<%=dto.getPoint()*dto.getPqty()%>]point
					</font>
				</td>
				<td align="center">
					<a href="cartDel.mall?pnum=<%=dto.getPnum()%>">����</a>
				</td>
			</tr>
<%		}%>
			<tr>
				<td colspan="4" class="m1">
					<b>��ٱ��� �Ѿ� : </b><font color="red"><%=df.format(allPrice)%>��</font><br>
					<font color="green">�� ���� ����Ʈ : [<%=allPoint%>]point</font>
				</td>
				<td colspan="2" class="m1">
					[�ֹ��ϱ�][��Ӽ���]
				</td>
			</tr>
<%	}%>
	</table>
</div>
<%@ include file="mall_bottom.jsp"%>