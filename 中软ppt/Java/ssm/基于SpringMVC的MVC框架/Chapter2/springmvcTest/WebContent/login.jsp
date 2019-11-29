<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>登陆</h3>
		<form action="${pageContext.request.contextPath}/ssm/login.do" method="post">
			username:<input type="text" name="username" value="${requestScope.users.username}"><br>
			password:<input type="password" name="password" value="${requestScope.users.password}"><br>
			<input type="submit" value="登陆">
		</form>
	</body>
</html>