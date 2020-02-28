package entity;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-08 10:04
 * */
public class Link {
	/*
	 * 友情链接实体类
	 * @Param
	 * lid 友情链接id
	 * link 友情锻接地址
	 * */
	private int lid;
	private String link,lname;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
