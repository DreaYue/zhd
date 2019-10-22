<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生个人中心</title>
</head>
<body>
<h1>当前用户: ${user.uname }</h1>
<a href="LeaveServlet?sid=${user.uid}">请假信息查询</a>
<a href="shenqing.jsp">请假申请</a>
<a href="updatePassword.jsp">修改密码</a>
<a href="course.jsp">查询课程</a>

</body>
</html>