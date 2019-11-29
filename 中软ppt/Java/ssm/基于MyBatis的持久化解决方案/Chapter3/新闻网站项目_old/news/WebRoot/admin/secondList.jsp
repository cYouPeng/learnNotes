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
		<title>二级标题列表</title>
		<link rel="stylesheet" href="css/common.css" />
	</head>
	<body>
		<div class="container">
			<div class="box">
				<div class="title">
					<span>二级标题列表</span>
				</div>
				<div class="content">
					<table class="dataList">
						<tr>
							<th>二级标题ID</th>
							<th>二级标题名称</th>
							<th>创建者</th>
							<th>创建时间</th>
							<th>所属一级标题</th>
							<th>更新</th>
							<th>删除</th>
						</tr>
						<c:forEach var="st" items="${requestScope.sList}">
							<tr>
								<td>${st.sid }</td>
								<td>${st.titleName }</td>
								<td>${st.creator }</td>
								<td>${st.createTime }</td>
								<td>${st.ft.titleName }</td>
								<td><a href="/news/secondTitle/updateSecondTitleInitAdmin?sid=${st.sid }">更新</a></td>
								<td><a href="javascript:del(${st.sid })">删除</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			function del(param){
				if (window.confirm("你确认删除这条记录吗？")){
					window.location.href="/news/secondTitle/deleteSecondTitleAdmin?sid=" + param;
				}
			}
		</script>
	</body>
</html>
