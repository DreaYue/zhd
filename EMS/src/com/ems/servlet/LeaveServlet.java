package com.ems.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.StudentDao;
import com.ems.pojo.EmsLeave;

/**
 * 
 * 学生请假信息查询
 * 
 * @author 
 *
 */
@WebServlet("/LeaveServlet")
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//接受请求数据
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		StudentDao dao=new StudentDao();
		
		//调用dao层查询数据:
		List<EmsLeave> list=dao.FindStudentLeave(sid);
		request.setAttribute("leaveList", list);
		
		//请求转发
		request.getRequestDispatcher("leave.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
