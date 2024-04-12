<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>scott 계정이 가지고 있는 테이블 또는 뷰</h1>
<%-- ${tabList} --%>
<ul>
	<c:forEach var="tab" items="${tabList}">
<li>${tab.tname} : ${tab.tabType}</li>
	</c:forEach>
</ul>
</body>
</html>