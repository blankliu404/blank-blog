package dao;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-08 11:25
 * */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.ArrayList;

import java.util.List;

import entity.Article;
import entity.ClassAndCount;
import entity.Classification;
import entity.KeywordAndCount;
import util.JdbcUtil;

public class ArticleDao {

	public int countAll() throws SQLException {
		/*
		 * 计算文章总条数
		 * @Return 文章总条数
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select count(*) from article";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return count;
	}
	
	public int countAllByClass(int cid) throws SQLException {
		/*
		 * 计算同一分类文章总条数
		 * @Return 文章总条数
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select count(*) from article where cid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return count;
	}
	
	public int pageCountByClass(int cid) throws SQLException {
		/*
		 * 计算同一分类文章总页数
		 * @Return 文章总页数
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		int pageCount;
		try {
			count = countAllByClass(cid);
			pageCount = (int) Math.ceil(count / 8.0); // 向上取整 每页6行
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return pageCount;
	}
	
	public int countAllByKeyword(String keyword) throws SQLException {
		/*
		 * 计算同一关键词文章总条数
		 * @Return 文章总条数
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select count(*) from article where keyword=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			rs = ps.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return count;
	}
	
	public int pageCountByKeyword(String keyword) throws SQLException {
		/*
		 * 计算同一关键词文章总页数
		 * @Return 文章总页数
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		int pageCount;
		try {
			count = countAllByKeyword(keyword);
			pageCount = (int) Math.ceil(count / 8.0); // 向上取整 每页6行
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return pageCount;
	}

	public int pageCount() throws SQLException {
		/*
		 * 计算文章总页数
		 * @Return 文章总页数
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		int pageCount;
		try {
			count = countAll();
			pageCount = (int) Math.ceil(count / 8.0); // 向上取整 每页6行
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return pageCount;
	}

		
	public List<Article> paginate(int page) throws SQLException {
		/*
		 * 分页查询所有文章  8个一页
		 * @Param 页码
		 * @Return 文章列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pageCount = pageCount();
		int realPage;
		//处理页面溢出
		if(page > pageCount) {
			realPage = pageCount;	
		}else if(page < 1) {
			realPage = 1;
		}else {
			realPage = page;
		}
		
		List<Article> articleList = new ArrayList<Article>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from article order by aid desc limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (realPage-1) * 8);
			ps.setInt(2, 8);
			rs = ps.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setAid(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setBreviary(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setKeyword(rs.getString(5));
				article.setClick(rs.getInt(6));
				article.setCid(rs.getInt(7));
				article.setCreateTime(rs.getLong(8));
				article.setOrigin(rs.getBoolean(9));
				articleList.add(article);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return articleList;
	}
	
	public List<Article> paginateClass(int page,int cid) throws SQLException {
		/* 
		 * 分页查询相同分类所有文章  8个一页
		 * @Param 页码 分类id
		 * @Return 文章列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pageCount = pageCount();
		int realPage;
		//处理页面溢出
		if(page > pageCount) {
			realPage = pageCount;	
		}else if(page < 1) {
			realPage = 1;
		}else {
			realPage = page;
		}
		
		List<Article> articleList = new ArrayList<Article>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from article where cid=? order by aid desc limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, (realPage-1) * 8);
			ps.setInt(3, 8);
			rs = ps.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setAid(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setBreviary(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setKeyword(rs.getString(5));
				article.setClick(rs.getInt(6));
				article.setCid(rs.getInt(7));
				article.setCreateTime(rs.getLong(8));
				article.setOrigin(rs.getBoolean(9));
				articleList.add(article);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return articleList;
	}
	
	public List<Article> paginateKeyword(int page,String keyword) throws SQLException {
		/* 
		 * 分页查询相同关键词所有文章  8个一页
		 * @Param 页码 关键词
		 * @Return 文章列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pageCount = pageCount();
		int realPage;
		//处理页面溢出
		if(page > pageCount) {
			realPage = pageCount;	
		}else if(page < 1) {
			realPage = 1;
		}else {
			realPage = page;
		}
		
		List<Article> articleList = new ArrayList<Article>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from article where keyword=? order by aid desc limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setInt(2, (realPage-1) * 8);
			ps.setInt(3, 8);
			rs = ps.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setAid(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setBreviary(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setKeyword(rs.getString(5));
				article.setClick(rs.getInt(6));
				article.setCid(rs.getInt(7));
				article.setCreateTime(rs.getLong(8));
				article.setOrigin(rs.getBoolean(9));
				articleList.add(article);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return articleList;
	}
	
	public boolean deleteArticleById(int aid) throws SQLException {
		/*
		 * 通过id删除单个文章数据
		 * @Param 文章id
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from article where aid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			int num = ps.executeUpdate();
			
			if(num != 0)
				flag = true;
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	public boolean deleteArticleByIds(int[] aids) throws SQLException {
		/*
		 * 批量删除文章数据
		 * @Param 文章id数组
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			for (int aid : aids) {
				String sql = "delete from article where aid = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, aid);
				ps.executeUpdate();
			}
			
		}catch (Exception e) {
			return false;	//未知错误删除失败
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return true;
	}
	
	public boolean insertArticle(Article article) throws SQLException {
		/*
		 * 插入单个文章
		 * @Param 文章实体
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into article(title,breviary,content,keyword,cid,createtime,origin) value(?,?,?,?,?,unix_timestamp(),?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getBreviary());
			ps.setString(3, article.getContent());
			ps.setString(4, article.getKeyword());
			ps.setInt(5,article.getCid());
			ps.setString(6, article.getOrigin()+"");
			int num = ps.executeUpdate();
			
			if(num != 0)
				flag = true;
		} catch(SQLIntegrityConstraintViolationException e){ //文章名重复
			flag = false;
		}finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	public boolean updateArticle(Article article) throws SQLException {
		/*
		 * 更新单个文章
		 * @Param 文章实体
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update article set title = ?,breviary=?,content = ?,keyword = ?,cid = ?,origin=?  where aid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getBreviary());
			ps.setString(3, article.getContent());
			ps.setString(4, article.getKeyword());
			ps.setInt(5,article.getCid());
			ps.setString(6, article.getOrigin()+"");
			ps.setInt(7,article.getAid());
			int num = ps.executeUpdate();
			
			if(num != 0)
				flag = true;
		} catch(SQLIntegrityConstraintViolationException e){	//文章名重复
			flag = false;
		}finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	public Article findArticle() throws SQLException {
		/*
		 * 抓取一个最新文章
		 *
		 * @Return 文章实体
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Article article = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from article limit 1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				article = new Article();
				article.setAid(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setBreviary(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setKeyword(rs.getString(5));
				article.setClick(rs.getInt(6));
				article.setCid(rs.getInt(7));
				article.setCreateTime(rs.getLong(8));
				article.setOrigin(rs.getBoolean(9));
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return article;
	}
	
	public Article selectArticlelById(int aid) throws SQLException {
		/*
		 * 通过id查询单个文章
		 * @Param 文章id
		 * @Return 文章名
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Article article = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from article where aid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			rs = ps.executeQuery();
			if (rs.next()) {
				article = new Article();
				article.setAid(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setBreviary(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setKeyword(rs.getString(5));
				article.setClick(rs.getInt(6));
				article.setCid(rs.getInt(7));
				article.setCreateTime(rs.getLong(8));
				article.setOrigin(rs.getBoolean(9));
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return article;
	}
	
	public List<Article> selectArticlelByKeyword(String keyword) throws SQLException {
		/*
		 * 通过关键词查询文章
		 * @Param 关键词
		 * @Return 文章列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Article> articleList = new ArrayList<Article>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from article where keyword = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			rs = ps.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				
				article.setAid(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setBreviary(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setKeyword(rs.getString(5));
				article.setClick(rs.getInt(6));
				article.setCid(rs.getInt(7));
				article.setCreateTime(rs.getLong(8));
				article.setOrigin(rs.getBoolean(9));
				
				articleList.add(article);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return articleList;
	}
	
	public ClassAndCount findClassAndCount(Classification classification) throws SQLException {
		/*
		 * 单个分类统计数量
		 * @Param 分类实体
		 * @Return 分类id和每个分类文章的数量  
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ClassAndCount classAndCount = new ClassAndCount();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select cid,count(*) from article where cid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, classification.getCid());
			rs = ps.executeQuery();
			while (rs.next()) {
				
				classAndCount.setCid(rs.getInt(1));
				classAndCount.setCnameCount(rs.getInt(2));
	
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return classAndCount;
	}
	
	public List<ClassAndCount> selectClassAndCount() throws SQLException {
		/*
		 * 查询分类统计数量
		 * @Return 分类id和每个分类文章的数量  json数据
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClassAndCount> classAndCountList = new ArrayList<ClassAndCount>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select cid,count(*) from article group by cid order by count(*) desc limit 5";	//限制5条
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ClassAndCount classAndCount = new ClassAndCount();
				classAndCount.setCid(rs.getInt(1));
				classAndCount.setCnameCount(rs.getInt(2));
				classAndCountList.add(classAndCount);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return classAndCountList;
	}
	
	public List<KeywordAndCount> selectKeywordAndCount() throws SQLException {
		/*
		 * 查询关键词统计数量
		 * @Return 关键词名 和 数量
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<KeywordAndCount> KeywordAndCountList = new ArrayList<KeywordAndCount>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select keyword,count(*) from article group by keyword order by count(*) desc"; //限制20条
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				KeywordAndCount keywordAndCount = new KeywordAndCount();
				keywordAndCount.setKeyword(rs.getString(1));
				keywordAndCount.setKeywordCount(rs.getInt(2));
				KeywordAndCountList.add(keywordAndCount);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return KeywordAndCountList;
	}
	public List<Article> selectClickLimit5() throws SQLException {
		/*
		 * 查询点击量前十五的文章
		 * @Return 文章列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Article> articleList = new ArrayList<Article>();
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from article order by click  desc limit 5";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				
				article.setAid(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setBreviary(rs.getString(3));
				article.setContent(rs.getString(4));
				article.setKeyword(rs.getString(5));
				article.setClick(rs.getInt(6));
				article.setCid(rs.getInt(7));
				article.setCreateTime(rs.getLong(8));
				article.setOrigin(rs.getBoolean(9));
				
				articleList.add(article);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return articleList;
		
	}
	
	@SuppressWarnings("resource")
	public void increaseClick(int aid) throws SQLException {
		/*
		 * 点击量增加
		 * @Param 文章id
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select click from article where aid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			rs = ps.executeQuery();
			if (rs.next()) {
				int newClick = rs.getInt(1);
				newClick++;
				sql = "update article set click=? where aid = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, newClick);
				ps.setInt(2, aid);
				ps.executeUpdate();
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
	}
	
	public List<Article> selectArticlelByCid(int cid) throws SQLException {
		/*
		 * 通过分类id查询文章
		 * @Param 分类id
		 * @Return 文章列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Article> articleList = new ArrayList<Article>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select aid,title,content,keyword,click,cid,createTime from article where cid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				
				article.setAid(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setContent(rs.getString(3));
				article.setKeyword(rs.getString(4));
				article.setClick(rs.getInt(5));
				article.setCid(rs.getInt(6));
				article.setCreateTime(rs.getLong(7));
				
				articleList.add(article);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return articleList;
	}
	
	
	public static void main(String[] args) throws SQLException {


		
		
		
		
	}
}
