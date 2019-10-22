<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生查询课程表</title>
<script type="text/javascript" src="style/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#courseQueryBtn").click(function(){
			var year = $("select").val();

			if(year == null || year == ""){
				alert("请选择查询日期");
				return;
			}
			document.forms[0].submit();
		});
	});
</script>
<style type="text/css">
	.title{
		text-align:center;
	}
	.date{
		
	}
</style>
</head>
<body>
<div>
	<div class="title">
		<h1>课程表查询</h1>
	</div>
	<div>
	<!-- 接收并显示后台返回的信息 -->
		<span style="font-size:500;color:red;">${queryMsg}</span>
	</div>
	<div>
		
	</div>
	<div>
		<form action="CourseQuery" method="post">
			<div>
				<center>
					<div>
						<select name="year">
							<option value=""></option>
							<option value="2018-2019">2018-2019</option>
							<option value="2017-2018">2017-2018</option>
							<option value="2016-2017">2016-2017</option>
							<option value="2015-2016">2015-2016</option>
							<option value="2014-2015">2014-2015</option>
							<option value="2013-2014">2013-2014</option>
						</select>
					</div>
					<div>
						<input type="button" id="courseQueryBtn" value="查询" class="courseQuery">
					</div>
				</center>
		<table style="text-align:center" cellspacing="0" width="1000" align="center">
			<thead>
				<tr>
					<th>课程编号</th>
					<th>课程名称</th>
					<th>授课教师</th>
					<th>最大选择人数</th>
					<th>已选人数</th>
					<th>学分</th>
					<th>是否为新课程</th>
					<th>授课时间</th>
				</tr>
			</thead>
			<tbody>
			<!-- 前台遍历list集合 -->
			<!-- items：指定集合的key，var是指集合中临时变量，carStatus：count/index -->
				<c:if test="${size == 0}"> <span style="position: absolute; top: 50%; left:50%">没有对应的课程！！！</span></c:if>
				
					<c:forEach items="${courseList}" var="user" varStatus="s">
					
			
						<tr>
							<!-- 显示查询结果 -->
							<td>${user.cid}</td>
							<td>${user.cname}</td>
							<td>${user.cteacherid}</td>
							<td>${user.cmaxnum}</td>
							<td>${user.cnownum}</td>
							<td>${user.cgrade}</td>
							<td>${user.cno}</td>
							<td>${user.ctime}</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
		</form>
	</div>
</div>
</body>
</html>