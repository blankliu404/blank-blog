package servlet;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-10 20:26
 * */
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import method.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/admin/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("op")!=null) {
			if(request.getParameter("op").equals("exit")) {
				HttpSession session = request.getSession();
				session.invalidate();//结束本次会话 
				
				session = request.getSession();
				session.setAttribute("url", "/blog/admin/login");
				session.setAttribute("message", "退出成功！");
				response.setHeader("refresh", "0;/blog/errorpage/success.jsp");
			}
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = getServletContext();
		Login login = new Login(servletContext);
		
		if(login.islogin(request)) {	//验证用户名密码
			HttpSession session = request.getSession();
			session.setAttribute("url", "/blog/admin/index");
			session.setAttribute("message", "登陆成功！");
			response.setHeader("refresh", "0;/blog/errorpage/success.jsp");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("url", "/blog/admin/login");
			session.setAttribute("message", "未正确填写管理员账户或密码！请重试！");
			response.setHeader("refresh", "0;/blog/errorpage/error.jsp");
		}
	}

}
