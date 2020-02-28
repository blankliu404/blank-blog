package servlet.admin.link;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-10 11:25
 * */
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LinkDao;
import entity.Link;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/admin/index/link/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		if(request.getParameter("lname")!=null) {
			LinkDao linkDao = new LinkDao();
			Link link = new Link();
			link.setLname(request.getParameter("lname"));
			link.setLink(request.getParameter("link"));
			try {
				if(linkDao.insertLink(link)) {
					HttpSession session = request.getSession();
					session.setAttribute("url", "/blog/admin/index/link/list");
					session.setAttribute("message", "添加成功!");
					response.setHeader("refresh", "0;/blog/errorpage/success.jsp");
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("url", "/blog/admin/index/link/add");
					session.setAttribute("message", "链接名重复！添加失败!");
					response.setHeader("refresh", "0;/blog/errorpage/error.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
