<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<title>测试查询页面</title>
	
	<head>
	
	</head>
	<body>
		
		查询列表：	
		<table>
					<th>名字</th>
					<th>密码</th>
					<th>生日</th>
					<th>状态</th>
					<th>爱好</th>
					<th>年龄</th>
			<c:forEach items="${dataModels}" var="dataModel">
				<tr>
					<td>${dataModel.name }</td>
					<td>${dataModel.password }</td>
					<td>${dataModel.birthday }</td>
					<td>${dataModel.continued}</td>
					<td>${dataModel.hobby }</td>
					<td>${dataModel.maxAge}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
