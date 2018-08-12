package ax.supg.biz.front.interceptor;

import ax.supg.biz.pojo.User;
import ax.supg.utils.UserContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * ��¼������
 * @author cumtshuping
 *
 */
public class AuthInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		//��ȡsession�е�¼�û�
		  User user = UserContext.get();  
		if(user!=null){
			return invocation.invoke();
		}
		
		//���û�е�¼���Ͳ����У���ת��"input"��¼��ͼ
	    	return "input";
	}

}
