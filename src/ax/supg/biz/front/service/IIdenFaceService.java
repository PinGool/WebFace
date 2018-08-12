package ax.supg.biz.front.service;

import java.util.Date;

import ax.supg.biz.pojo.IdenCount;

public interface IIdenFaceService extends IBaseService<IdenCount>{
          
	//记录需用户
	public void addIdenFace(String uid,String user_info,Double scores,String awse,String loginTime);
}
