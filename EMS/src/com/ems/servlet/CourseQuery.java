package com.ems.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.StudentDao;
import com.ems.pojo.EmsCourse;


/**
 * 
 *学生查询课程表信息
 * 
 * @author 
 *
 */
@WebServlet("/CourseQuery")
public class CourseQuery extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数
		String year = request.getParameter("year");
		
		//进行非空判断
		if(year !="" && year != null) {
			//调用dao层
			StudentDao dao = new StudentDao();
			
			List<EmsCourse> list = dao.CourseQuery(year);
			request.setAttribute("courseList",list);
			request.setAttribute("size",list.size());
			
		}else {
			request.setAttribute("queryMsg", "信息不能为空");
		}
		
		request.getRequestDispatcher("course.jsp").forward(request, response);
		
	}

}











