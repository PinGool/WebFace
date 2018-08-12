package ax.supg.biz.front.service.impl;

import java.io.Serializable;
import java.util.List;

import ax.supg.biz.front.dao.IUserDao;
import ax.supg.biz.front.service.IUserService;
import ax.supg.biz.pojo.User;

public class UserService implements IUserService{

	// ע��Dao
	private IUserDao userDao;
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	
	@Override
	public void save(User t) {
		userDao.save(t);
		
	}

	@Override
	public void update(User t) {
		userDao.update(t);		
	}

	@Override
	public void delete(Serializable id) {
		userDao.delete(id);		
	}

	@Override
	public User findById(Serializable id) {		
		return userDao.findById(id);
	}

	@Override
	public List<User> getAll() {
		List<User> list = userDao.getAll();
		return list;
	}






	public void addImg(String file_path, String name, String sex,
			String password, String trueName,  String iptCard,
			String email) {
		userDao.addImg(file_path, name, sex, password,trueName,iptCard, email);
	
	}


	public User findByTrueName(String trueName) {
		
		return userDao.findByTrueName(trueName);
	}


	public User login(User user) {
		//hql��ѯ
		String hql="from User where name=? and password=?";
		//����dao������ѯ����
		List<User> list = userDao.getByCondition(hql, user.getName(),user.getPassword());
		//�ж�
		if(list!=null && list.size()>0){
			//��¼�ɹ������ؼ��ϵ�һ��Ԫ��
			return list.get(0);
		}
		//��¼ʧ��
		return null;
	}


	

}
