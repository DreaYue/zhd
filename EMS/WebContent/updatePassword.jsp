<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生修改密码</title>
</head>
<body>
	<form action="UpdatePwdServlet" method="post">
		请输入id： <input name="uid" type="text" placeholder="请输入id">
		请输入旧密码： <input name="upassword" type="password" placeholder="请输入旧密码">${msg1}
		请输入新密码： <input name="newpwd1" type="password" placeholder="请输入新密码">
		请确认新密码： <input name="newpwd2" type="password" placeholder="请确认新密码">${msg2}
		<input type="submit" value="提交">
	</form>
	<span>${msg3}</span>
</body>
</html>