package ax.supg.biz.front.web;

import com.opensymphony.xwork2.ActionSupport;

//��Ҫ����/WEB-INF�µ���Դ��action
public class MainAction extends ActionSupport{

	public String execute() {
		return SUCCESS;
	}
	// ��Ӧҳ�涥��
	public String top() {
		return "top";
	}
	// ��Ӧҳ�����˵�
	public String menu() {
		return "menu";
	}

	// ��Ӧҳ���ұ�
	public String index() {
		return "index";
	}
	public String test() {
		return "test";
	}
}
