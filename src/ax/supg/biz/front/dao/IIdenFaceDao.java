package ax.supg.biz.front.dao;

import java.util.Date;

import ax.supg.biz.pojo.IdenCount;

public interface IIdenFaceDao extends IBaseDao<IdenCount>{
    
	//��¼���û�
	public void addIdenFace(String uid,String user_info,Double scores,String awse,String loginTime);
	
}
