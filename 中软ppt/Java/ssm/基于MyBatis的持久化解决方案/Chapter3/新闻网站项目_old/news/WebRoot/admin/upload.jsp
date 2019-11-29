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
		<title></title>
		<style>
			html,body{
				margin: 0;
				padding: 0;
			}
			input[type="submit"]{
				width:68px;
				height:25px;
				background-color:#5CB85C;
				border:solid 1px #999;
				margin-top:5px;
				border-radius:5px;
			}
			.grtx{
				margin-top: 12px;
			}
			.grtx img{
				width:140px;
				height:140px;
			}
		</style>
	</head>
	<body>
		<form action="/news/users/upload" method="post" enctype="multipart/form-data" onsubmit="return fileCheck()" name="fileForm">
      		<input type="file" name="file"/> 
      		<input type="submit" value=" 上 传 "/>
    	</form>
    	<div class="grtx">
    		<!-- 注册页面刚加载时，个人头像显示默认图片 -->
    		<c:if test="${requestScope.fileUrl==null}">
    			<img src="/news/upload/wtx.jpg" alt="个人头像">
    		</c:if>
    		<c:if test="${requestScope.fileUrl!=null}">
    			<img src="/news/upload/${requestScope.fileUrl}" alt="个人头像">
    		</c:if>
    	</div>
    	<input id="fileUrl" type="hidden" value="${requestScope.fileUrl}">					
	</body>
	
	<script type="text/javascript">
		function fileCheck(){
			var file = document.fileForm.file.value;
			if(file==""){
				alert("请选择要上传的图片！");
				return false;
			}
			return true;
		}
	</script>
</html>
