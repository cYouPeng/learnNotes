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
		<title>一级标题列表</title>
		<link rel="stylesheet" href="css/common.css" />
	</head>
	<body>
		<div class="container">
			<div class="box">
				<div class="title">
					<span>一级标题列表</span>
				</div>
				<div class="content">
					<table class="dataList">
						<tr>
							<th>一级标题ID</th>
							<th>一级标题名称</th>
							<th>创建者</th>
							<th>创建时间</th>
							<th>更新</th>
							<th>删除</th>
						</tr>
						<c:forEach var="ft" items="${requestScope.fList}">
							<tr>
								<td>${ft.fid }</td>
								<td>${ft.titleName }</td>
								<td>${ft.creator }</td>
								<td>${ft.createTime }</td>
								<td><a href="/news/firstTitle/selectFirstTitleByIdAdmin?fid=${ft.fid }">更新</a></td>
								<td><a href="javascript:del(${ft.fid })">删除</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			function del(param){
				if (window.confirm("当你删除一级标题时，会同时删除它所属的所有二级标题！你确认删除吗？")){
					window.location.href="/news/firstTitle/deleteFirstTitleAdmin?fid=" + param;
				}
			}
		</script>
	</body>
</html>
