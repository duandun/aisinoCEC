<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<form:form action="dataModel/selectByCondition.html" method="post" >
		<table>
			<tr>
				<td>
					姓名:
					<input type="text" name="name" />
				</td>
				<td>
					页数:
					<input type="text" name="pageNum" />
					<input type="hidden" name="pageSize" value="10"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="查询" />
				</td>
			</tr>
		</table>
	</form:form>
</html>