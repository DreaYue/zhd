package com.ems.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.AdminDao;

/**
 * 
 * 管理员新增课程信息:
 * 
 * 
 * @author 
 *
 */
@WebServlet("/IncourseServlet")
public class IncourseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取请求参数
		String cname = request.getParameter("cname");
		String cid = request.getParameter("cid");
		String cteacherID = request.getParameter("cteacherId");
		Integer cmaxnum = Integer.parseInt(request.getParameter("cmaxnum"));
		Integer cnownum= Integer.parseInt(request.getParameter("cnownum"));
		Integer cgrade= Integer.parseInt(request.getParameter("cgrade"));
		String ctime=request.getParameter("ctime");
		
		//进行非空判断
		if (cname != "" && cid != "" && cteacherID != ""&& cnownum != null && cmaxnum !=null && cgrade != null && ctime != "") {
			
			AdminDao courseDao = new AdminDao();
			
			int cou = courseDao.addcourse(cid, cname,cteacherID,cmaxnum,cnownum,cgrade,ctime);
			if (cou > 0) {
				
				request.setAttribute("incourse", "添加成功");

			} else {
				request.setAttribute("incourse", "添加失败");

			}
			request.getRequestDispatcher("Incourse.jsp").forward(request, response);
		} else {
			request.setAttribute("incourse", "内容不能为空");
			request.getRequestDispatcher("Incourse.jsp").forward(request, response);
		}
	}

}
