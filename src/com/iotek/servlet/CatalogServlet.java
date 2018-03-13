package com.iotek.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.db.CatalogManager;
import com.iotek.entity.AuthorBean;
import com.iotek.entity.CatalogBean;

/**
 * Servlet implementation class CatalogServlet
 */
@WebServlet(name = "catalogServlet", urlPatterns = { "/catalogServlet" })
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		
		String cataname = request.getParameter("uname");
		String catastate = request.getParameter("utype");
		String catamemo = request.getParameter("umemo");
		System.out.println("cataname:"+cataname+" catastate:"+catastate+" catamemo:"+catamemo);
		
		
		AuthorBean authorBean = (AuthorBean)request.getSession().getAttribute("curUser");
		System.out.println("authorBean");
		if(authorBean==null)return;
		System.out.println(authorBean.toString());
		int authorid = authorBean.getAuthorid();
		
		System.out.println("fetchCatalogs");
		CatalogManager.fetchCatalogs(authorid);
		
		if(request.getParameter("submit").equals("修改保存"))return;
		
		
		CatalogManager catalogManager = new CatalogManager();
		
		boolean result = false;
		result = catalogManager.saveCatalogBean(initCatalogBean(request));
		PrintWriter pw = response.getWriter();
		if(result){
			pw.println("保存成功");
			System.out.println("保存成功");
		}else{
			pw.println("保存失败");
			System.out.println("保存失败");
		}
		pw.close();
	}

	private CatalogBean initCatalogBean(HttpServletRequest request) {
		CatalogBean catalogBean = new CatalogBean();
		String cataname = request.getParameter("uname");
		String catastate = request.getParameter("utype");
		String catamemo = request.getParameter("umemo");
		AuthorBean authorBean = (AuthorBean)request.getSession().getAttribute("curUser");
		int authorid = authorBean.getAuthorid();
		/*int d_t_cataid = (Integer) null;
		catalogBean.setD_t_cataid(d_t_cataid);*/
		catalogBean.setAuthorid(authorid);
		catalogBean.setCataname(cataname);
		catalogBean.setCatastate(catastate);
		catalogBean.setCatamemo(catamemo);
		
		return catalogBean;
	}

}
