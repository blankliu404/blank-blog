package servlet.index;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-09 15:21
 * */
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDao;
import dao.LinkDao;
import entity.Article;
import entity.ClassAndCount;
import entity.KeywordAndCount;
import entity.Link;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理页数
		int page = 1;
		if(request.getParameter("page")!=null) page = Integer.parseInt(request.getParameter("page"));
		ArticleDao articleDao = new ArticleDao();
		try {
			
			
			List<Article> articleList = articleDao.paginate(page);
			request.setAttribute("articleList", articleList);
		
			int total = articleDao.countAll();	//总数
			int pageCount = articleDao.pageCount();	//页数
			request.setAttribute("total", total);
			request.setAttribute("page", page); 	//当前页
			request.setAttribute("pageCount", pageCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//分类  关键词 点击量前十五 友情链接
		try {
			List<ClassAndCount> classAndCountList = articleDao.selectClassAndCount();
			List<KeywordAndCount> keywordAndCountList = articleDao.selectKeywordAndCount();
			List<Article> articleClickList = articleDao.selectClickLimit5();
			LinkDao linkDao = new LinkDao();
			List<Link> linkList = linkDao.selectLinkAll();
			
			request.setAttribute("classAndCountList", classAndCountList);
			request.setAttribute("keywordAndCountList", keywordAndCountList);
			request.setAttribute("articleClickList", articleClickList);
			request.setAttribute("linkList", linkList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
