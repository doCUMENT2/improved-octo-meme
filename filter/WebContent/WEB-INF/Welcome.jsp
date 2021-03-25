<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h2>Welcome<%=session.getAttribute("currentUser") %></h2>
	<a href="RemoveSession">注销</a>
</body>
</html>