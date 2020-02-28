package entity;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-08 10:01
 * */
public class Article {
	/*
	 * 文章实体类
	 * @Param
	 * aid 文章id
	 * title 文章标题
	 * breviary 文章摘要
	 * content 文章内容
	 * keyword 关键词
	 * click 点击量
	 * cid 分类id
	 * createTime 创建时间
	 * createTimef 转换后时间
	 * 
	 * */
	private int aid;
	private String title,content,keyword,breviary;
	private int click;
	private int cid;
	private long createTime;
	private String createTimef;
	private boolean origin;
	
	public boolean getOrigin() {
		return origin;
	}
	public void setOrigin(boolean origin) {
		this.origin = origin;
	}
	public String getBreviary() {
		return breviary;
	}
	public void setBreviary(String breviary) {
		this.breviary = breviary;
	}
	public String getCreateTimef() {
		return createTimef;
	}
	public void setCreateTimef(String createTimef) {
		this.createTimef = createTimef;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeyword() {
		return keyword;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}

	
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	
}
