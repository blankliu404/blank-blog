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

import entity.Classification;
import util.JdbcUtil;

public class ClassificationDao {

	public List<Classification> selectClassAll() throws SQLException {
		/*
		 * 查询所有分类数据
		 * @Return 分类列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Classification> classList = new ArrayList<Classification>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from classification";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Classification classification = new Classification();
				classification.setCid(rs.getInt(1));
				classification.setCname(rs.getString(2));
				classList.add(classification);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return classList;
	}
	
	public Classification findClass() throws SQLException {
		/*
		 * 查询一条分类
		 * @Return 分类列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Classification classification = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from classification limit 1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				classification = new Classification();
				classification.setCid(rs.getInt(1));
				classification.setCname(rs.getString(2));
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return classification;
	}
	
	public Classification selectClassById(int cid) throws SQLException {
		/*
		 * 通过id查询单个分类数据
		 * @Param 分类id
		 * @Return 分类名
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Classification classification = new Classification();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from classification where cid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			if (rs.next()) {
				classification.setCid(rs.getInt(1));
				classification.setCname(rs.getString(2));
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return classification;
	}
	
	public boolean deleteClassById(int cid) throws SQLException {
		/*
		 * 通过id删除单个分类数据
		 * @Param 分类id
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from classification where cid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			int num = ps.executeUpdate();
			
			if(num != 0)
				flag = true;
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	public boolean updateClass(Classification cd) throws SQLException {
		/*
		 * 更新单个数据
		 * @Param 分类实体
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update classification set cname = ?  where cid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cd.getCname());
			ps.setInt(2, cd.getCid());
			int num = ps.executeUpdate();
			
			if(num != 0)
				flag = true;
		} catch(SQLIntegrityConstraintViolationException e){	//分类名重复
			flag = false;
		}finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	public boolean insertClass(String cname) throws SQLException {
		/*
		 * 插入单个数据
		 * @Param 分类名
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into classification(cname) value(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cname);
			int num = ps.executeUpdate();
			
			if(num != 0)
				flag = true;
		} catch(SQLIntegrityConstraintViolationException e){ //分类名重复
			flag = false;
		}finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
}
