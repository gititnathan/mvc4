<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shop.mall.*"%>
<%@ include file="mall_top.jsp" %> 
<h3>Welcome to My Mall</h3>
<%	java.text.DecimalFormat df = new java.text.DecimalFormat("###,###");%>
<%
		Vector<ProductDTO> plist = ProductList.ht.get("hit");
		if (plist==null || plist.size()==0){  
		out.println("<b>HIT 상품이 없습니다.</b><br>"); 
		}else {%>
		<hr color="green" width="300">
		<font size="3">HIT</font>
		<hr color="green" width="300">		
		<table border="0" width="100%">
			<tr>
<%		int count = 0;
			String upPath = application.getRealPath("/shop/images");
			for(ProductDTO dto : plist){
				count++;%>
				<td align="center">
					<a href="prodView.mall?pnum=<%=dto.getPnum()%>&select=hit">
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
<%
		Vector<ProductDTO> plist2 = ProductList.ht.get("new");
		if (plist2==null || plist2.size()==0){
		out.println("<b>NEW 상품이 없습니다.</b><br>");
		}else {%>
		<hr color="green" width="300">
		<font size="3">NEW</font>
		<hr color="green" width="300">		
		<table border="0" width="100%">
			<tr>
<%		int count = 0;
			String upPath = application.getRealPath("/shop/images");
			for(ProductDTO dto : plist2){
				count++;%>
				<td align="center">
					<a href="prodView.mall?pnum=<%=dto.getPnum()%>&select=new">
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
<%
		Vector<ProductDTO> plist3 = ProductList.ht.get("best");
		if (plist3==null || plist3.size()==0){
		out.println("<b>BEST 상품이 없습니다.</b><br>");
		}else {%>
		<hr color="green" width="300">
		<font size="3">BEST</font>
		<hr color="green" width="300">		
		<table border="0" width="100%">
			<tr>
<%		int count = 0;
			String upPath = application.getRealPath("WEB-INF/shop/image");
			for(ProductDTO dto : plist3){
				count++;%>
				<td align="center">
					<a href="prodView.mall?pnum=<%=dto.getPnum()%>&select=best">
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
			
			
			
			
			
			
			
			
			
			
			
			
			
			