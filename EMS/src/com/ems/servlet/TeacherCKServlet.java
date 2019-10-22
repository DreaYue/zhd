package com.ems.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.LeaveDao;
import com.ems.pojo.EmsLeave;

/**
 * 
 * 老师查看学生信息
 * 
 * @author 
 *
 */
@WebServlet("/TeacherCKServlet")
public class TeacherCKServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//方法不对重新实现
		
		
	}
	
}
