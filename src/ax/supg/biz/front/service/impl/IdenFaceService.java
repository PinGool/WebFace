package ax.supg.biz.front.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ax.supg.biz.front.dao.IIdenFaceDao;
import ax.supg.biz.front.dao.impl.UserDao;
import ax.supg.biz.front.service.IIdenFaceService;
import ax.supg.biz.pojo.IdenCount;

public class IdenFaceService implements IIdenFaceService{

	//×¢ÈëDao
	private IIdenFaceDao idenFaceDao;
	public void setIdenFaceDao(IIdenFaceDao idenFaceDao) {
		this.idenFaceDao = idenFaceDao;
	}
	
	
	@Override
	public void save(IdenCount t) {
		idenFaceDao.save(t);
		
	}

	@Override
	public void update(IdenCount t) {
		idenFaceDao.update(t);
		
	}

	@Override
	public void delete(Serializable id) {
		idenFaceDao.delete(id);
		
	}

	@Override
	public IdenCount findById(Serializable id) {
		
		return idenFaceDao.findById(id);
	}

	@Override
	public List<IdenCount> getAll() {
		List<IdenCount> list = idenFaceDao.getAll();
		return list;
	}

	@Override
	public void addIdenFace(String uid, String user_info, Double scores,
			String awse,String loginTime) {
		idenFaceDao.addIdenFace(uid, user_info, scores, awse,loginTime);
		
	}

}
