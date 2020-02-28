package method;
/*
 * @author 刘飞 陈新
 * @createTime 2019-07-10 11:02
 * */

import java.text.SimpleDateFormat;

public class Time {

	public static String timeShift(long data) {
		/**
		 * 时间转换函数
		 * @param 时间戳 long
		 * @return String 转换过后的时间
		 */
		
		String resultData = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		resultData = simpleDateFormat.format(data*1000);
		
		
		return resultData;
	}
	
}
