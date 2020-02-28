package servlet.admin.feedback;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-10 12:03
 * */
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FeedbackDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/admin/index/feedback/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		if(request.getParameter("fid")!=null) {
			FeedbackDao feedbackDao = new FeedbackDao();
			try {
				feedbackDao.deleteFeedbackById(Integer.parseInt(request.getParameter("fid")));
				HttpSession session = request.getSession();
				session.setAttribute("url", "/blog/admin/index/feedback/list");
				session.setAttribute("message", "删除成功!");
				response.setHeader("refresh", "0;/blog/errorpage/success.jsp");
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
