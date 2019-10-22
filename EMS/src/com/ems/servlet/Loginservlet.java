package com.ems.servlet;

import java.io.IOException;
import com.ems.dao.StudentDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.pojo.EmsUser;

/**
 * 用户登录
 * 
 * 
 * @author lenovo
 *
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	EmsUser user = null;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取登录页面的用户名和密码
		String uid = request.getParameter("uid");
		String pass = request.getParameter("upwd");
		String type = request.getParameter("type");

		//获取session对象:
		HttpSession session = request.getSession();
		
		// 进行非空判断:
		if (uid != null && pass != null && type != null) {
			// 调用dao层:
			StudentDao dao = new StudentDao();
			user = dao.checkLogin(uid, pass, type);

			/* System.out.println(use.toString()); */

			// 对查询结果进行判断
			if (user != null) {
				//将查询的信息存储在session作用域中:
				session.setAttribute("user", user);
				
				if (type.equals("teacher")) {
					//进入教师中心
					response.sendRedirect("teacher.jsp");
				} else if (type.equals("student")) {
					//进入学生中心:
					response.sendRedirect("student.jsp");
				} else {
					//进入超级管理员中心					
					response.sendRedirect("admin.jsp");
				}
			} else {
				session.setAttribute("msg", "用户名和密码不匹配");
				//防止表单的重复提交  使用重定向
				response.sendRedirect("login.jsp");
			}
		} else {
			//防止表单的重复提交  使用重定向
			session.setAttribute("msg", "请输入用户名密码");
			response.sendRedirect("login.jsp");
		}
	}
}
