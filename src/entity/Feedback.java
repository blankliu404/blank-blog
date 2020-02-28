package entity;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-08 10:08
 * */
public class Feedback {
/*
 * 反馈实体类
 * @Param 
 * fid 反馈id
 * ftitle 反馈标题
 * fcontent 反馈内容
 * ftime 反馈时间
 * fsolve 是否解决反馈
 * fsolve_time 解决时间
 * */
	
	private int fid;
	private String ftitle,fcontent;
	private long ftime;
	private String fsolve;
	private long fsolve_time;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public long getFtime() {
		return ftime;
	}
	public void setFtime(long ftime) {
		this.ftime = ftime;
	}
	public String getFsolve() {
		return fsolve;
	}
	public void setFsolve(String fsolve) {
		this.fsolve = fsolve;
	}
	public long getFsolve_time() {
		return fsolve_time;
	}
	public void setFsolve_time(long fsolve_time) {
		this.fsolve_time = fsolve_time;
	}
	
	
}
