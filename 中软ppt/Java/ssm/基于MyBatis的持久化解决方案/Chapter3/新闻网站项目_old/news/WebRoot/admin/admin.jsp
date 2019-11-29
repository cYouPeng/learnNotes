<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.chinasoft.news.entity.Users"%>
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
		<title>后台管理首页</title>
		<link rel="stylesheet" href="css/common.css" />
	</head>
	<body>
		<div class="container">
			<div class="header">
				<% 
				    //jstl中不能调用对象方法。
					String txUrl = ((Users)session.getAttribute("users")).getTxUrl();
					if(txUrl==null||txUrl.equals("")){
						out.print("<img src='../img/wtx.jpg'/>");
					}else{
						out.print("<img src='../upload/"+txUrl+"'/>");
					}
				%>
				<h3>新闻资讯后台管理系统</h3>
				<p>管理员：${sessionScope.users.username }</p>
			</div>
			<div class="main">
				<div class="left">
					<ul>
						<li>菜单列表</li>
						<li><a href="addFirst.jsp" target="manager">添加一级标题</a></li>
						<li><a href="/news/firstTitle/selectFirstTitleAllAdmin" target="manager">一级标题管理</a></li>
						<li><a href="/news/secondTitle/insertSecondTitleInitAdmin" target="manager">添加二级标题</a></li>
						<li><a href="/news/secondTitle/selectSecondTitleAllAdmin" target="manager">二级标题管理</a></li>
						<li><a href="/news/go.jsp" target="_top">回到首页</a></li>
					</ul>
				</div>
				<div class="right">
					<iframe src="welcome.jsp" name="manager" frameborder="no" scrolling="no"></iframe>
				</div>
			</div>
		</div>
		
	</body>
</html>
