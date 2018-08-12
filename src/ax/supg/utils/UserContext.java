package ax.supg.utils;

import java.util.Map;

import ax.supg.biz.pojo.User;

import com.opensymphony.xwork2.ActionContext;
/**
 * �û������� ����session��¼������
 * @author cumtshuping
 *
 */
public class UserContext {
          
	     //�洢��session�еĵ�½�û���key
	private static final String USER_INF="login_user";
	
	//���õ�¼�û�
	public static void setUser(User user){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put(USER_INF, user);
	}
	
	//�˳�
	public static void out(){
        Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove(USER_INF);
	}
	
	//��ȡ��¼�û�
	public static User get(){
		Map<String, Object> session = ActionContext.getContext().getSession();
	    return(User) session.get(USER_INF);
	}
}
