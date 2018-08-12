package ax.supg.biz.front.dao.impl;

import java.util.Date;

import ax.supg.biz.front.dao.IIdenFaceDao;
import ax.supg.biz.pojo.IdenCount;

public class IdenFaceDao extends BaseDao<IdenCount> implements IIdenFaceDao{

	
	public void addIdenFace(String uid, String user_info, Double scores,
			String awse,String loginTime) {
		
		IdenCount idenCount = new IdenCount(uid, user_info, scores, awse,loginTime);
		this.getHibernateTemplate().save(idenCount);
	}

}
