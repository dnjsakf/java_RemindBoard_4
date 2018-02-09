<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="my.remind.board4.vo.ContentVO" %>
<%!
	ArrayList<ContentVO> contents;
	
	int thisPage = 1;
	int existNextPage = 0;
	int existPrevPage = 0;
%>
<%
	if( request.getParameter("page") != null){
		thisPage = Integer.valueOf(request.getParameter("page"));
	}

	if( request.getAttribute("contents") != null ){
		contents = (ArrayList<ContentVO>) request.getAttribute("contents");
	}
	if( request.getAttribute("existNextPage") != null){
		existNextPage = (Integer) request.getAttribute("existNextPage");
	}
	if( request.getAttribute("existPrevPage") != null){
		existPrevPage = (Integer) request.getAttribute("existPrevPage");
	}
%>

<!DOCTYPE html>
<html>
<head>
	<title>게시판</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td class="content-no">no</td>
				<td class="content-title">title</td>
				<td class="content-writer">writer</td>
				<td class="content-date">date</td>
			</tr>
		</thead>
		<tbody>
			<% System.out.println("[contents]" + contents.size() ); %>
			<c:forEach items="${contents}" var="content">
			<tr onClick="javascript:location.href='view?no=${content.getBoardNo()}'">
				<td class="content-no">${content.getBoardNo()}</td>
				<td class="content-title">${content.getBoardTitle()}</td>
				<td class="content-writer">${content.getBoardWriter()}</td>
				<td class="content-date">${content.getBoardDate()}</td>
			</tr>
			</c:forEach>
		</tbody>
		<a href="<%=request.getContextPath()%>/board/insert">글쓰기</a>
	</table>
</body>
</html>