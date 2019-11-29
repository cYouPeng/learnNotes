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
		<title>注册</title>
		<link rel="stylesheet" href="css/common.css" />
		<style>
			.container{
				width: 430px;
				margin: 0 auto;
				margin-top: 30px;
				height: 550px;
			}
			.box{
				width: 430px;
				height: 550px;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<div class="box">
				<div class="title">
					<span>注册</span>
				</div>
				<div class="content">
					<form action="../users/insertUsers" method="post" onsubmit="return check()" name="form1">
						<table>
							<tr>
								<td><span>用户名</span></td><td><input type="text" name="username"/></td>
							</tr>
							<tr>
								<td><span>密码</span></td><td><input type="password" name="password"/></td>
							</tr>
							<tr>
								<td><span>确认密码</span></td><td><input type="password" name="beginPass"/></td>
							</tr>
							<tr>
								<td><span>上传头像</span></td>
								<td>
									<!-- 上传图片表单页面放在iframe中，是为了提交时不影响整个注册表单。 -->
									<iframe src="upload.jsp" width="220" height="200" frameborder="no" scrolling="no" name="myIframe"></iframe>
									<input name="txUrl" type="hidden">	
								</td>
							</tr>
							<tr>
								<td></td><td><input type="submit" value="注册"/></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			function check(){
				var username = document.form1.username.value;
				var password = document.form1.password.value;
				var beginPass = document.form1.beginPass.value;
				//从iframe的上传图片表单中，将图片路径取出，放入txUrl隐藏域中。
				var d = window.frames["myIframe"].document;
  				document.form1.txUrl.value = d.getElementById("fileUrl").value;
				if(username==""){
					alert("用户名不能为空！");
					return false;
				}
				if(password==""){
					alert("密码不能为空！");
					return false;
				}
				if(beginPass==""){
					alert("确认密码不能为空！");
					return false;
				}
				if(beginPass!=password){
					alert("两次输入的密码不相符！");
					return false;
				}
				return true;
			}
		</script>
	</body>
</html>
