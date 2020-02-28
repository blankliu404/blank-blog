package dao;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-08 15:05
 * */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import entity.Link;
import util.JdbcUtil;

public class LinkDao {
	public Link selectLinkByID(int lid) throws SQLException {
		/*
		 * 查询单个友情链接
		 * @Param lid
		 * @Return 链接
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Link link = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from link where lid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, lid);
			rs = ps.executeQuery();
			if (rs.next()) {
				link = new Link();
				link.setLid(rs.getInt(1));
				link.setLink(rs.getString(2));
				link.setLname(rs.getString(3));
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return link;
}

	public List<Link> selectLinkAll() throws SQLException {
		/*
		 * 查询所有的友情链接
		 * @Param 无
		 * @Return 连接列表
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		List<Link> linkList = new ArrayList<Link>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from link ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Link link = new Link();
				link.setLid(rs.getInt(1));
				link.setLink(rs.getString(2));
				link.setLname(rs.getString(3));
				linkList.add(link);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return linkList;
}
	
	public boolean deleteLinkById(int lid) throws SQLException {
		/*
		 * 通过id删除单个友情链接
		 * @Param 连接的lid
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from link where lid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, lid);
			int num = ps.executeUpdate();
			
			if(num != 0)
				flag = true;
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	public boolean insertLink(Link link) throws SQLException {
		/*
		 * 插入单个友情链接
		 * @Param 链接实体
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into link(lid,link,lname) value(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, link.getLid());
			ps.setString(2, link.getLink());
			ps.setString(3, link.getLname());
			int num = ps.executeUpdate();
			
			if(num != 0)
				flag = true;
		} catch(SQLIntegrityConstraintViolationException e){ //链接名重复
			flag = false;
		}finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	public boolean updateLink(Link link) throws SQLException {
		/*
		 * 更新单个链接
		 * @Param 链接实体
		 * @Return true or false
		 * */
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update link set lname=?, link = ?where lid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, link.getLname());
			ps.setString(2, link.getLink());
			ps.setInt(3, link.getLid());
			int num = ps.executeUpdate();
			
			if(num != 0)
				flag = true;
		} catch(SQLIntegrityConstraintViolationException e){	//链接名重复
			flag = false;
		}finally {
			JdbcUtil.free(null, ps, conn);
		}
		return flag;
	}
	
	
	public static void main(String[] args) throws SQLException {

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
		
	}

	
	
	
}
