package method;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-11 23:34
 * */

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.ReviewDao;
import entity.Review;

public class ReviewMethod {
	//设置下级评论列表
	public static void setLowListReview(HttpServletRequest request,int rid) throws SQLException{
		ReviewDao reviewDao = new ReviewDao();
		List<Review> lowReviewList = reviewDao.selectReviewByTorid(rid);
		request.setAttribute("lowReviewList", lowReviewList);
	}
}
