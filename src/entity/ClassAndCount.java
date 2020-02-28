package entity;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-10 16:14
 * */
public class ClassAndCount {
	/**
	 * 分类 和 分类数量 实体类
	 * @Param
	 * cid 分类id
	 * cnameCount 每个分类的个数
	 * 
	 */

	private int cid;
	private int cnameCount;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCnameCount() {
		return cnameCount;
	}
	public void setCnameCount(int cnameCount) {
		this.cnameCount = cnameCount;
	}
	
	
}
