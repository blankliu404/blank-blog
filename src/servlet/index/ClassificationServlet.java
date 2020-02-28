package servlet.index;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-09 15:24
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
import dao.ClassificationDao;
import entity.Article;
import entity.ClassAndCount;
import entity.Classification;

import method.*;
/**
 * Servlet implementation class ClassificationServlet
 */
@WebServlet("/index/classification")
public class ClassificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//根据分类id查文章
		ClassificationDao classificationDao = new ClassificationDao();
		int cid = 0;	//分类id
		if (request.getParameter("cid")!=null) {
			cid = Integer.parseInt(request.getParameter("cid"));
		}else {
			try {
		
				cid = classificationDao .findClass().getCid();//找最前面的分类
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		ArticleDao articleDao = new ArticleDao();
		
		try {
			List<Classification> classifications = classificationDao.selectClassAll();
			List<ClassAndCount> classAndCountList = ArticleMethod.findClassAndCount(classifications);
			//处理页数
			int page = 1;
			if(request.getParameter("page")!=null) page = Integer.parseInt(request.getParameter("page"));
			
			List<Article> articleList = articleDao.paginateClass(page, cid);
			request.setAttribute("classAndCountList", classAndCountList);
			request.setAttribute("articleList", articleList);	//根据分类查列表
			int total = articleDao.countAllByClass(cid);	//总数
			int pageCount = articleDao.pageCountByClass(cid);	//页数
			request.setAttribute("total", total);
			request.setAttribute("page", page); 	//当前页
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("cid", cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("classification.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
