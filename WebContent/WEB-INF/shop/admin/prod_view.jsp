<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="shop.*"%>


<%
   ProductDTO dto = (ProductDTO)request.getAttribute("getProduct");
   String upPath = config.getServletContext().getRealPath("/WEB-INF/shop/image");
%>

<body>
   <div align="center">
      <link rel="stylesheet" type="text/css" href="style.css">
      <form name="f" action="prod_input_ok.jsp" method="post" enctype="multipart/form-data">
         <table width="800" class="outline">
            <caption>상품상세보기</caption>
            <tr>
               <th width="15%" class="m2">카테고리</th>
               <td width="35%" align="center"><%=dto.getPcategory_fk()%></td>
               <th width="15%" class="m2">상품번호</th>
               <td width="35%"><%=dto.getPnum()%></td>
               </tr>
               <tr>
               <th width="30%" class="m2">상품명</th>
               <td align="center"><%=dto.getPname()%></td>
               <th width="10%" class="m2">제조회사</th>
               <td align="center"><%=dto.getPcompany()%></td>
               </tr>
               <tr>
               <th width="10%" class="m2">상품 이미지</th>
               <td align="center"><img src="<%=upPath%>/<%=dto.getPimage()%>" width="150" height="150"></td>            
               </tr>
               <tr>
               <th width="10%" class="m2">상품 수량</th>
               <td align="center"><%=dto.getPqty()%></td>
               <th width="10%" class="m2">상품 가격</th>
               <td align="center"><%=dto.getPrice()%></td>
               </tr>
               <tr>
               <th width="5%" class="m2">상품 스펙</th>
               <td align="center"><%=dto.getPspec()%></td>
               <th width="10%" class="m2">상품 포인트</th>
               <td align="center"><%=dto.getPoint()%></td>
               </tr>
               <tr>
               <th  width="10%" class="m2">상품 소개</th>
               <td><textarea name="pcontents" rows="4" cols="50"><%=dto.getPcontents()%></textarea></td>   
            </tr>
               <td><input type="reset" value="돌아가기" onclick="window.location='list_prod.shop'"></td>         
               </form>
   </table>
</div>
   </body>