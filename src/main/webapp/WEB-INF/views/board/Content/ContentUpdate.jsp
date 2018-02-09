<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="my.remind.board4.vo.ContentVO" %>
<%
	ContentVO content = (ContentVO) request.getAttribute("content");
%>

<!DOCTYPE html>
<html>
<head>
	<title>게시판 > <%= content.getBoardTitle() %></title>
</head>
<body>
	<%= content %>
</body>
</html>