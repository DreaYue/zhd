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
 * 老师添加学生成绩
 * 
 * @author lenovo
 *
 */
@WebServlet("/InscServlet")
public class InscServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数
		String sid=request.getParameter("sid");
		String cid=request.getParameter("cid");
		String score=request.getParameter("score");
		
		if (sid!=""&&cid!=""&&score!="") {
			
			TeacherDao scDao=new TeacherDao();
			
			int sc=scDao.addsc(sid, cid, score);
			if (sc>0) {
				//请求转发
				request.setAttribute("insc", "录入成功");
				 
				}else {
					request.setAttribute("insc", "录入失败");
			        
				}
			request.getRequestDispatcher("Insc.jsp").forward(request, response);
		}else {
			request.setAttribute("insc", "内容不能为空");
			request.getRequestDispatcher("Insc.jsp").forward(request, response);
		}
	}

}
