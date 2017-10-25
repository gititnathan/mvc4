<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shop.mall.*"%>

<%@ include file="mall_top.jsp" %>
<%
		String code = request.getParameter("code");
		String cname = request.getParameter("cname");
%>
<h3>Welcome to My Mall</h3>
<%	java.text.DecimalFormat df = new java.text.DecimalFormat("###,###");%>
<%
		Vector<ProductDTO> plist = ProductList.ht.get(code);
		if (plist==null || plist.size()==0){ 
		out.println("<b>"+cname+" 상품이 없습니다.</b><br>");
		}else {%>
		<hr color="green" width="300">
		<font size="3"><%=cname%></font>
		<hr color="green" width="300">		
		<table border="0" width="100%">
			<tr>
<%		int count = 0;
			String upPath = application.getRealPath("/shop/images");
			for(ProductDTO dto : plist){
				count++;%>
				<td align="center">
					<a href="prodView.mall?pnum=<%=dto.getPnum()%>&select=<%=code%>">
					<img src="<%=upPath%>/<%=dto.getPimage()%>" width="80" height="60">
					</a>
					<br><%=dto.getPname()%>
					<br><font color="red"><%=df.format(dto.getPrice())%></font>원
					<br><font color="blue">[<%=dto.getPoint()%>]</font>point
				</td>	
<%			if (count%3==0){%>
				</tr><tr>
<%			}
			}%>						
			</tr>
		</table>
<%	}%>
<%@ include file="mall_bottom.jsp" %>		