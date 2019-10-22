package com.ems.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ems.dao.StudentDao;

/**
 * 
 * 学生修改密码
 * 
 * @author 
 *
 */
@WebServlet("/UpdatePwdServlet")
public class UpdatePwdServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 获取请求数据
		String id = request.getParameter("uid");		
		String pwd = request.getParameter("upassword");
		String npwd1 = request.getParameter("newpwd1"); 
		String npwd2 = request.getParameter("newpwd2");

//		System.out.println("Servlet：" + id + "---" + pwd + "---" + npwd1 + "---" + npwd2 + "---");

		// 非空判断
		if ( pwd != null && npwd1 != null && npwd2 != null) {

			if (!npwd1.equals(npwd2)) {
				request.setAttribute("msg2", "两次密码不一致");
				return;
			} else {

				StudentDao dao = new StudentDao();
				int a = dao.checkUpdate(npwd1, id, pwd);
				
				//输入的用户名与原密码不匹配
				if (a == 10) {
					request.setAttribute("msg1", "输入正确信息");
				} else if (a == 1) {
					request.setAttribute("msg3", "修改成功");
				} else {
					request.setAttribute("msg3", "修改失败");
				}
			}

		}else {
			request.setAttribute("msg1", "信息不完整！");
		}
		request.getRequestDispatcher("UpdatePwd.jsp").forward(request, response);
	}
	
}
