<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/admin/";
%>
<!DOCTYPE html>
<html>
	<head>
	    <base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title>更新一级标题</title>
		<link rel="stylesheet" href="css/common.css" />
	</head>
	<body>
		<div class="container">
			<div class="box">
				<div class="title">
					<span>更新一级标题</span>
				</div>
				<div class="content">
					<form action="/news/firstTitle/updateFirstTitleAdmin" method="post">
						<table>
							<tr>
								<td><span>一级标题ID</span></td><td>${requestScope.ft.fid }<input type="hidden" name="fid" value="${requestScope.ft.fid }"/></td>
							</tr>
							<tr>
								<td><span>一级标题名称</span></td><td><input type="text" name="titleName" value="${requestScope.ft.titleName }"/></td>
							</tr>
							<tr>
								<td><span>创建者</span></td><td><input type="text" name="creator"  value="${requestScope.ft.creator }"/></td>
							</tr>
							<tr>
								<td></td><td><input type="submit" value="更新"/></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
