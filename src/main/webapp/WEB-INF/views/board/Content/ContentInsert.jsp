<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="my.remind.board4.vo.ContentVO" %>
<!DOCTYPE html>
<html>
<head>
	<title>게시판 > 글쓰기</title>
</head>
<body>
	<a>${page}</a>
	<form action="insert.do" method="post">
		title <input type="text" name="boardTitle"><br />
		writer <input type="text" name="boardWriter"><br />
		date <input type="text" name="boardDate" value="2017"><br />
		content <textarea name="boardContent" cols="40" rows="10"></textarea><br />
		<input type="submit" value="전송">
	</form>
</body>
</html>