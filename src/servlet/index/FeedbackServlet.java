package servlet.index;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-09 15:41
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
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/index/feedback")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("feedback.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("ftitle") != null) {
			String ftitle = request.getParameter("ftitle");
			String fcontent = request.getParameter("fcontent");
			//System.out.println(ftitle+"\t"+fcontent);
			Feedback feedback = new Feedback();
			feedback.setFtitle(ftitle);
			feedback.setFcontent(fcontent);
			FeedbackDao feedbackDao = new FeedbackDao();
			try {
				feedbackDao.insertFeedback(feedback);
				HttpSession session = request.getSession();
				session.setAttribute("url", "/blog/index/feedback");
				session.setAttribute("message", "反馈成功！感谢反馈！");
				response.setHeader("refresh", "0;/blog/errorpage/success.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				HttpSession session = request.getSession();
				session.setAttribute("url", "/blog/index/feedback");
				session.setAttribute("message", "反馈失败！请再试一次！");
				response.setHeader("refresh", "0;/blog/errorpage/error.jsp");
				e.printStackTrace();
			}
		}
		doGet(request, response);
	}

}
