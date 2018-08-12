package ax.supg.biz.front.web;

import ax.supg.biz.pojo.User;
import ax.supg.utils.UserContext;



public class LoginAction extends BaseAction{

	   //封装登录用户信息
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	// 登陆
		public String login()  {
			// 调用service登陆
			User userlogin = userService.login(user);
			// 判断
			if (userlogin != null) {
				// 登陆成功, 保存到session
				UserContext.setUser(userlogin);
				return SUCCESS;
			}else {
				// 登陆失败，需要更多的输入(input)
				return INPUT;
			}
		}
		
		// 退出
		public String out()  {
			// 退出
			UserContext.out();
			// 退出后去到登陆页面
			return INPUT;  
		}
	
	
	
}
