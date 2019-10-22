<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册界面</title>
</head>
<body>
<div>
<h1>注册信息</h1>
<form action="RegisterServlet" method="post">

	<div >姓名
	<input  name="uname" type="text" placeholder="请输入用户名">
	</div>
	<div>密码
	<input  name="upassword" type="password"  placeholder="请输入密码">
	</div>
	<div>请确认密码
	<input  name="rpassword" type="password"  placeholder="请输入密码">
	</div>
	<div>学号
	<input  name="uid" type="text"  placeholder="请输入学号" >
	</div>
	<div>请选择类型
	<input type="radio" name="utype" value="student">学生
	<input type="radio" name="utype" value="teacher">教师
	<input type="radio" name="utype" value="admin">管理员
	</div>
	<input type="submit" value="提交">
</form>
<span>${msg2}</span>


</div>

</body>
</html>