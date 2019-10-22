package com.ems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.dao.StudentDao;
import com.ems.pojo.EmsUser;




/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/HTML;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String username=request.getParameter("uname").trim();
		String pwd=request.getParameter("upassword").trim();
		String uid=request.getParameter("uid").trim();
		String utype=request.getParameter("utype").trim();
		String rpwd=request.getParameter("rpassword").trim();
		if (username!=""&&pwd!=""&&uid!=""&&rpwd!=""&&utype!=null) {
			if (pwd.equals(rpwd)) {
				StudentDao dao=new StudentDao();
				int use=dao.Resisterin(uid, username, pwd, utype);
				if (use>0) {
					//RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
						//rd.forward(request, response);
						//使用session存储用户信息
					//请求转发
					request.setAttribute("msg2", "注册成功");
					 
					}else {
						request.setAttribute("msg2", "注册失败");
				        
					}
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}else {
				request.setAttribute("msg2", "两次密码不一致，请重新填写");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg2", "内容不能为空，请重新填写");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		
		}
		

}
