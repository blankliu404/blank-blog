package servlet.admin.classification;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-10 10:36
 * */
import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClassificationDao;
import entity.Classification;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/admin/index/classification/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cid;
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		if(request.getParameter("cname")!=null) {
			ClassificationDao classificationDao = new ClassificationDao();
			Classification classification = new Classification();
			classification.setCid(Integer.parseInt(request.getParameter("cid")));
			classification.setCname(request.getParameter("cname"));
			try {
				
				if(classificationDao.updateClass(classification)) {
					HttpSession session = request.getSession();
					session.setAttribute("url", "/blog/admin/index/classification/list");
					session.setAttribute("message", "修改成功!");
					response.setHeader("refresh", "0;/blog/errorpage/success.jsp");
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("url", "/blog/admin/index/classification/edit?cid="+classification.getCid());
					session.setAttribute("message", "分类名重复！修改失败!");
					response.setHeader("refresh", "0;/blog/errorpage/error.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(request.getParameter("cid") != null) {
			 cid = Integer.parseInt(request.getParameter("cid"));
			 ClassificationDao classificationDao = new ClassificationDao();
			try {
				Classification classification = classificationDao.selectClassById(cid);
				request.setAttribute("classification", classification);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
