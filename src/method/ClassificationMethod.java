package method;

import java.sql.SQLException;

import dao.ClassificationDao;

/*
 * @author 刘飞 陈新
 * @createTime 2019-07-08 11:25
 * */
public class ClassificationMethod {
	public static String cidTocname(int cid) throws SQLException {
		/*
		 * 根据分类id返回对应类名
		 * @Param  分类id
		 * @Return 分类名
		 * */
		ClassificationDao classificationDao = new ClassificationDao();
		
		String cname = classificationDao.selectClassById(cid).getCname();
		
		return cname;
		
	}
}
