package servlet.admin.article;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-10 11:20
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

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/admin/index/article/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
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
		
		try {
			ArticleDao articleDao = new ArticleDao();
			
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
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
