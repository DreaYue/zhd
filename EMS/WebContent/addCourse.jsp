<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>录入成绩</title>
</head>
<body>
	<h1>填写信息</h1>
	<form action="InscServlet" method="post">
		学号： <input name="sid" type="text" placeholder="请输入学号"> 课程编号 ：<input
			name="cid" type="text" placeholder="请输入课程编号"> 分数：<input
			name="score" type="text" placeholder="请输入成绩"> <input
			type="submit" value="提交">
	</form>
	<h1>${insc}</h1>
</body>
</html>