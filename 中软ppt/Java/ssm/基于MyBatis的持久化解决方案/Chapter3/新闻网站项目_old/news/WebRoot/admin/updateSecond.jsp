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
		<title>更新二级标题</title>
		<link rel="stylesheet" href="css/common.css" />
	</head>
	<body>
		<div class="container">
			<div class="box">
				<div class="title">
					<span>更新二级标题</span>
				</div>
				<div class="content">
					<form action="/news/secondTitle/updateSecondTitleAdmin" method="post">
						<table>
							<tr>
								<td><span>二级标题ID</span></td><td>${requestScope.st.sid }<input type="hidden" name="sid" value="${requestScope.st.sid }"/></td>
							</tr>
							<tr>
								<td><span>二级标题名称</span></td><td><input type="text" name="titleName" value="${requestScope.st.titleName }"/></td>
							</tr>
							<tr>
								<td><span>所属一级标题</span></td>
								<td>
									<select name="parentTitleId">
										<c:forEach var="ft" items="${requestScope.fList}">
											<c:if test="${requestScope.st.parentTitleId==ft.fid}">
												<option value="${ft.fid }" selected>${ft.titleName }</option>
											</c:if>
											<c:if test="${requestScope.st.parentTitleId!=ft.fid}">
												<option value="${ft.fid }">${ft.titleName }</option>
											</c:if>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td><span>创建者</span></td><td><input type="text" name="creator" value="${requestScope.st.creator }"/></td>
							</tr>
							<tr>
								<td><span>二级标题内容</span></td>
								<td><textarea name="newContent" rows="6" cols="60">${requestScope.st.newContent }</textarea></td>
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
