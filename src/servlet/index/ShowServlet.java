package servlet.index;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-10 14:43
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ArticleDao;
import dao.ReviewDao;
import entity.Article;
import entity.Review;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/index/show")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArticleDao articleDao = new ArticleDao();
		
		//处理aid
		
		try {
			int aid;
			if(request.getParameter("aid")!=null)aid = Integer.parseInt(request.getParameter("aid"));
			else aid = articleDao.findArticle().getAid();	//抓一个文章
			//点击量加1
			HttpSession session = request.getSession();
			if(session.getAttribute(aid+"")==null) {
				articleDao.increaseClick(aid);
				session.setAttribute(aid+"", aid);
			}
			
			Article article = articleDao.selectArticlelById(aid);
			ReviewDao reviewDao = new ReviewDao();
			List<Review> reviewList = reviewDao.selectReviewAll(aid);
			
			//推荐列表
			List<Article> recommendedList = articleDao.selectArticlelByCid(article.getCid());
			request.setAttribute("recommendedList", recommendedList);
			
			request.setAttribute("article", article);
			request.setAttribute("reviewList", reviewList);
			request.setAttribute("aid", aid);
		}catch (Exception e) {
			// TODO: handle exceptione
			e.printStackTrace();
		}
	
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Review review = new Review();
		if(request.getParameter("torid")!=null) {
			review.setTorid(Integer.parseInt(request.getParameter("torid")));
		}
		if(request.getParameter("torname")!=null) {
			review.setTorname(request.getParameter("torname"));
		}
		if(request.getParameter("aid")!=null) {
			review.setAid(Integer.parseInt(request.getParameter("aid")));
		}
		if(request.getParameter("rcontent")!=null) {
			review.setRcontent(request.getParameter("rcontent"));
		}
		if(request.getParameter("rname")!=null) {
			review.setRname(request.getParameter("rname"));
		}
		if(request.getParameter("remail")!=null) {
			review.setRemail(request.getParameter("remail"));
		}
		if(request.getParameter("rsex")!=null) {
			review.setRsex(request.getParameter("rsex"));
		}
		
		ReviewDao reviewDao = new ReviewDao();
		try {
			reviewDao.insertReview(review);
			out.print(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.print(false);
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
