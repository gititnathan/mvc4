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
            <caption>��ǰ�󼼺���</caption>
            <tr>
               <th width="15%" class="m2">ī�װ�</th>
               <td width="35%" align="center"><%=dto.getPcategory_fk()%></td>
               <th width="15%" class="m2">��ǰ��ȣ</th>
               <td width="35%"><%=dto.getPnum()%></td>
               </tr>
               <tr>
               <th width="30%" class="m2">��ǰ��</th>
               <td align="center"><%=dto.getPname()%></td>
               <th width="10%" class="m2">����ȸ��</th>
               <td align="center"><%=dto.getPcompany()%></td>
               </tr>
               <tr>
               <th width="10%" class="m2">��ǰ �̹���</th>
               <td align="center"><img src="<%=upPath%>/<%=dto.getPimage()%>" width="150" height="150"></td>            
               </tr>
               <tr>
               <th width="10%" class="m2">��ǰ ����</th>
               <td align="center"><%=dto.getPqty()%></td>
               <th width="10%" class="m2">��ǰ ����</th>
               <td align="center"><%=dto.getPrice()%></td>
               </tr>
               <tr>
               <th width="5%" class="m2">��ǰ ����</th>
               <td align="center"><%=dto.getPspec()%></td>
               <th width="10%" class="m2">��ǰ ����Ʈ</th>
               <td align="center"><%=dto.getPoint()%></td>
               </tr>
               <tr>
               <th  width="10%" class="m2">��ǰ �Ұ�</th>
               <td><textarea name="pcontents" rows="4" cols="50"><%=dto.getPcontents()%></textarea></td>   
            </tr>
               <td><input type="reset" value="���ư���" onclick="window.location='list_prod.shop'"></td>         
               </form>
   </table>
</div>
   </body>