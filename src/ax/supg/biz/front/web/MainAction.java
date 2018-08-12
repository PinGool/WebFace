package ax.supg.biz.front.web;

import com.opensymphony.xwork2.ActionSupport;

//主要访问/WEB-INF下的资源的action
public class MainAction extends ActionSupport{

	public String execute() {
		return SUCCESS;
	}
	// 对应页面顶部
	public String top() {
		return "top";
	}
	// 对应页面左侧菜单
	public String menu() {
		return "menu";
	}

	// 对应页面右边
	public String index() {
		return "index";
	}
	public String test() {
		return "test";
	}
}
