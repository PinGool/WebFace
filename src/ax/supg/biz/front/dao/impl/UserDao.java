package ax.supg.biz.front.dao.impl;

import java.util.List;

import ax.supg.biz.front.dao.IUserDao;
import ax.supg.biz.pojo.User;

public class UserDao extends BaseDao<User> implements IUserDao{

	
	
	
	public void addImg(String file_path, String name, String sex,
			String password, String trueName,  String iptCard,
			String email) {
		
		User user = new User(file_path,name, sex, password, trueName, iptCard, email);
		this.getHibernateTemplate().save(user);
	}

	public User findByTrueName(String trueName) {
		 
		 List<User> list = getHibernateTemplate().find("from User u where u.trueName=?", trueName);
		  
		  return list.get(0);
		  
	}

	
	

	
	
}
