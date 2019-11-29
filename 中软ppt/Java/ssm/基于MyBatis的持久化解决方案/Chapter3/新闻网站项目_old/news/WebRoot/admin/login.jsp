<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/admin/";
%>
<!DOCTYPE html>
<html>
	<head>
		<!-- target="_top" 保证登陆后，admin.jsp页面始终在顶层窗口打开，防止出现框架内嵌套现象 -->
	    <base href="<%=basePath%>" target="_top">
		<meta charset="utf-8" />
		<title>登陆</title>
		<link rel="stylesheet" href="css/common.css" />
		<style>
			.container{
				width: 400px;
				margin: 0 auto;
				margin-top: 100px;
				height: 360px;
			}
			.box{
				width: 400px;
				height: 360px;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<div class="box">
				<div class="title">
					<span>登陆</span>
				</div>
				<div class="content">
					<form action="/news/users/selectUsersByNameByPass" method="post" name="form1" onsubmit="return check()">
						<table>
							<tr>
								<td><span>用户名</span></td><td><input type="text" name="username"/></td>
							</tr>
							<tr>
								<td><span>密码</span></td><td><input type="password" name="password"/></td>
							</tr>
							<tr>
								<td><span>验证码</span></td>
								<td>
									<img src="../users/authCode" id="codeImage" style="width:63px;height:37px;display:inline">&nbsp;
									<a onclick="chageCode()" style="cursor:pointer;-webkit-user-select:none;">看不清楚,换一张</a><br/>
									<input type="text" name="authCode"/>
								</td>
							</tr>
							<tr>
								<td></td><td><input type="submit" value="登陆"/>&nbsp;&nbsp;<a href="register.jsp">注册</a></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<p style="color:red;margin-top:10px;">${requestScope.errorMessage }</p>
		</div>
		
		<script type="text/javascript">
			function chageCode(){
        		//链接后添加Math.random，确保每次请求和上一次不一致，这样可以避免缓存问题，用于产生新的验证码。
        		document.getElementById("codeImage").src = "/news/users/authCode?abc="+Math.random();
    		}
    		
    		function check(){
				var username = document.form1.username.value;
				var password = document.form1.password.value;
				var authCode = document.form1.authCode.value;
				if(username==""){
					alert("用户名不能为空！");
					return false;
				}
				if(password==""){
					alert("密码不能为空！");
					return false;
				}
				if(authCode==""){
					alert("验证码不能为空！");
					return false;
				}
				return true;
			}
		</script>
	</body>
</html>
