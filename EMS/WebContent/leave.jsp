<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div >
			<table >
					<thead>
						<tr>	
							<th>学号</th>
							<th>请假原因</th>
							<th>批准老师id</th>
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
							<th><c:if test="${leave.state eq 1}">批准</c:if>
				            <c:if test="${leave.state eq 0}">待处理</c:if>
				              <c:if test="${leave.state eq 2}">未批准</c:if>
							
							</th>
							<th>${leave.sid}</th>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>

</body>
</html>