package com.iotek.servlet;

import java.util.Date;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iotek.db.ConnectionFactory;
import com.iotek.entity.AuthorBean;
import com.iotek.security.AuthCheck;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name = "registerServlet", urlPatterns = { "/registerServlet" })
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
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String submit = request.getParameter("submit");
		System.out.println(submit);
		boolean result = false;
		if("注册登记".equals(submit)){
			//判断是否空
			//判断值是否合法
			//判断值是否重复（数据库）
			AuthCheck ac = new AuthCheck();
			AuthorBean ab = null;
			ab = initRegisterInfo(request);
			if(ab==null){
				System.out.println("ab==null");
				request.setAttribute("registerError", "空数据，注册失败");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
			}
			if(ac.checkUser(ab.getLoginname(), ab.getLoginname())){
				System.out.println("checkUser fail");
				request.setAttribute("registerError", "已有数据，注册失败");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				return;
			}
			result = ac.addAuthorBean(ab);
			if(!result){
				System.out.println("result == false");
				request.setAttribute("registerError", "未知原因，注册失败");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}else{
				request.setAttribute("registerError", "注册成功，可登陆");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}else if("进入系统".equals(submit)){
			String account = request.getParameter("uaccount");
			String password = request.getParameter("upassword");
			System.out.println("account:"+account+" password:"+password);
			boolean isValid =false;//用户有效性
			if(null!=account && !"".equals(account.trim()) && null!=password && !"".equals(password.trim())){
				AuthCheck ac = new AuthCheck();
				isValid = ac.checkUser(account,password);
				if(isValid){
					HttpSession session = request.getSession(true);
					session.setAttribute("curUser", ac.getAuthor());
					response.sendRedirect("main.jsp");
				}
				else{
					request.setAttribute("loginError", "用户名或密码错误");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("loginError", "用户名或密码不能为空");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}//else if
	}//processRequest
	private AuthorBean initRegisterInfo(HttpServletRequest request){
		AuthorBean ab = new AuthorBean();
		ab.setAnthorname(request.getParameter("uname").trim());
		ab.setRoletype(request.getParameter("utype").trim());
		ab.setLoginname(request.getParameter("uaccount").trim());
		ab.setPasswords(request.getParameter("upassword").trim());
		ab.setEmail(request.getParameter("uemail").trim());
		ab.setMemo(request.getParameter("umemo").trim());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate=new Date(); 
	    java.sql.Date sqlDate=new java.sql.Date(utilDate.getDate());      
		/*try {
			sqlDate = format.parse(format.format(sqlDate));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		ab.setRegistdate(sqlDate);
		ab.setAuthorstatus("激活");
		if(isNull(ab)){
			return null;
		}
		return ab;
	}
	
	private boolean isNull(AuthorBean ab){
		boolean result = true;
		if(!"".equals(ab.getAnthorname()) && !"".equals(ab.getRoletype()) && !"".equals(ab.getLoginname()) && !"".equals(ab.getPasswords())  && !"".equals(ab.getRegistdate())){
			result = false;
		}
		return result;
	}
	
}
