package ax.supg.utils;

import java.util.Map;

import ax.supg.biz.pojo.User;

import com.opensymphony.xwork2.ActionContext;
/**
 * 用户上下文 设置session登录工具类
 * @author cumtshuping
 *
 */
public class UserContext {
          
	     //存储到session中的登陆用户的key
	private static final String USER_INF="login_user";
	
	//设置登录用户
	public static void setUser(User user){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put(USER_INF, user);
	}
	
	//退出
	public static void out(){
        Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove(USER_INF);
	}
	
	//获取登录用户
	public static User get(){
		Map<String, Object> session = ActionContext.getContext().getSession();
	    return(User) session.get(USER_INF);
	}
}
