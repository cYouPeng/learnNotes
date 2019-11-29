<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		登陆成功！<br><br>
		<a href="${pageContext.request.contextPath}/manager/all.do">全查询</a><br>
		<a href="${pageContext.request.contextPath}/upload.jsp">上传文件</a><br>
		<a href="${pageContext.request.contextPath}/ssm/json.do/zhangsan/234">返回json</a><br>
		<a href="${pageContext.request.contextPath}/html/index.html">访问静态资源</a><br>
	</body>
</html>