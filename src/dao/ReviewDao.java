package dao;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-08 16:01
 * */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import entity.Review;
import util.JdbcUtil;
public class ReviewDao {
	
	public boolean insertReview(Review review) throws SQLException {
		/*
		 * 插入单个评论
		 * @Param 评论实体
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into review(rcontent,rname,rsex,remail,rtime,torid,aid,torname) value(?,?,?,?,unix_timestamp(),?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, review.getRcontent());
			ps.setString(2, review.getRname());
			ps.setString(3, review.getRsex());
			ps.setString(4,review.getRemail());
			ps.setInt(5, review.getTorid());
			ps.setInt(6, review.getAid());
			ps.setString(7, review.getTorname());
			ps.executeUpdate();
		} catch(Exception e){ 
			e.printStackTrace();
		}finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	
	public boolean deleteReviewById(int rid) throws SQLException {
		/*
		 * 通过id删除单个评论
		 * @Param 评论rid
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from review where rid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
			int num = ps.executeUpdate();
			
			if(num != 0)
				flag = true;
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	
	public List<Review> selectReviewAll( int id) throws SQLException {
		/*
		 * 查询所有文章aid 为aid 的评论
		 * @Param aid
		 * @Return 评论列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		List<Review> reviewList = new ArrayList<Review>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from review where aid=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Review review = new Review();
				review.setRid(rs.getInt(1));
				review.setRcontent(rs.getString(2));
				review.setRname(rs.getString(3));
				review.setRsex(rs.getString(4));
				review.setRemail(rs.getString(5));
				review.setRtime(rs.getLong(6));
				review.setTorid(rs.getInt(7));
				review.setAid(rs.getInt(8));
				review.setTorname(rs.getString(9));
				reviewList.add(review);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return reviewList;
	}
	
	public List<Review> selectReviewByTorid( int torid) throws SQLException {
		/*
		 * 查询rid下的所有回复
		 * @Param torid
		 * @Return 评论列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		List<Review> reviewList = new ArrayList<Review>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from review where torid=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, torid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Review review = new Review();
				review.setRid(rs.getInt(1));
				review.setRcontent(rs.getString(2));
				review.setRname(rs.getString(3));
				review.setRsex(rs.getString(4));
				review.setRemail(rs.getString(5));
				review.setRtime(rs.getLong(6));
				review.setTorid(rs.getInt(7));
				review.setAid(rs.getInt(8));
				review.setTorname(rs.getString(9));
				reviewList.add(review);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return reviewList;
	}
	public static void main(String[] args) throws SQLException {
		
		/**
		 * Review review = new Review();
		ReviewDao reviewDao = new ReviewDao();
		
		review.setAid(1);
		review.setRcontent("chen");
		review.setRemail("123");
		review.setRid(12);
		review.setRname("wang");
		review.setTorid(3);
		
		
		//reviewDao.insertReview(review);
		System.out.println(reviewDao.insertReview(review));
		 */
		
		//System.out.println(reviewDao.deleteReviewById(12)); 
		
		List<Review> reviewList = new ArrayList<Review>();
		ReviewDao reviewDao2 = new ReviewDao();
		reviewList = reviewDao2.selectReviewAll(1);
		for(Review a : reviewList) {
			System.out.println(a.getAid()+"\t"+a.getRcontent()+"\t"+a.getRemail()+"\t"+a.getRid()+"\t"+a.getRname()+"\t"+a.getRtime()+"\t"+a.getTorid());
			
		}
		System.out.println(reviewDao2.deleteReviewById(12));
		
	}
	
}
