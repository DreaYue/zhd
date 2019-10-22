<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
</head>
<body>

	<form action="Loginservlet" method="post">
				
		工号:<input type="text" id="uname" name="uid" class="uname" placeholder="请输入用户名">
	
		密码:<input type="password" id="upwd" name="upwd" class="uname" placeholder="请输入密码">
	
		用户类型:<input type="radio" id="upwd" name="type" class="uname" value="teacher" >teacher
		<input type="radio" id="upwd" name="type" class="uname" value="student" >student
		<input type="radio" id="upwd" name="type" class="uname" value="admin" >admin
	
		<input type="submit" value="登录" >
		<a href="Register.jsp">注册</a>
			
	</form>
			<!-- 登录不正确信息展示 -->
			<span>${msg}</span>
</body>
</html>