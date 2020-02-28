package method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ArticleDao;
import entity.*;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-10 14:43
 * */
public class ArticleMethod{
	public static List<ClassAndCount> findClassAndCount(List<Classification> classificationList){
		//根据分类列表查询分类和计数
		ArticleDao articleDao = new ArticleDao();
		List<ClassAndCount> classAndCountList = new ArrayList<ClassAndCount>();
		for (Classification classification : classificationList) {
			try {
				ClassAndCount classAndCount = articleDao.findClassAndCount(classification);
				classAndCountList.add(classAndCount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return classAndCountList;
	}
}
