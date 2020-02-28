package dao;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-08 16:37
 * */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import entity.Feedback;

import util.JdbcUtil;
public class FeedbackDao {
	
	public Feedback selectFeedBackById(int fid) throws SQLException {
		/*
		 * 查询单个反馈
		 * @Return 反馈实体
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Feedback feedback = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from feedback where fid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				feedback = new Feedback();
				feedback.setFid(rs.getInt(1));
				feedback.setFtitle(rs.getString(2));
				feedback.setFcontent(rs.getString(3));
				feedback.setFtime(rs.getLong(4));
				feedback.setFsolve(rs.getString(5));
				feedback.setFsolve_time(rs.getLong(6));
				
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return feedback;
	}
	
	
	public List<Feedback> selectFeedBackAll( ) throws SQLException {
		/*
		 * 查询所有反馈
		 * @Return 反馈列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Feedback>feedbackList = new ArrayList<Feedback>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from feedback ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				Feedback feedback = new Feedback();
				feedback.setFid(rs.getInt(1));
				feedback.setFtitle(rs.getString(2));
				feedback.setFcontent(rs.getString(3));
				feedback.setFtime(rs.getLong(4));
				feedback.setFsolve(rs.getString(5));
				feedback.setFsolve_time(rs.getLong(6));
				feedbackList.add(feedback);
				
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return feedbackList;
	}
	
	
	public boolean updateFeedback(Feedback feedback) throws SQLException {
		/*
		 * 更新单个反馈  
		 * @Param 反馈实体
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update feedback set fsolve = ?,fsolve_time = unix_timestamp() where fid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, feedback.getFsolve());
			ps.setInt(2, feedback.getFid());
			int num = ps.executeUpdate();
			if(num != 0)
				flag = true;
		} catch(SQLIntegrityConstraintViolationException e){	//反馈更新失败
			flag = false;
		}finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	public boolean insertFeedback(Feedback feedback) throws SQLException {
		/*
		 * 插入单个反馈
		 * @Param 反馈实体
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into feedback(ftitle,fcontent,ftime) value(?,?,unix_timestamp())";
			ps = conn.prepareStatement(sql);
			ps.setString(1, feedback.getFtitle());
			ps.setString(2, feedback.getFcontent());
			int num = ps.executeUpdate();
			if(num != 0)
				flag = true;
		} catch(SQLIntegrityConstraintViolationException e){ //反馈插入失败
			flag = false;
		}finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	public boolean deleteFeedbackById(int fid) throws SQLException {
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
			String sql = "delete from feedback where fid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			int num = ps.executeUpdate();
			if(num != 0)
				flag = true;
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	public static void main(String[] args) throws SQLException {

		/*
		 *
		LinkDao linkDao = new LinkDao();
		Link link = new Link();
		link.setLid(1);
		link.setLink("12345");
		boolean b = linkDao.updateLink(link);
		System.out.println(b);
		
		
		List<Link> list = linkDao.selectLinkAll();
		for(Link a : list) {
			System.out.println(a.getLid()+"\t"+a.getLink());
		}
		
		System.out.println(linkDao.deleteLinkById(1));
		
		System.out.println(linkDao.insertLink(link));
		 * 
		 * */
		
		/**
		 * Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//���Է�����޸����ڸ�ʽ
		String hehe = dateFormat.format( now ); 
		System.out.println(hehe); 
		 */
		
		/**
		 * Feedback feedback = new Feedback();
		FeedbackDao feedbackDao = new FeedbackDao();
		feedback.setFcontent("33333");
		feedback.setFsolve("false");
		//feedback.setFtime(123345);
		//feedback.setFsolve_time(12345);
		//feedbackDao.insertFeedback(feedback);
		System.out.println(feedbackDao.insertFeedback(feedback));
		
		List<Feedback> feedbackList = new ArrayList<Feedback>();
		feedbackList = feedbackDao.selectFeedBackAll();
		for(Feedback a : feedbackList) {
			System.out.println(a.getFcontent()+"\t"+a.getFtime()+"\t"+a.getFsolve()+"\t"+a.getFsolve_time());
			System.out.println("*******************************");
			//System.out.println(a.getFcontent()+"\t"+a.getFsolve());
		}
		 */
		
		FeedbackDao feedbackDao = new FeedbackDao();
		Feedback feedback2 = new Feedback();
		feedback2.setFcontent("chen");
		feedback2.setFid(3);
		feedbackDao.updateFeedback(feedback2);
		feedbackDao.deleteFeedbackById(3);
	}

}
