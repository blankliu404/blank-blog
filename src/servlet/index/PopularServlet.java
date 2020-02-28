package servlet.index;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-09 15:44
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

import entity.Article;


import entity.KeywordAndCount;


/**
 * Servlet implementation class PopularServlet
 */
@WebServlet("/index/popular")
public class PopularServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopularServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArticleDao articleDao = new ArticleDao();
		//根据关键词查文章
		String keyword = null;
		if(request.getParameter("keyword")!=null) {
			keyword = request.getParameter("keyword");
		}else {
			try {
				keyword = articleDao.findArticle().getKeyword();	//抓一个关键词
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			List<KeywordAndCount> keywordAndCountList = articleDao.selectKeywordAndCount();//关键词 关键词数量 的列表
			request.setAttribute("keywordAndCountList", keywordAndCountList);
			
			//处理页数
			int page = 1;
			if(request.getParameter("page")!=null) page = Integer.parseInt(request.getParameter("page"));
			
			List<Article> articleList = articleDao.paginateKeyword(page, keyword);
			request.setAttribute("articleList", articleList);	//根据关键词查列表
			int total = articleDao.countAllByKeyword(keyword);//总数
			int pageCount = articleDao.pageCountByKeyword(keyword);	//页数
			request.setAttribute("total", total);
			request.setAttribute("page", page); 	//当前页
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("keyword", keyword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		request.getRequestDispatcher("popular.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
