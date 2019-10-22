<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师批准请假</title>
</head>
<body>
	<div>
		<table>
			<thead>
				<tr>
					<th>学号</th>
					<th>请假原因</th>
					<th>是否批准</th>
					<th>状态</th>
					<th>请假时间</th>
				</tr>
			</thead>
			<tbody>
				<!-- 遍历list集合 -->
				<c:forEach items="${leaveList}" var="leave" varStatus="s">
					<tr>
						<th>${leave.sid}</th>
						<th>${leave.ireason}</th>
						<th>${leave.tid}</th>
						<th><a href="PizhunServlet?sid=${leave.sid}&i=1">批准</a> <a
							href="PizhunServlet?sid=${leave.sid}&i=2">不批准</a></th>
						<th>${leave.sid}</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<h1>${msg3}</h1>
</body>
</html>