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
import javax.servlet.http.HttpSession;

import dao.ArticleDao;
import dao.ClassificationDao;
import entity.Article;
import entity.Classification;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/admin/index/article/add")
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
	
		
		List<Classification> classificationList;
		try {
			ClassificationDao classificationDao = new ClassificationDao();
			classificationList = classificationDao.selectClassAll();
			request.setAttribute("classificationList", classificationList);	//所有分类
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		if(request.getParameter("title")!=null) {
			String title = request.getParameter("title");	//标题
			String keyword = request.getParameter("keyword");//关键词
			String breviary = request.getParameter("breviary");//摘要
			String origin = request.getParameter("origin");
			boolean realOrigin;//是否为原创
			if(origin == null) realOrigin = false;
			else realOrigin = true;
			String classification = request.getParameter("classification");//分类id
			String content = request .getParameter("content");//内容
//			System.out.println(title+"\t"+keyword+"\t"+breviary+"\t"+origin+"\t"+classification+"\t"+content);
			Article article = new Article();
			article.setBreviary(breviary);
			article.setCid(Integer.parseInt(classification));
			article.setContent(content);
			article.setTitle(title);
			article.setKeyword(keyword);
			article.setOrigin(realOrigin);
			
			ArticleDao articleDao = new ArticleDao();
			try {
				
				if(articleDao.insertArticle(article)) {
					HttpSession session = request.getSession();
					session.setAttribute("url", "/blog/admin/index/article/list");
					session.setAttribute("message", "添加成功!");
					response.setHeader("refresh", "0;/blog/errorpage/success.jsp");
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("url", "/blog/admin/index/article/add");
					session.setAttribute("message", "文章名重复！添加失败!");
					response.setHeader("refresh", "0;/blog/errorpage/error.jsp");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		doGet(request, response);
	}

}
