package entity;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-08 10:13
 * */
public class Review {
/*
 * 评论实体类
 *  @Param
 *  rid 评论id
 *  rname 评论人
 *  rsex	评论者性别
 *  rcontent 评论内容
 *  remail 评论人邮箱
 *  rtime 评论时间
 *  torid 被回复id
 *  aid	评论文章id
 * */
	
	private int rid;
	private String rname,rcontent,remail,rsex,torname;

	private long rtime;
	private int torid,aid;
	
	public String getTorname() {
		return torname;
	}
	public void setTorname(String torname) {
		this.torname = torname;
	}
	public String getRsex() {
		return rsex;
	}
	public void setRsex(String rsex) {
		this.rsex = rsex;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRemail() {
		return remail;
	}
	public void setRemail(String remail) {
		this.remail = remail;
	}
	public long getRtime() {
		return rtime;
	}
	public void setRtime(long rtime) {
		this.rtime = rtime;
	}
	public int getTorid() {
		return torid;
	}
	public void setTorid(int torid) {
		this.torid = torid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
}
