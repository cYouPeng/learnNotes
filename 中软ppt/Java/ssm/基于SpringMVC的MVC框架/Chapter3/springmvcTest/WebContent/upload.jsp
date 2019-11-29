<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/ssm/upload.do" enctype="multipart/form-data" method="post">
		  <input type="file" name="myFile"><br>
		  <input type="submit" value="上传">
		</form>
		<br>
		<img src="${requestScope.fileUrl}">
	</body>
</html>