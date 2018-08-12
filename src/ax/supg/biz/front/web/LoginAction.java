package ax.supg.biz.front.web;

import ax.supg.biz.pojo.User;
import ax.supg.utils.UserContext;



public class LoginAction extends BaseAction{

	   //��װ��¼�û���Ϣ
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	// ��½
		public String login()  {
			// ����service��½
			User userlogin = userService.login(user);
			// �ж�
			if (userlogin != null) {
				// ��½�ɹ�, ���浽session
				UserContext.setUser(userlogin);
				return SUCCESS;
			}else {
				// ��½ʧ�ܣ���Ҫ���������(input)
				return INPUT;
			}
		}
		
		// �˳�
		public String out()  {
			// �˳�
			UserContext.out();
			// �˳���ȥ����½ҳ��
			return INPUT;  
		}
	
	
	
}
