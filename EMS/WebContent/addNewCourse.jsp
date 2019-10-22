<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增课程</title>
</head>
<body>
		<h1>填写课程信息</h1>
		<form action="IncourseServlet" method="post">
				课程编号 ：<input name="cid" type="text" placeholder="请输入课程编号"><br>
				课程名称： <input name="cname" type="text" placeholder="请输入课程名称"><br>
				授课老师id：<input name="cteacherId" type="text" placeholder="请输入授课老师id"><br>
			    课程最大选择人数：<input name="cmaxnum" type="text" placeholder="输入课程最大选择人数"><br>
			    目前选课人数：<input name="cnownum" type="text" placeholder="请输入目前选课人数"><br>
			    课程对应的学分：<input name="cgrade" type="text" placeholder="请输入课程对应的学分"><br>
			   课程进行时间：<input name="ctime" type="date" placeholder="请输入课程进行时间"><br>
			<input type="submit" value="提交">
		</form>
		<h1>${incourse}</h1>

</body>
</html>