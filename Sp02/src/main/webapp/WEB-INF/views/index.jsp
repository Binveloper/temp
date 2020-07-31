<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Model with Spring 5 Index</title>
	</head>
	<body style="text-align:center">
		<h1>
			Model with Spring 5
		</h1>
		<a href="address/list.do">주소록</a>
		<br/>
		<a href="address1/list.do">주소록</a>(Spring5 + MyBatis)
		<br/>
		<a href="address2/list.do">주소록</a>(Spring5 + MyBatis + 이름 정렬)
		<br/>
		<a href="board/list.do?cp=1&ps=3">게시판</a>
		<br/>
		<a href="board1/list.do?cp=1&ps=3">게시판2</a>
		<br/>
		<a href="board2/list.do?">게시판2 with 선생님</a>
		<br/>
		<a href="paging/list.do?">게시판 with paging module</a>
	</body>
</html>