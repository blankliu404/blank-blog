package entity;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-08 11:56
 * */
public class Classification {
	/*
	 * 分类实体类
	 * @Param 
	 * cid 分类id
	 * cname 分类名
	 * 
	 * */
	private int cid;
	private String cname;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
