package com.ems.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.dao.StudentDao;

/**
 * 
 * 学生申请请假
 * 
 * @author
 *
 */

@WebServlet("/AskForLeaveServlet")
public class AskForLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求信息
		String uid = request.getParameter("uid");
		String ireason = request.getParameter("ireason");
		String tid = request.getParameter("tid");
		String date = request.getParameter("ltime");

		// 缺少非空判断
		
		
		
		

		// 调用dao层:
		StudentDao dao = new StudentDao();

		int lstudent = dao.shenqingin(uid, ireason, tid, date);
		HttpSession session = request.getSession();
		if (lstudent > 0) {

			session.setAttribute("shenqing", "申请成功");

		} else {

			session.setAttribute("shenqing", "申请失败");

		}
		response.sendRedirect("shenqing.jsp");
	}

}
