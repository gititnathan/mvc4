<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
		String msg = (String)request.getAttribute("msg");
		String url = (String)request.getAttribute("url");
		String name = request.getParameter("name");
		String ssn1 = request.getParameter("ssn1");
		String ssn2 = request.getParameter("ssn2");
%>
	<form name="f" action="<%=url%>" method="post">
			<input type="hidden" name="name" value="<%=name%>"/>
			<input type="hidden" name="ssn1" value="<%=ssn1%>"/>
			<input type="hidden" name="ssn2" value="<%=ssn2%>"/>
		</form>
<script type="text/javascript">
	alert("<%=msg%>")
	document.f.submit()
</script>