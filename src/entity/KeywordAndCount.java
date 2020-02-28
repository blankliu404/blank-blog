package entity;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-10 16:50
 * */

public class KeywordAndCount {
	/*
	 * keyword 和 关键词数量 实体类
	 * @Param 
	 * keyword 关键词
	 * keywordCount 关键词数量
	 * */
	private String keyword;
	private int keywordCount;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getKeywordCount() {
		return keywordCount;
	}
	public void setKeywordCount(int keywordCount) {
		this.keywordCount = keywordCount;
	}
	
}
