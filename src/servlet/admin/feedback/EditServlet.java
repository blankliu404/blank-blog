package servlet.admin.feedback;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-10 19:52
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
import entity.Feedback;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/admin/index/feedback/edit")
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
		if(request.getParameter("fid")!=null) {
			FeedbackDao feedbackDao = new FeedbackDao();
			Feedback feedback = null;
			try {
				feedback = feedbackDao.selectFeedBackById(Integer.parseInt(request.getParameter("fid")));
				request.setAttribute("feedback", feedback);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		
		if(request.getParameter("fid")!=null) {
			Feedback feedback = new Feedback();
			int fid = Integer.parseInt(request.getParameter("fid"));
			feedback.setFid(fid);
			if(request.getParameter("fsolve")==null) feedback.setFsolve("false");
			else feedback.setFsolve("true");
			FeedbackDao feedbackDao = new FeedbackDao();
		
			try {
				if(feedbackDao.updateFeedback(feedback)) {
					HttpSession session = request.getSession();
					session.setAttribute("url", "/blog/admin/index/feedback/list");
					session.setAttribute("message", "修改成功!");
					response.setHeader("refresh", "0;/blog/errorpage/success.jsp");
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("url", "/blog/admin/index/article/edit?fid="+fid);
					session.setAttribute("message", "未知错误！修改失败!");
					response.setHeader("refresh", "0;/blog/errorpage/error.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		doGet(request, response);
	}

}
