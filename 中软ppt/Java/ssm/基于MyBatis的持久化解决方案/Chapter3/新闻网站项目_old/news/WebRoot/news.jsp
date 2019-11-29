<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title>新闻资讯内容</title>
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/news.css" />
	</head>
	<body>
		<div class="header">
			<div class="nav">
				<div class="logo"><strong><em>NEWS</em></strong></div>
				<ul>
					<li><a href="go.jsp">首页</a></li>
					<li><a href="">联系我们</a></li>
					<li><a href="">客服中心</a></li>
					<li><a href="">问题反馈</a></li>
				</ul>
			</div>
		</div>
		<div class="banner">
			<img src="img/0news.jpg" />
		</div>
		<div class="hengban"></div>
		<div class="container">
			<div class="newsType">
				<div></div>
				<p>新闻内容</p>
				<div></div>
			</div>
			<div class="content">
				<h4>${requestScope.st.titleName }</h4>
				<div>
					${requestScope.st.newContent }
				</div>
				<p>${requestScope.st.createTime }</p>
			</div>
		</div>
		<div class="hengban"></div>
		<div class="footer">
			<p>&copy; 沈阳中软国际ETC中心 http://www.chinasoft.com &nbsp;&nbsp;<a href="admin/login.jsp">后台管理</a></p>
		</div>
	</body>
</html>
