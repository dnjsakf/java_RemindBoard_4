<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String mode = (String) request.getAttribute("mode");
	System.out.println("[mode]" + mode);
%>
<!DOCTYPE html>
<html>
<head>
	<%-- TODO: Import any stylesheet --%>
	<%-- TODO: Import any javascript --%>
</head>
<body>
	<header>
		<jsp:include page="BoardHeader.jsp"/>
	</header>
	<section>
	<c:choose>
		<c:when test="${mode eq 'view'}">
			<jsp:include page="./Content/ContentView.jsp"/>
		</c:when>
		<c:when test="${mode eq 'insert'}">
			<jsp:include page="./Content/ContentInsert.jsp"/>
		</c:when>
		<c:when test="${mode eq 'update'}">
			<jsp:include page="./Content/ContentUpdate.jsp"/>
		</c:when>
	</c:choose>
	</section>
</body>
</html>