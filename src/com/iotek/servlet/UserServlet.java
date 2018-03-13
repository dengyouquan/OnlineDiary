package com.iotek.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iotek.security.AuthCheck;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "userServlet", urlPatterns = { "/userServlet" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		String account = request.getParameter("login");
		String password = request.getParameter("passwords");
		System.out.println("account:"+account+" password:"+password);
		boolean isValid =false;//用户有效性
		if(null!=account && !"".equals(account.trim()) && null!=password && !"".equals(password.trim())){
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);*/
			AuthCheck ac = new AuthCheck();
			isValid = ac.checkUser(account,password);
			if(isValid){
				HttpSession session = request.getSession(true);
				session.setAttribute("curUser", ac.getAuthor());
				System.out.println(ac.getAuthor().toString());
				response.sendRedirect("main.jsp");
			}
			else{
				request.setAttribute("loginError", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("loginError", "用户名或密码不能为空");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
