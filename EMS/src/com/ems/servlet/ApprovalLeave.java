package com.ems.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.TeacherDao;

/**
 * 
 * 老师批准学生请假信息
 * 
 * @author
 *
 */
@WebServlet("/PizhunServlet")
public class ApprovalLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse respose)
			throws ServletException, IOException {

		String sid = request.getParameter("sid");
		String pizhun = request.getParameter("i");
		TeacherDao leaveDao = new TeacherDao();
		int a = leaveDao.qingjia(pizhun, sid);
		if (a > 0) {
			request.setAttribute("msg3", "执行成功");

		} else {
			request.setAttribute("msg3", "执行失败");

		}
		request.getRequestDispatcher("QingjiaXinxi.jsp").forward(request, respose);
	}

}
