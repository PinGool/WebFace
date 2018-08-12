package ax.supg.biz.front.web;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import ax.supg.biz.front.service.IIdenFaceService;
import ax.supg.biz.front.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;
/**
 * BaseAction, 
 * 	1. ���еı�ʾ���map�ڽ��ս���
 *  2. ���е�Service�������������IOC����ע����
 * @author AdminTH
 *
 */
public class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{

	//map
   protected Map<String, Object> request;   //����struts������ʱ��ע��ı�ʾrequest��map
   protected Map<String, Object> session;   //����struts������ʱ��ע��ı�ʾsession��map
   protected Map<String, Object> application;   //����struts������ʱ��ע��ı�ʾapplication��map
   
   // ע��Service����
  
  
   protected IUserService userService; //�û�
   public void setUserService(IUserService userService) {
	this.userService = userService;
}
 
	protected IIdenFaceService idenFaceService;
	
   public void setIdenFaceService(IIdenFaceService idenFaceService) {
	this.idenFaceService = idenFaceService;
}
		
   public void setRequest(Map<String, Object> request) {
			this.request=request;
		}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	

	public void setApplication(Map<String, Object> application) {
		this.application=application;
	}

}
