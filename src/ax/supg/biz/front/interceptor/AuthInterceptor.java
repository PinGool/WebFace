package ax.supg.biz.front.interceptor;

import ax.supg.biz.pojo.User;
import ax.supg.utils.UserContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 登录拦截器
 * @author cumtshuping
 *
 */
public class AuthInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		//获取session中登录用户
		  User user = UserContext.get();  
		if(user!=null){
			return invocation.invoke();
		}
		
		//如果没有登录，就不放行，跳转到"input"登录视图
	    	return "input";
	}

}
