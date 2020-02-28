package method;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Admin;

/*
 * @author 刘飞 陈新
 * @createTime 2019-07-09 10:09
 * */
public class Login {
	
	public String admin, password;
	
	public boolean islogin(HttpServletRequest request) {
		/**
		 * 登陆验证，判断是否为用户
		 * @param 登传入request对象
		 * @return boolean类型返回值，true登录成功
		 */
		if(request.getParameter("admin")!=null&&request.getParameter("password")!=null) {
			String admin = request.getParameter("admin");
			String password = request.getParameter("password");	//获取用户输入的用户名密码
			
			if(this.admin.equals(admin)&&this.password.equals(MD5_Test.MD5(password))) {
				HttpSession session = request.getSession();
				Admin adminInfo = new Admin();
				adminInfo.setAdmin(admin);
				adminInfo.setPassword(password);
				session.setAttribute("adminInfo", adminInfo);	//登录成功标志设置
				return true;	//登录成功	
			}else
				return false;	//登陆失败
			
		}else 
			return false;	//登陆失败
	}
	
	public Login(ServletContext servletContext) {
		this.admin = servletContext.getInitParameter("admin");
		this.password = servletContext.getInitParameter("password");
	}
}
