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
 * 	1. 所有的表示域的map在接收接收
 *  2. 所有的Service，都在这里接收IOC容器注入结果
 * @author AdminTH
 *
 */
public class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{

	//map
   protected Map<String, Object> request;   //保存struts在运行时期注入的表示request的map
   protected Map<String, Object> session;   //保存struts在运行时期注入的表示session的map
   protected Map<String, Object> application;   //保存struts在运行时期注入的表示application的map
   
   // 注入Service对象
  
  
   protected IUserService userService; //用户
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
