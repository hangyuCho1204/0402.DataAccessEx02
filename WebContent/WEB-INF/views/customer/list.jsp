

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>


<script type="text/javascript">
	function historyback(){
		history.back(-1);
	}
</script>
</head>
<body>
	
	���ȭ��<br>
	<a href="/0402.DataAccessEx02/">���� ȭ�� ����</a><br>
	<a href="/0402.DataAccessEx02/customer/insert">�����ϱ�</a><br>
	<a href="/0402.DataAccessEx02/customer/search">�˻��ϱ�</a><br>
	<table border="1">
	
<%-- 	<sf:form method="post" modelAttribute="customer">
	
		<sf:input path="name"/>
		
		<input type="submit" value="�˻�">
	
	</sf:form> --%>
	
	<tr>
		<th>
			ID
		</th>
		<th>
			NAME
		</th>
		<th>
			ADDRESS
		</th>
		<th>
			E-MAIL
		</th>
		<th>
			����
		</th>
		<th>
			����
		</th>
	</tr>
	
	<c:forEach var="bean" items="${lists}" >
	
	<tr>
		<td>
			${bean.id}
		</td>
		<td>
			${bean.name}
		</td>
		<td>
			${bean.address}
		</td>
		<td>
			${bean.email}
		</td>
		<td>
			<a href="/0402.DataAccessEx02/customer/update?id=${bean.id}">����</a>
			<%-- <a href="/0401.DataAccessEx01_mvc_jdbc/views/customer/update?id=${bean.id}&name=${bean.name}&address=${bean.address}&email=${bean.email}">����</a> --%>
		</td>
		<td>
			<a href="/0402.DataAccessEx02/customer/delete?id=${bean.id}">����</a>
		</td>
	</tr>
	</c:forEach>
	
	</table>
	<input type="button" value="�ڷΰ���" onclick="historyback()"/>
</body>
</html>