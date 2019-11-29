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
		<title>注册成功页面</title>
	</head>
	<body>
		<p style="text-align: center;margin-top:100px;font-size:14px;">
		    注册成功, <span id="djs" style="color:red;">5</span> 秒后跳转登陆页面！ 
		 <a href="login.jsp">立刻跳转到登陆页面</a>
		</p>
		<script type="text/javascript">
			var djs = document.getElementById("djs");
			var time = 5;
			var myTime = setInterval(function(){
				time--;
				djs.innerHTML = time;
				if(time<=0){
					clearInterval(myTime);
					window.location.href="login.jsp";
				}
			},1000);
		</script>
	</body>
</html>
