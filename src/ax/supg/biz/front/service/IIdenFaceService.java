package ax.supg.biz.front.service;

import java.util.Date;

import ax.supg.biz.pojo.IdenCount;

public interface IIdenFaceService extends IBaseService<IdenCount>{
          
	//��¼���û�
	public void addIdenFace(String uid,String user_info,Double scores,String awse,String loginTime);
}
