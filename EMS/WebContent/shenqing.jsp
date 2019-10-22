<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生请假申请</title>
</head>
<body>
	<form action="AskForLeaveServlet" method="post">
		学号：<input type="text" name="uid" placeholder="请输入学号"> 
		请假原因：<input type="text" name="ireason" placeholder="请输入原因">
		老师ID:<input type="text" name="tid" placeholder="输入id"> 
		请假时间：<input type="date" name="ltime"> <input type="submit" value="提交">
		<span>${shenqing}</span>
	</form>
</body>
</html>