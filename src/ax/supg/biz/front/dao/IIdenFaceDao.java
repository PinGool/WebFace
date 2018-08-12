package ax.supg.biz.front.dao;

import java.util.Date;

import ax.supg.biz.pojo.IdenCount;

public interface IIdenFaceDao extends IBaseDao<IdenCount>{
    
	//记录需用户
	public void addIdenFace(String uid,String user_info,Double scores,String awse,String loginTime);
	
}
